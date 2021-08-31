package com.example.premierleaguelight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class RecyclerViewMatchAdapter(var listMatch: List<Match>):RecyclerView.Adapter<RecyclerViewMatchAdapter.ViewHolder>() {
    lateinit var v:View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewMatchAdapter.ViewHolder {
        v= LayoutInflater.from(parent.context).inflate(R.layout.item_match,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewMatchAdapter.ViewHolder, position: Int) {
        return holder.bindView(listMatch[position])
    }

    override fun getItemCount(): Int {
        return listMatch.size
    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v)
    {
        var imgTeam1 = v.findViewById<ImageView>(R.id.imgTeam1)
        var imgTeam2 = v.findViewById<ImageView>(R.id.imgTeam2)
        var time = v.findViewById<TextView>(R.id.timeMatch)
        var day = v.findViewById<TextView>(R.id.dayMatch)

        fun bindView(match1: Match)
        {
            time.text= match1.time
            day.text= match1.day
            Picasso.get().load(match1.team1?.flagUrl).into(imgTeam1)
            Picasso.get().load(match1.team2?.flagUrl).into(imgTeam2)
        }
    }
}