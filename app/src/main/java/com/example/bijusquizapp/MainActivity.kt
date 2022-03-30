package com.example.bijusquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnClickListener {
    private var quizList: MutableList<QuizItem> = mutableListOf()
    var score: Int = 0
    var rightAnswers: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //create a list of quit questions, options and answer
        //items are similar to the format: "Question","Right Answer","Right Answer","Wrong Answer","Wrong Answer","Wrong Answer"
        quizList.clear()
        quizList.add(QuizItem("What is Light year?","A Unit of Distance","A Unit of Distance","Unit of time","Unit of speed","Unit of force"))
        quizList.add(QuizItem("Name the smallest Ocean","Arctic Ocean","Indian Ocean","Pacific Ocean","Arctic Ocean","Atlantic Ocean"))
        quizList.add(QuizItem("What is the SI unit of Force?","Newton","Pascal","Watts","Joule","Newton"))
        quizList.add(QuizItem("Who is the author of ‘Wings of Fire’?","A.P.J. Abdul Kalam","Ernest Hemingway","A.P.J. Abdul Kalam","William Faulkner","William Shakespeare"))
        quizList.add(QuizItem("What is the common name of Sodium Carbonate?","Washing Soda","Washing Soda","Common Salt","Baking Soda","Bleaching powder"))

        //show the list items in main activity recyclerview

        val adapterRecyler = RecyclerViewAdapter(this,quizList,this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapterRecyler

        //setclick listener on btn Submit
        btnSubmit.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("score",score)
            intent.putExtra("rightAnswers",rightAnswers)

            startActivity(intent)
            finish() //clears the main activity from backstack
                     //User will be directed to welcome screen if user press button from result screen and the user can retake the quiz




        }



    }

    //add score when the user select the correct answer
    override fun onClickListener(selectedOption: String, quizItem: QuizItem) {
        if(selectedOption == quizItem.answer){
            score += 20
            rightAnswers += 1

        }

    }


}