@file:Suppress("NOTHING_TO_INLINE")

package solace.sponge.scoreboard

import org.spongepowered.api.scoreboard.Team
import org.spongepowered.api.text.Text

inline operator fun Team.plusAssign(member: Text) {
    addMember(member)
}

inline operator fun Team.minusAssign(member: Text) {
    removeMember(member)
}

inline operator fun Team.minus(member: Text): Boolean = removeMember(member)

inline operator fun Team.contains(member: Text): Boolean = member in this.members