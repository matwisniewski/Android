package com.example.apka6

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_fragment_add.*
import kotlinx.android.synthetic.main.fragment_fragment_rv.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
            loadDataBase()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                if(supportFragmentManager.findFragmentByTag("tag1")==null) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, FragmentADD(), "tag1").addToBackStack("name")
                        .commit()
                    rvWithTasks.isVisible=false
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun loadDataBase(){
            var dbHelper = DBHelper(this, null)
            var recyclerview = findViewById<RecyclerView>(R.id.rvWithTasks)
            var adapter = TasksRVAdapter(this, dbHelper.allActivities)
            recyclerview.adapter = adapter
            recyclerview.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(supportFragmentManager.findFragmentByTag("tag1")==null){
            rvWithTasks.isVisible=true
        }
    }

    override fun onResume() {
        super.onResume()
        loadDataBase()
    }
}
