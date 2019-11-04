package com.vincent.javatime.repository

import com.vincent.javatime.db.FACTS
import com.vincent.javatime.db.SUGGESTIONS

import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    single<FactRepository> {
        FactRepository(get(named(FACTS)))
    }

    single<SuggestionRepository> {
        SuggestionRepository(get(named(SUGGESTIONS)))
    }
}