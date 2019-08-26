package com.vincent.javatime.repository

import com.mongodb.client.MongoCollection
import com.vincent.javatime.models.Suggestion

class SuggestionRepository(private val suggestionCollection: MongoCollection<Suggestion>) {

    fun getSuggestions(): List<Suggestion> {
        return suggestionCollection
            .find()
            .filterNotNull()
            .toList()
    }

    fun addSuggestion(suggestion: Suggestion) {
        suggestionCollection.insertOne(suggestion)
    }
}