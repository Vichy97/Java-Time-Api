package com.vincent.javatime

import com.vincent.javatime.db.dbModule
import com.vincent.javatime.repository.FactRepository
import com.vincent.javatime.repository.SuggestionRepository
import com.vincent.javatime.repository.repositoryModule
import com.vincent.javatime.routes.factsRoute
import com.vincent.javatime.routes.suggestionsRoute
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject

fun Application.main() {
    install(ContentNegotiation) {
        jackson {}
    }
    install(DefaultHeaders)
    install(CallLogging)
}

fun Application.koin() {
    install(Koin) {
        modules(listOf(dbModule, repositoryModule))
    }
}

fun Application.routes() {
    val suggestionRepository: SuggestionRepository by inject()
    val factRepository: FactRepository by inject()

    routing {
        get("/") {
            call.respondText("debug")
        }
        factsRoute(factRepository)
        suggestionsRoute(suggestionRepository)
    }
}

fun main() {
    val port = Integer.valueOf(System.getenv("PORT"))
    embeddedServer(factory = Netty, port = port) {}.start()
}



