@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.scoreboard

import org.spongepowered.api.scoreboard.Score

inline operator fun Score.inc(): Score = apply { score += 1 }
inline operator fun Score.dec(): Score = apply { score -= 1 }

inline operator fun Score.plusAssign(n: Int) {
    score += n
}

inline operator fun Score.minusAssign(n: Int) {
    score -= n
}

inline operator fun Score.timesAssign(n: Int) {
    score *= n
}

inline operator fun Score.divAssign(n: Int) {
    score /= n
}

inline operator fun Score.remAssign(n: Int) {
    score %= n
}

inline operator fun Score.plus(n: Int): Int = score + n
inline operator fun Score.minus(n: Int): Int = score - n
inline operator fun Score.times(n: Int): Int = score * n
inline operator fun Score.div(n: Int): Int = score / n
inline operator fun Score.rem(n: Int): Int = score % n

inline operator fun Score.compareTo(n: Int): Int = score.compareTo(n)
inline operator fun Score.compareTo(other: Score): Int = score.compareTo(other.score)

inline operator fun Score.unaryPlus(): Int = +score
inline operator fun Score.unaryMinus(): Int = -score