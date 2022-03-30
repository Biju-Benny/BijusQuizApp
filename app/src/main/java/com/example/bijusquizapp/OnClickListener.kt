package com.example.bijusquizapp

//interface to handle the option buttons clicks
//this interface passes the selected Quiz Question and the selected option from the recycler view adapter to the Main activity
interface OnClickListener {
    fun onClickListener(selectedOption: String, quizItem: QuizItem)
}