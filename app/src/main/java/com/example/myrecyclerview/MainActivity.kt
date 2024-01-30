package com.example.myrecyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var rvHeroes: RecyclerView? = null
    private var list: ArrayList<Hero> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(title)
        
        rvHeroes = findViewById<RecyclerView>(R.id.rv_hero)
        rvHeroes?.setHasFixedSize(true)
        list.addAll(HeroesData.listData)
        showRecycleList()

    }

    private fun setActionBar(title: CharSequence?) {

    }


    private fun showRecycleList(){
        rvHeroes?.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes?.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
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
                title = "Mode List"
                showRecycleList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
               showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode Card View"
                showRecyclerCardView()

            }
        }
    }

    private fun showRecyclerGrid() {
        rvHeroes?.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes?.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }



    private fun showSelectedHero(hero: Hero) {
    Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerCardView() {
        rvHeroes?.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rvHeroes?.adapter = cardViewHeroAdapter
    }




}

