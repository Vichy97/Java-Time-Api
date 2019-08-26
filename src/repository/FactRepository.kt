package com.vincent.javatime.repository

import com.mongodb.client.MongoCollection
import com.vincent.javatime.models.Fact

class FactRepository(private val factCollection: MongoCollection<Fact>) {

    fun getFacts(): List<Fact> {
        return factCollection
            .find()
            .filterNotNull()
            .toList()
    }
}