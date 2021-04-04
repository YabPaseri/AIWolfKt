package tk.yabpaseri.aiwolfkt.common

import org.aiwolf.common.data.*
import org.aiwolf.common.net.GameInfo

/**
 * org.aiwolf.common.net.GameInfo のプラットフォーム型の対処。
 * GameInfoは不変なので、MutableListなどにならないようにする目的もある。
 * これより細かな部分(Agent, Judge, Vote...)はプラットフォーム型でも影響がないと考えて未実装。
 * GameInfoToSend.toGameInfo() も見てNullableかを決めた。
 *
 * 元になったgameInfoを残してあるのは、
 * GameInfoを構築するには、GameInfoToSendを作る必要があり
 * GameInfoKt->GameInfoToSend->GameInfoの手順で戻すのは
 * ただただ手間だから。
 */

class GameInfoKt(val gameInfo: GameInfo) {
    val day: Int = gameInfo.day
    val role: Role = gameInfo.role
    val agent: Agent = gameInfo.agent
    val agentList: List<Agent> = gameInfo.agentList
    val mediumResult: Judge? = gameInfo.mediumResult
    val divineResult: Judge? = gameInfo.divineResult
    val executedAgent: Agent? = gameInfo.executedAgent
    val attackedAgent: Agent? = gameInfo.attackedAgent
    val guardedAgent: Agent? = gameInfo.guardedAgent
    val voteList: List<Vote> = gameInfo.voteList
    val attackVoteList: List<Vote> = gameInfo.attackVoteList
    val talkList: List<Talk> = gameInfo.talkList
    val whisperList: List<Talk> = gameInfo.whisperList
    val aliveAgentList: List<Agent> = gameInfo.aliveAgentList
    val statusMap: Map<Agent, Status> = gameInfo.statusMap
    val roleMap: Map<Agent, Role> = gameInfo.roleMap
    val lastDeadAgentList: List<Agent> = gameInfo.lastDeadAgentList
    val existingRoles: List<Role> = gameInfo.existingRoles
    val remainTalkMap: Map<Agent, Int> = gameInfo.remainTalkMap
    val remainWhisperMap: Map<Agent, Int> = gameInfo.remainWhisperMap
    val latestVoteList: List<Vote> = gameInfo.latestVoteList
    val latestAttackVoteList: List<Vote> = gameInfo.latestAttackVoteList
    val latestExecutedAgent: Agent? = gameInfo.latestExecutedAgent
    val cursedFox: Agent? = gameInfo.cursedFox
}