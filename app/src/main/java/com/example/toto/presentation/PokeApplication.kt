package com.example.toto.presentation

import android.app.Application
import android.content.Context
import java.net.ContentHandler

class PokeApplication : Application(){
    companion object{
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}