package tk.yabpaseri.aiwolfkt.sample.lib

import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Player
import org.aiwolf.common.data.Role
import org.aiwolf.common.data.Talk
import org.aiwolf.common.net.GameSetting
import tk.yabpaseri.aiwolfkt.common.GameInfoKt
import tk.yabpaseri.aiwolfkt.common.PlayerKt
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

/**
 * 既存のPlayerをPlayerKtとして動かす。
 */
class PlayerKtConverter<T: Player>(clazz: KClass<T>): PlayerKt() {
    private val player = clazz.createInstance()
    private lateinit var info: GameInfoKt
    private fun GameInfoKt.aliveOthers()
        = info.aliveAgentList.filter { it != info.agent }

    override fun getName(): String
        = player.name ?: "PlayerKtConverter"

    override fun update(gameInfoKt: GameInfoKt) {
        info = gameInfoKt
        player.update(gameInfoKt.gameInfo)
    }

    override fun initialize(gameInfoKt: GameInfoKt, gameSetting: GameSetting)
        = player.initialize(gameInfoKt.gameInfo, gameSetting)

    override fun dayStart()
        = player.dayStart()

    override fun talk(): String
        = player.talk() ?: Talk.SKIP

    override fun whisper(): String
        = player.whisper() ?: Talk.SKIP

    override fun vote(): Agent
        = player.vote() ?: info.aliveOthers().random()

    override fun attack(): Agent
        = player.attack()
            ?: info.aliveOthers()
                .filter { info.roleMap[it] != Role.WEREWOLF }
                .random()


    override fun divine(): Agent
        = player.divine() ?: info.aliveOthers().random()

    override fun guard(): Agent
        = player.divine() ?: info.aliveOthers().random()

    override fun finish() = player.finish()

}