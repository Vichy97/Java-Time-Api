package com.vincent.javatime.db

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import com.vincent.javatime.models.Fact
import com.vincent.javatime.models.Suggestion
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.litote.kmongo.*

val dbModule = module {

    val databaseName= "local"
    val factCollection = "facts"
    val suggestionCollection = "suggestions"

    single(named("suggestions")) {
        get<MongoDatabase>().getCollection<Suggestion>(suggestionCollection)
    }

    single(named("facts")) {
        get<MongoDatabase>().getCollection<Fact>(factCollection)
    }

    single {
        get<MongoClient>().getDatabase("heroku_cb6tk21z")
    }

    single {
        KMongo.createClient(System.getenv("MONGODB_URI"))
    }
}