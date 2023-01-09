package com.example.clickergame40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clickergame40.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class ScoreActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    var userId =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        database  = FirebaseDatabase.getInstance("https://clickergame4-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Winners")

        uploadWinnerToDatabase(userId.toString())
        userId++

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

    private fun uploadWinnerToDatabase(userId: String)
    {
        val score = Mediator.getIncome().toString()
        val name = Mediator.getName()


        val winner = Winner(name,score)

        database.child("Winners").push().setValue(winner).addOnFailureListener {
            Toast.makeText(this,"neúspěšné uložení", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getWinner() {
      /*  val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val username = ds.child("username").getValue(String::class.java)
                    Log.d(TAG, username)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(TAG, databaseError.getMessage()) //Don't ignore errors!
            }
        }*/
    }

}