package com.ramo.demosweetrecycler

object MockService {

    fun getMockList(): List<MyModel> {
        val dataList = mutableListOf(
            MyModel("Ramo", true),
            MyModel("Mehmet", true),
            MyModel("Cafer", true),
            MyModel("Bilgilsayar", false),
            MyModel("Şakir", true),
            MyModel("Ketıl", false),
        )
        for (i in 0..80) {
            dataList.add(dataList.random())
        }
        dataList.shuffle()
        return dataList.toList()
    }
}