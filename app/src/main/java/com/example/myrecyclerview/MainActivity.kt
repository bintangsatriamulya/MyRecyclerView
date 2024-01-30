package com.example.myrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var rvHeroes: RecyclerView? = null
    private var list: ArrayList<Hero> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById<RecyclerView>(R.id.rv_hero)
        rvHeroes?.setHasFixedSize(true)
        list.addAll(HeroesData.listData)
        showRecycleList()

    }
    private fun showRecycleList(){
        rvHeroes?.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes?.adapter = listHeroAdapter
    }

}

