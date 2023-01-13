package com.example.clickergame40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class ScoreActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var winnerListArray : ArrayList<Winner>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        database  = FirebaseDatabase.getInstance("https://clickergame4-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Winners")

        uploadWinnerToDatabase()

        winnerListArray = arrayListOf<Winner>()

        getWinnerData()


    }

    private fun uploadWinnerToDatabase()
    {
        val score = Mediator.getIncome().toString()
        val name = Mediator.getName()


        val winner = Winner(name,score)

        database.child(name).setValue(winner).addOnFailureListener {
            Toast.makeText(this,"neúspěšné uložení", Toast.LENGTH_SHORT).show()
        }
    }




    private fun getWinnerData()
    {
       // database = FirebaseDatabase.getInstance().getReference("Winners")
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    for (winnerSnapshot in snapshot.children)
                    {
                        val winner = winnerSnapshot.getValue(Winner::class.java)
                        winnerListArray.add(winner!!)
                    }


                    val sorted = winnerListArray.sortedByDescending {
                        it.score?.toInt()
                    }
                    val resultAdapter = ResultAdapter(sorted)

                    val scoreBoard: RecyclerView = findViewById(R.id.scoreList)
                    scoreBoard.adapter = resultAdapter
                    scoreBoard.layoutManager = LinearLayoutManager(applicationContext)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //TODO("Not yet implemented")
            }

        })

    }
}