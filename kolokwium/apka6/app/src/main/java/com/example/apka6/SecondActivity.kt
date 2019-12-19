package com.example.apka6

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_fragment_add.*
import java.time.LocalDate

class SecondActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_fragment_add)
        var db = DBHelper(this,null)
        plainTextSetTitle.setText(intent.getStringExtra("name"))
        var fbidRG=findViewById<RadioGroup>(R.id.rgSetPriority)

        when (intent.getStringExtra("priority")) {

            getString(R.string.set_State_Big) -> fbidRG.check(R.id.rbPriorityBig)
            getString(R.string.set_State_Low) -> fbidRG.check(R.id.rbPriorityLow)
            getString(R.string.set_State_Medium) -> fbidRG.check(R.id.rbPriorityMedium)
        }

        switchStatus.isChecked= intent.getStringExtra("state")!!.toBoolean()
        button_delete.isVisible=true
        button_add_fragment_add.setText(R.string.action_edit_button)

        button_delete.setOnClickListener{
            db.delUser(intent?.getStringExtra("id").toString())
            finish()
        }

        button_add_fragment_add.setOnClickListener(){
            var priority = rgSetPriority.findViewById<RadioButton>(rgSetPriority.checkedRadioButtonId).text.toString()
            var task = SingleTask(plainTextSetTitle.text.toString(), priority, switchStatus.isChecked.toString(), LocalDate.now().toString())
            db.editUser(task, intent?.getStringExtra("id").toString() )
            finish()
        }
    }
}

