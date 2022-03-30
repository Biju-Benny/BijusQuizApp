package com.example.bijusquizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score: Int = intent.getIntExtra("score",0)
        val rightAnswers: Int = intent.getIntExtra("rightAnswers",0)

        val wrongAnswers = 5-rightAnswers

        rightAnswersTextView.text = "Correct answers: "+rightAnswers.toString()
        wrongAnswersTextView.text = "Wrong Answers: "+wrongAnswers.toString()

        scoreTextView.text = score.toString()



        //inform the user he has passed the quiz if score is greater than 60%
        if(score >= 60){
            resultCard.setCardBackgroundColor(Color.GREEN)
            commentTextView.text = "Congratulations"


        }
        else{
            resultCard.setCardBackgroundColor(Color.RED)
            commentTextView.text = "Better Luck Next Time"

        }
    }
}