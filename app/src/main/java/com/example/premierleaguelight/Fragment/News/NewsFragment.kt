package com.example.premierleaguelight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var  recyclerView : RecyclerView = view.findViewById(R.id.rclvNews)
        var  recyclerAdapter = RecyclerViewNewsAdapter(Model.listNews,{(activity as MainActivity).goToWeb(it)})
        recyclerView.adapter=  recyclerAdapter
        recyclerView.layoutManager=  LinearLayoutManager(this.context)

    }
}