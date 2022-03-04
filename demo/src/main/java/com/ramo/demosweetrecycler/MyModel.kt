package com.ramo.demosweetrecycler

import com.ramo.sweetrecycler.Identifiable
import java.util.*

data class MyModel(
    val title: String,
    val isUser: Boolean,
) : Identifiable {
    override val id: String
        get() = UUID.randomUUID().toString()
}