package com.example.apka6


import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fragment_add.*
import kotlinx.android.synthetic.main.fragment_fragment_rv.*
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * A simple [Fragment] subclass.
 */
class FragmentADD : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_fragment_add, container, false)

    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_add_fragment_add.setOnClickListener{
            var priority = rgSetPriority.findViewById<RadioButton>(rgSetPriority.checkedRadioButtonId).text.toString()


            var task = SingleTask(plainTextSetTitle.text.toString(), priority, switchStatus.isChecked.toString(), "2019-12-03")

            var dbHelper = DBHelper(activity!!,null)
            dbHelper.addTask(task)

            (activity as MainActivity).loadDataBase()
            Log.d("wisnia",task.taskid.toString())

            activity?.supportFragmentManager!!.popBackStack()
            rvWithTasks.isVisible=true
        }
    }
}



