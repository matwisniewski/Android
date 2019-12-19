package com.example.test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val SQL_CREATE = "CREATE TABLE $TABLE_NAME ( ID INTEGER PRIMARY KEY, NAME TEXT, SURNAME TEXT )"
    }

    companion object{
        const val DATABASE_NAME = "usersDB"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"
    }
}
