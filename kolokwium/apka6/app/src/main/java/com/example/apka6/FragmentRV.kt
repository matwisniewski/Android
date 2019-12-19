package com.example.apka6


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fragment_add.*
import kotlinx.android.synthetic.main.fragment_fragment_rv.*
import kotlinx.android.synthetic.main.rv_prio_stat_date.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentRV : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_rv, container, false)
    }
}
