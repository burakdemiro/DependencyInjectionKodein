package com.example.dependencyinjectionkodein.data.db

// Database'i singleton yapmana gerek yok, Kodein bunu ele alacak (ThreadSafe ile birlikte)
class DatabaseFakeImpl: Database {
    // Burada DI'ye gerek yok, FakeDatabase her zaman FakeDao objesini isteyecek
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}