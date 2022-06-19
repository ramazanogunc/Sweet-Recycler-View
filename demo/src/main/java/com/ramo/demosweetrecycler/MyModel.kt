package com.ramo.demosweetrecycler

import com.ramo.sweetrecycler.SweetDiff
import java.util.*

data class MyModel(
    val title: String,
    val isUser: Boolean,
) : SweetDiff {
    override val diffId: String
        get() = UUID.randomUUID().toString()
}