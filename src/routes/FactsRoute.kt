package com.vincent.javatime.routes

import com.vincent.javatime.repository.FactRepository
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.factsRoute(factsRepository: FactRepository) {

    get("/facts/") {
        call.respond(factsRepository.getFacts())
    }
}