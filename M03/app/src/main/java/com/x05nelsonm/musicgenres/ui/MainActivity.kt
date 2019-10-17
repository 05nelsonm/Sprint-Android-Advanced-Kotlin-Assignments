package com.x05nelsonm.musicgenres.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.x05nelsonm.musicgenres.R
import com.x05nelsonm.musicgenres.adapter.RecyclerViewAdapter
import com.x05nelsonm.musicgenres.model.*
import kotlinx.android.synthetic.main.item_view.*
import java.util.zip.Inflater
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var musicGenres: MutableList<MusicGenre>
    private var rockList = mutableListOf<MusicGenre>()
    private var heavyMetalList = mutableListOf<MusicGenre>()
    private var metalCoreList = mutableListOf<MusicGenre>()
    private var michaelJacksonList = mutableListOf<MusicGenre>()
    private var count = 0

    /*class Rock (name: String): MusicGenre(name)
    class HeavyMetal (name: String): MusicGenre(name)
    class MetalCore (name: String): MusicGenre(name)
    class MichaelJackson (name: String): MusicGenre(name)*/

    private fun addToRockList() {
        rockList.add(Rock("Acid Rock"))
        rockList.add(Rock("Afro Punk"))
        rockList.add(Rock("Art Rock"))
        rockList.add(Rock("Baggy"))
        rockList.add(Rock("Bandana Thrash"))
    }

    private fun addToHeavyMetalList() {
        heavyMetalList.add(HeavyMetal("Alternative Metal"))
        heavyMetalList.add(HeavyMetal("Avant-grade Metal"))
        heavyMetalList.add(HeavyMetal("Black Metal"))
        heavyMetalList.add(HeavyMetal("Doom Metal"))
        heavyMetalList.add(HeavyMetal("Extreme Metal"))
    }

    private fun addToMetalCoreList() {
        metalCoreList.add(MetalCore("Mathcore"))
        metalCoreList.add(MetalCore("Deathcore"))
        metalCoreList.add(MetalCore("Electronicore"))
        metalCoreList.add(MetalCore("Technocore"))
        metalCoreList.add(MetalCore("Nu Metalcore"))
    }

    private fun addToMichaelJacksonList() {
        michaelJacksonList.add(MichaelJackson("Rhythm & Blues"))
        michaelJacksonList.add(MichaelJackson("Funk"))
        michaelJacksonList.add(MichaelJackson("Jazz"))
        michaelJacksonList.add(MichaelJackson("Hip Hop"))
        michaelJacksonList.add(MichaelJackson("New Jack Swing"))
    }

    private var listType: MusicGenre by Delegates.observable(Rock("")) {
            _, _: MusicGenre, new: MusicGenre ->
        musicGenres = when(new) {
            is Rock -> {
                rockList.clear()
                addToRockList()
                rockList
            }
            is HeavyMetal -> {
                heavyMetalList.clear()
                addToHeavyMetalList()
                heavyMetalList
            }
            is MetalCore -> {
                metalCoreList.clear()
                addToMetalCoreList()
                metalCoreList
            }
            is MichaelJackson -> {
                michaelJacksonList.clear()
                addToMichaelJacksonList()
                michaelJacksonList
            }
        }
        setTitleForType(musicGenres)

        if (count != 0) {
            recyclerViewAdapter.notifyDataSetChanged()
        }
        count++
    }

    private inline fun <reified T: MusicGenre> setTitleForType(musicGenres: MutableList<T>) {
        when {
            musicGenres[0] is Rock -> title = "Rock"
            musicGenres[0] is HeavyMetal -> title = "Heavy Metal"
            musicGenres[0] is MetalCore -> title = "Metal Core"
            musicGenres[0] is MichaelJackson -> title = "The King Of Pop"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToRockList()
        addToHeavyMetalList()
        addToMetalCoreList()
        addToMichaelJacksonList()

        listType = mutableListOf(Rock("rock"), HeavyMetal("heavy metal"), MetalCore("metalcore"), MichaelJackson("michael jackson")).random()

        viewManager = LinearLayoutManager(this)
        recyclerViewAdapter = RecyclerViewAdapter(musicGenres)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = recyclerViewAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_rock -> {
                listType = listOf(Rock(""))[0]
            }
            R.id.menu_heavy_metal -> {
                listType = listOf(HeavyMetal(""))[0]
            }
            R.id.menu_metal_core -> {
                listType = listOf(MetalCore(""))[0]
            }
            R.id.menu_michael_jackson -> {
                listType = listOf(MichaelJackson(""))[0]
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
