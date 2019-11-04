package com.vincent.javatime.repository

import com.mongodb.client.MongoCollection
import com.vincent.javatime.db.FACTS
import com.vincent.javatime.db.SUGGESTIONS
import com.vincent.javatime.models.Fact
import com.vincent.javatime.models.Suggestion

import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    single<FactRepository> {
        FactRepository(get<MongoCollection<Fact>>(named(FACTS)))
    }

    single<SuggestionRepository> {
        SuggestionRepository(get<MongoCollection<Suggestion>>(named(SUGGESTIONS)))
    }
}