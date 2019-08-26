package com.vincent.javatime.repository

import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {

    single {
        FactRepository(get(named("facts")))
    }

    single {
        SuggestionRepository(get(named("suggestions")))
    }
}