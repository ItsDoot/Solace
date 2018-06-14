package pw.dotdash.solace.java

import java.util.*

inline val String.uuid
    get() = UUID.fromString(this)