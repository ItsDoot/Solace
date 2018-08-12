package pw.dotdash.solace

import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.Platform
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state.GameInitializationEvent
import org.spongepowered.api.plugin.Plugin
import solace.java.util.unwrapped
import solace.sponge.container
import solace.sponge.plugin.pluginContainer

@Plugin(id = "solace", name = "Solace", version = "3.6.0",
        description = "A Kotlin extension library for use with Sponge.",
        url = "https://github.com/xDotDash/Solace",
        authors = ["DotDash"])
class Solace {

    @Inject
    lateinit var logger: Logger

    @Listener
    fun onInit(event: GameInitializationEvent) {
        val api = Platform.Component.API.container
        val impl = Platform.Component.IMPLEMENTATION.container
        val game = Platform.Component.GAME.container

        logger.info("Solace, a Kotlin extension library.")
        logger.info(" - ${this.pluginContainer?.name} version ${this.pluginContainer?.version?.unwrapped}")
        logger.info(" - ${api.name} version ${api.version.unwrapped}")
        logger.info(" - ${impl.name} version ${impl.version.unwrapped}")
        logger.info(" - ${game.name} version ${game.version.unwrapped}")
    }
}