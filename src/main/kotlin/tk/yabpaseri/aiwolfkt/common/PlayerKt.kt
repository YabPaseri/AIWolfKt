package tk.yabpaseri.aiwolfkt.common

import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Player
import org.aiwolf.common.net.GameInfo
import org.aiwolf.common.net.GameSetting

/**
 * org.aiwolf.common.data.Player のラッパー。
 * プラットフォーム型をNonNullに置き換える役割と、GameInfoをGameInfoKtに置き換える。
 * 既存のupdateやinitializeをfinalにするために、interfaceではなくabstract class。
 */
abstract class PlayerKt: Player {
    abstract override fun getName(): String

    abstract fun update(gameInfoKt: GameInfoKt)
    final override fun update(gameInfo: GameInfo)
        = update(gameInfo.toKt())

    abstract fun initialize(gameInfoKt: GameInfoKt, gameSetting: GameSetting)
    final override fun initialize(gameInfo: GameInfo, gameSetting: GameSetting)
        = initialize(gameInfo.toKt(), gameSetting)

    abstract override fun dayStart()

    abstract override fun talk(): String

    abstract override fun whisper(): String

    abstract override fun vote(): Agent

    abstract override fun attack(): Agent

    abstract override fun divine(): Agent

    abstract override fun guard(): Agent

    abstract override fun finish()

    private fun GameInfo.toKt() = GameInfoKt(this)
}