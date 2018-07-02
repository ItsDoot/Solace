package solace.java.util

import java.util.*

inline val String.uuid
    get() = UUID.fromString(this)