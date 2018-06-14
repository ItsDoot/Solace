package pw.dotdash.solace.configurate.hocon

import ninja.leaping.configurate.hocon.HoconConfigurationLoader
import java.io.File
import java.net.URL
import java.nio.file.Path

inline fun HoconConfigurationLoader(building: HoconConfigurationLoader.Builder.() -> Unit): HoconConfigurationLoader =
        HoconConfigurationLoader.builder().apply(building).build()

inline val Path.hoconConfigurationLoader: HoconConfigurationLoader
    get() = HoconConfigurationLoader.builder().setPath(this).build()

inline val File.hoconConfigurationLoader: HoconConfigurationLoader
    get() = HoconConfigurationLoader.builder().setFile(this).build()

inline val URL.hoconConfigurationLoader: HoconConfigurationLoader
    get() = HoconConfigurationLoader.builder().setURL(this).build()