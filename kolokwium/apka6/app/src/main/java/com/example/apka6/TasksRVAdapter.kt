package com.example.apka6

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class TasksRVAdapter(val context:Context , val tasks: MutableList<SingleTask>): RecyclerView.Adapter<TasksRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_prio_stat_date, parent, false)
        //view.setOnClickListener(view.id.setTextColor(Color.GREEN))
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dbHandler = DBHelper(context, null)
        val act = tasks[position]
        holder.tasksTitleTextView.text = act.taskName
        holder.tasksDateTextView.text = act.taskDate
        holder.tasksPriorityTextView.text = act.taskPriority
        holder.tasksStateTextView.text = act.taskState

        holder.itemView.setOnClickListener()
        {
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra("name", act.taskName)
            intent.putExtra("priority", act.taskPriority)
            intent.putExtra("state", act.taskState)
            intent.putExtra("id",act.taskid.toString())
            ContextCompat.startActivity(context,intent,null)
        }
    }

     class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tasksPriorityTextView=view.findViewById<TextView>(R.id.priority_Name)
        val tasksStateTextView=view.findViewById<TextView>(R.id.stateName)
        val tasksDateTextView=view.findViewById<TextView>(R.id.dateDate)
        val tasksTitleTextView=view.findViewById<TextView>(R.id.titleName)
    }
}