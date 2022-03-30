package com.example.bijusquizapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quiz_card_item.view.*

class RecyclerViewAdapter(val context: Context, val itemList: MutableList<QuizItem>, val onClickLstnr: OnClickListener)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(quizItem: QuizItem){
            itemView.questionTextView.text = quizItem.question
            itemView.optionOneBtn.text = quizItem.option1
            itemView.optionTwoBtn.text = quizItem.option2
            itemView.optionThreeBtn.text = quizItem.option3
            itemView.optionFourBtn.text = quizItem.option4

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_card_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //implementing click listener to all the Option buttons in each quiz items
        //all the options buttons of a question is disabled once the user selects any options for that question
        //background color of the selected button will be turned to Blue
        holder.bind(itemList[position])
        holder.itemView.optionOneBtn.setOnClickListener {
            onClickLstnr.onClickListener(itemList[position].option1,itemList[position])
            holder.itemView.optionOneBtn.isClickable = false
            holder.itemView.optionTwoBtn.isClickable = false
            holder.itemView.optionThreeBtn.isClickable = false
            holder.itemView.optionFourBtn.isClickable = false
            holder.itemView.optionOneBtn.setBackgroundColor(Color.BLUE)



        }
        holder.itemView.optionTwoBtn.setOnClickListener {
            onClickLstnr.onClickListener(itemList[position].option2,itemList[position])
            holder.itemView.optionOneBtn.isClickable = false
            holder.itemView.optionTwoBtn.isClickable = false
            holder.itemView.optionThreeBtn.isClickable = false
            holder.itemView.optionFourBtn.isClickable = false
            holder.itemView.optionTwoBtn.setBackgroundColor(Color.BLUE)


        }
        holder.itemView.optionThreeBtn.setOnClickListener {
            onClickLstnr.onClickListener(itemList[position].option3,itemList[position])
            holder.itemView.optionOneBtn.isClickable = false
            holder.itemView.optionTwoBtn.isClickable = false
            holder.itemView.optionThreeBtn.isClickable = false
            holder.itemView.optionFourBtn.isClickable = false
            holder.itemView.optionThreeBtn.setBackgroundColor(Color.BLUE)

        }
        holder.itemView.optionFourBtn.setOnClickListener {
            onClickLstnr.onClickListener(itemList[position].option4,itemList[position])
            holder.itemView.optionOneBtn.isClickable = false
            holder.itemView.optionTwoBtn.isClickable = false
            holder.itemView.optionThreeBtn.isClickable = false
            holder.itemView.optionFourBtn.isClickable = false
            holder.itemView.optionFourBtn.setBackgroundColor(Color.BLUE)

        }



    }

    override fun getItemCount(): Int = itemList.size
}