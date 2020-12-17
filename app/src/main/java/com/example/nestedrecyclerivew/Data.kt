package com.example.nestedrecyclerivew

data class InsideData(
    val title:String
)

data class ParentData(
    val title:String,
    val subTitle:String
)

val insideList = mutableListOf<InsideData>()
val parentList = mutableListOf<ParentData>()

fun createInsideData(){
    for(i in 0 until 10){
        insideList.add(InsideData("WangWang"))
    }
}

fun createParentData(){

    parentList.add(ParentData("",""))
    for(i in 0 until 10){
        parentList.add(ParentData("WangWang","第${i}個item"))
    }
}