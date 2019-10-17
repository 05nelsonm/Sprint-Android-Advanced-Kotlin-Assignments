package com.x05nelsonm.musicgenres.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.x05nelsonm.musicgenres.R
import com.x05nelsonm.musicgenres.adapter.RecyclerViewAdapter
import com.x05nelsonm.musicgenres.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager

    /*class Rock (name: String): MusicGenre(name)
    class HeavyMetal (name: String): MusicGenre(name)
    class MetalCore (name: String): MusicGenre(name)
    class MichaelJackson (name: String): MusicGenre(name)*/

    private val rockList = listOf(
        Rock("Acid rock"),
        Rock("Afro punk"),
        Rock("art rock"),
        Rock("Baggy"),
        Rock("Bandana thrash")
    )
    private val heavyMetalList = listOf(
        HeavyMetal("Alternative metal"),
        HeavyMetal("Avant-garde metal"),
        HeavyMetal("Black metal"),
        HeavyMetal("Doom metal"),
        HeavyMetal("Extreme metal")
    )
    private val metalCore = listOf(
        MetalCore("Mathcore"),
        MetalCore("Deathcore"),
        MetalCore("Electronicore"),
        MetalCore("Technocore"),
        MetalCore("Nu metalcore")
    )
    private val michaelJackson = listOf(
        MichaelJackson("Rhythm & Blues"),
        MichaelJackson("Funk"),
        MichaelJackson("Jazz"),
        MichaelJackson("Hip hop"),
        MichaelJackson("New jack swing")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
