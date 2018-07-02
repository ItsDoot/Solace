@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.scoreboard

import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.scoreboard.objective.Objective
import org.spongepowered.api.text.Text
import solace.java.util.unwrapped

inline operator fun Objective.plusAssign(score: Score) {
    addScore(score)
}

inline operator fun Objective.minusAssign(score: Score) {
    removeScore(score)
}

inline operator fun Objective.minusAssign(name: Text) {
    removeScore(name)
}

inline operator fun Objective.minus(score: Score) = removeScore(score)
inline operator fun Objective.minus(name: Text) = removeScore(name)

inline operator fun Objective.get(name: Text): Score? = getScore(name).unwrapped

inline operator fun Objective.contains(name: Text): Boolean = hasScore(name)
inline operator fun Objective.contains(score: Score): Boolean = score in this.scores.values