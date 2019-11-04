package com.vincent.javatime.db

import com.mongodb.MongoClient
import com.mongodb.MongoClientOptions
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase

import com.vincent.javatime.models.Fact
import com.vincent.javatime.models.Suggestion

import org.koin.dsl.module
import org.litote.kmongo.*

private const val FACTS_COLLECTION = "facts"
private const val SUGGESTIONS_COLLECTION = "suggestions"

val dbModule = module {

    single<MongoCollection<Suggestion>> {
        get<MongoDatabase>().getCollection<Suggestion>(SUGGESTIONS_COLLECTION)
    }

    single<MongoCollection<Fact>> {
        get<MongoDatabase>().getCollection<Fact>(FACTS_COLLECTION)
    }

    single<MongoDatabase> {
        val databaseName = get<MongoClientURI>().database ?: ""
        get<MongoClient>().getDatabase(databaseName)
    }

    single<MongoClient> {
        KMongo.createClient(get<MongoClientURI>())
    }

    single<MongoClientURI> {
        val optionsBuilder = MongoClientOptions.builder()
            .retryWrites(false)
        MongoClientURI(System.getenv("MONGODB_URI"), optionsBuilder)
    }
}