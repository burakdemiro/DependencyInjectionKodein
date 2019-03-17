package com.example.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dependencyinjectionkodein.data.model.Quote

class QuoteDaoFakeImpl: QuoteDao {

    // Encapsulation
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    // Hemen bir atama yapıyorum böylece dışardan observed olabilir
    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList // Update the MutableLiveData which will notify active observers
    }

    override fun getQuotes(): LiveData<List<Quote>> = quotes // auto-casting

}