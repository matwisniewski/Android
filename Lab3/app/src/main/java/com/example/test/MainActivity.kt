package com.example.test

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var users = mutableListOf<User>(User("Daniel", "Henel", 1))
    lateinit var button1 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        write.setOnClickListener(){
            users.add(User(nameText.text.toString(), surnameText.text.toString(), 2))
        }
        var myAdapter = UserListAdapter(this, users, textView)
        userListView.adapter = myAdapter
    }
}
