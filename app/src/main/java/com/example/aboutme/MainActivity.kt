package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMain3Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    private val myName: MyName = MyName("Julian")

    //lateinit var doneButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main3)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main3)
        binding.myName = myName
        //doneButton = findViewById(R.id.done_button)

        binding.doneButton.setOnClickListener(View.OnClickListener {
            addNickName(it)
        })
    }

    private fun addNickName(view: View){
        /*val editTextNick : EditText = findViewById(R.id.nickname_edit)
        val tvNick : TextView = findViewById(R.id.nickcame_text)

        tvNick.text = editTextNick.text
        editTextNick.visibility = View.GONE
        view.visibility = View.GONE
        tvNick.visibility = View.VISIBLE
        *************************
         binding.nickcameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        binding.nickcameText.visibility = View.VISIBLE
*/
        binding.apply {
            //nickcameText.text = nicknameEdit.text
            myName.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nickcameText.visibility = View.VISIBLE
        }


        //Hide the keyboard

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)


    }
}