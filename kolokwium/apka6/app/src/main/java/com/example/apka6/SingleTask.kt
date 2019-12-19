package com.example.apka6

class SingleTask(var taskName : String, var taskPriority : String, var taskState : String, var taskDate : String, var taskid:Long?=null) {
   enum class taskPriorioty(val priority: String){
        High(R.string.set_State_Big.toString()),
        Medium(R.string.set_State_Medium.toString()),
        Low(R.string.set_State_Low.toString())
    }
}