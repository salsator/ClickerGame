package com.example.clickergame40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clickergame40.R

class ScoreActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        val sampleResults = listOf(
            Winner("adam","50"),
            Winner("Někdo druhy", "20"),
            Winner("treti", "15"),

            )

        val resultAdapter = ResultAdapter(sampleResults)

        val scoreBoard: RecyclerView = findViewById(R.id.scoreList)
        scoreBoard.adapter = resultAdapter
        scoreBoard.layoutManager = LinearLayoutManager(applicationContext)

    }
}