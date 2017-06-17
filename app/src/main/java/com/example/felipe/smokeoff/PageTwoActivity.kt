package com.example.felipe.smokeoff

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.widget.TextView


import java.util.Calendar



var dataQuery: TextView? = null

class PageTwoActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two)

        dataQuery = findViewById(R.id.textView) as TextView


        dataQuery!!.setOnClickListener {
            val userInputActivity = Intent(this, MainActivity::class.java)
            startActivityForResult(userInputActivity, 1)

                    }








        /*//Get the Intent that started this activity and extract the string
        val MessageReceiver = intent
        val firstMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE1)
        val secondMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE2)
        val thirdMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE3)

        // Capture the layout's TextView and set the string as its text
        val firstTextView = findViewById(R.id.textView) as TextView
        val secondTextView = findViewById(R.id.textView2) as TextView
        val thirdTextView = findViewById(R.id.textView3) as TextView

        firstTextView.text = firstMessage
        secondTextView.text = secondMessage
        thirdTextView.text = thirdMessage*/
    }

    override fun onActivityResult(requestCode:Int, resultCode:Int, data:Intent) {
        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                val result = data.getStringExtra(MainActivity.EXTRA_MESSAGE1)
                val firstTextView = findViewById(R.id.textView2) as TextView
                firstTextView.text = result
            }
            if (resultCode == Activity.RESULT_CANCELED)
            {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}