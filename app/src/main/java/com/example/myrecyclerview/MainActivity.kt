package com.example.myrecyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                // Lakukan sesuatu untuk mode list
            }

            R.id.action_grid -> {
                // Lakukan sesuatu untuk mode grid
            }

            R.id.action_cardview -> {
                // Lakukan sesuatu untuk mode cardview
            }
        }
    }


}

