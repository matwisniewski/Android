package com.example.test

class User(var name:String, var surname:String, var ID:Int){
    override fun toString(): String {
        return "$ID $name  $surname"
    }
}