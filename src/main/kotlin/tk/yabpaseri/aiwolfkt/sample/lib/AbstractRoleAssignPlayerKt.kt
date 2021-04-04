package tk.yabpaseri.aiwolfkt.sample.lib

import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Role
import org.aiwolf.common.net.GameSetting
import org.aiwolf.sample.player.*
import tk.yabpaseri.aiwolfkt.common.GameInfoKt
import tk.yabpaseri.aiwolfkt.common.PlayerKt

/**
 * org.aiwolf.sample.lib.AbstractRoleAssignPlayer のPlayerKtバージョン。
 * SamplePlayerを用意するのは後回し...
 */
abstract class AbstractRoleAssignPlayerKt: PlayerKt() {
    var villagerPlayer: PlayerKt = PlayerKtConverter(SampleVillager::class)
    var seerPlayer: PlayerKt = PlayerKtConverter(SampleSeer::class)
    var mediumPlayer: PlayerKt = PlayerKtConverter(SampleMedium::class)
    var bodyguardPlayer: PlayerKt = PlayerKtConverter(SampleBodyguard::class)
    var possessedPlayer: PlayerKt = PlayerKtConverter(SamplePossessed::class)
    var werewolfPlayer: PlayerKt = PlayerKtConverter(SampleWerewolf::class)
    private lateinit var rolePlayer: PlayerKt

    abstract override fun getName(): String

    override fun update(gameInfoKt: GameInfoKt)
        = rolePlayer.update(gameInfoKt)

    override fun initialize(gameInfoKt: GameInfoKt, gameSetting: GameSetting) {
        val role = gameInfoKt.role
        rolePlayer = when (role) {
            Role.BODYGUARD -> bodyguardPlayer
            Role.VILLAGER -> villagerPlayer
            Role.MEDIUM -> mediumPlayer
            Role.POSSESSED -> possessedPlayer
            Role.SEER -> seerPlayer
            Role.WEREWOLF -> werewolfPlayer
            else -> villagerPlayer
        }
        rolePlayer.initialize(gameInfoKt, gameSetting)
    }

    override fun dayStart()
        = rolePlayer.dayStart()

    override fun talk(): String
        = rolePlayer.talk()

    override fun whisper(): String
        = rolePlayer.whisper()

    override fun vote(): Agent
        = rolePlayer.vote()

    override fun attack(): Agent
        = rolePlayer.attack()

    override fun divine(): Agent
        = rolePlayer.divine()

    override fun guard(): Agent
        = rolePlayer.guard()

    override fun finish()
        = rolePlayer.finish()

}