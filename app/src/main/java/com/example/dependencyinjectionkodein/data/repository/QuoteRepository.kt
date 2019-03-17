package com.example.dependencyinjectionkodein.data.repository

import androidx.lifecycle.LiveData
import com.example.dependencyinjectionkodein.data.model.Quote

// Birden fazla Dao objen olabilir, Repository bunları tutan collection
interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}