package com.example.dependencyinjectionkodein

import android.app.Application
import com.example.dependencyinjectionkodein.data.db.Database
import com.example.dependencyinjectionkodein.data.db.DatabaseFakeImpl
import com.example.dependencyinjectionkodein.data.db.QuoteDao
import com.example.dependencyinjectionkodein.data.db.QuoteDaoFakeImpl
import com.example.dependencyinjectionkodein.data.repository.QuoteRepository
import com.example.dependencyinjectionkodein.data.repository.QuoteRepositoryImpl
import com.example.dependencyinjectionkodein.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

// DI binding'leri Application class'ı içerisinde olmalı çünkü Application class'ına her component tarafından erişilebilir
class QuotesApplication: Application(), KodeinAware {
    // İhtiyaç duyulduğunda instantiate edilir. (Lazy)
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() } // Database'e ulaşmak istediğinde zaten bura tarafından nesne yaratılmış olucak
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao } // Bütün Dao'lar Database içerisinde zaten oradan seç
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) } // Bu interface'in implementasyonu yukarda zaten mevcut
        bind() from provider { QuotesViewModelFactory(instance()) } // provider singleton'ın tam tersidir her seferinde yeni nesne üretir, aynı class'ı bağladım
    }

}