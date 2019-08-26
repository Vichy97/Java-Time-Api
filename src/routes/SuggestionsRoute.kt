package com.vincent.javatime.routes

import com.vincent.javatime.models.Suggestion
import com.vincent.javatime.repository.SuggestionRepository
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post

fun Routing.suggestionsRoute(suggestionRepository: SuggestionRepository) {

    get("/suggestions/") {
        call.respond(suggestionRepository.getSuggestions())
    }

    post("/suggestions/") {
        val suggestion = call.receive(Suggestion::class)
        suggestionRepository.addSuggestion(suggestion)
    }
}