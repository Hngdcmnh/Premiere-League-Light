package com.example.premierleaguelight

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var navigationView: BottomNavigationView
    var teamFragment= TeamFragment()
    var matchFragment = MatchFragment()
    var rankingFragmet = RankingFragment()
    var newsFragment = NewsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        navigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        navigationView.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.action_news ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,newsFragment).commit()
                    true
                }

                R.id.action_team ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,teamFragment).commit()
                    true
                }

                R.id.action_match ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,matchFragment).commit()
                    true
                }

                R.id.action_ranking -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,rankingFragmet).commit()
                    true
                }

                else -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,teamFragment).commit()
                    true
                }
            }
        }
    }

    private fun loadData()
    {
        thread {
            Model.getNews()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,NewsFragment()).commit()
            Model.getData()
        }
    }

    fun goToWeb(link:String)
    {
        var webFragment:WebFragment = WebFragment(link)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,webFragment).addToBackStack("a").commit()
    }
}