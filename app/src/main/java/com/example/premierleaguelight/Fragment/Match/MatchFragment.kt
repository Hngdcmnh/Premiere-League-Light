package com.example.premierleaguelight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MatchFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.fragment_match, container, false)

        var recyclerView = view.findViewById<RecyclerView>(R.id.rclvMatch)
        var adapter = RecyclerViewMatchAdapter(Model.getSortedMatch())
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(this.context)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}