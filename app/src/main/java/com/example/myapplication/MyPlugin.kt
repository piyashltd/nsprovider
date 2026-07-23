package com.example.myapplication

import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin
import android.content.Context

@CloudstreamPlugin
class MyPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(MyCustomProvider())
    }
}
