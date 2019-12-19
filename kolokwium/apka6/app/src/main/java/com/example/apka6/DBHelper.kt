package com.example.apka6

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class DBHelper(context: Context,
               factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATA_BASE_NAME,
        factory, DATA_BASE_VERSION) {

    companion object{
        internal const val DATA_BASE_NAME = "BasDATAKAI.db"
        internal const val DATA_BASE_VERSION = 1
        internal const val TABLE_NAME = "Tasks"
        internal const val COL_ID = "id"
        internal const val COL_NAME = "name"
        internal const val COL_PRIORITY = "priority"
        internal const val COL_STATE = "state"
        internal const val COL_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val create_tasks_table = (
                "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, $COL_PRIORITY TEXT, $COL_STATE TEXT, $COL_DATE TEXT)"
                )
        db!!.execSQL(create_tasks_table)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
    fun addTask(act : SingleTask){
        Log.d("sdg", act.taskName)
        val values = ContentValues()
        values.put(COL_ID, act.taskid)
        values.put(COL_NAME, act.taskName)
        values.put(COL_PRIORITY, act.taskPriority)
        values.put(COL_STATE, act.taskState)
        values.put(COL_DATE, act.taskDate)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()


    }

    val allActivities : MutableList<SingleTask>
        get() {
            var activitiesList = mutableListOf<SingleTask>()
            val db = this.readableDatabase
            val cursor = db!!.rawQuery(" SELECT * FROM $TABLE_NAME", null)

            if(cursor.moveToFirst()){
                do{
                    val id = cursor.getLong(cursor.getColumnIndex(COL_ID))
                    val name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    val priority = cursor.getString(cursor.getColumnIndex(COL_PRIORITY))
                    val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                    val date = cursor.getString(cursor.getColumnIndex(COL_DATE))
                    activitiesList.add(SingleTask(name, priority, state, date ,id))
                }while(cursor.moveToNext())
            }
            db.close()

            return activitiesList
        }

    fun delUser(id:String){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE $COL_ID='" + id + "'")
        db.close()
    }

    fun editUser(act: SingleTask, id: String){
        val db= this.writableDatabase
        db.execSQL("UPDATE " + TABLE_NAME
                + " SET $COL_NAME='" + act.taskName + "', $COL_PRIORITY='" + act.taskPriority
                + "', $COL_STATE='" + act.taskState + "', $COL_DATE='" + act.taskDate
                + "' WHERE $COL_ID='" + id + "'")
    }

}