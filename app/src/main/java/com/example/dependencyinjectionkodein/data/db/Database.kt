package com.example.dependencyinjectionkodein.data.db

// Hold all Dao's
interface Database {
    val quoteDao: QuoteDao
}