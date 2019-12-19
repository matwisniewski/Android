package com.example.test

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.one_row.view.*

class UserListAdapter(var activity: Activity, var myUsers : MutableList<User>, var myText : TextView) : BaseAdapter() {
    internal var inflater : LayoutInflater
    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var oneRow = inflater.inflate(R.layout.one_row, null)
        oneRow.user_id.text = myUsers[position].ID.toString()
        oneRow.user_name.text = myUsers[position].name
        oneRow.user_surname.text = myUsers[position].surname

        oneRow.setOnClickListener {
            myText.text = myUsers[position].ID.toString()
        }
        return oneRow
    }

    override fun getItem(position: Int): Any {
        return myUsers[position]
    }

    override fun getCount(): Int {
        return myUsers.size
    }

    override fun getItemId(position: Int): Long {
        return myUsers[position].ID.toLong();
    }
}