package com.example.felipe.smokeoff

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import java.util.*


var dataQuery: TextView? = null

class PageTwoActivity : ActionBarActivity() {

    var dateInputChooser: Int = 0
    var mHandler = Handler()
    var mInterval: Long = 1000



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two)

        //dataQuery = findViewById(R.id.textView) as TextView
        var isnew = 0

        if (isnew==1) {

            val userInputActivity = Intent(this, MainActivity::class.java)
            startActivityForResult(userInputActivity, 1)
        }
        else{}



        /*mHandler.postDelayed(object:Runnable {
            override fun run(){

                if (dateInputChooser == 1)
                    TickTimer(DatePasser)

                mHandler.postDelayed(this, mInterval)
            }
        }, mInterval )*/

    }

/*    fun TickTimer(StartTime: Date) {

        val NowDate = Date()
        var Difference = NowDate.time - StartTime.time
        val secondsInMilli: Long = 1000
        val minutesInMilli: Long = secondsInMilli*60
        val hoursInMilli: Long = minutesInMilli*60
        val daysInMilli: Long = hoursInMilli*24

        val elapsedDays: Long = Difference/daysInMilli
        Difference = Difference % daysInMilli

        val elapsedHours: Long = Difference/hoursInMilli
        Difference = Difference % hoursInMilli

        val elapsedMinutes: Long = Difference/minutesInMilli
        Difference = Difference % minutesInMilli

        val elapsedSeconds: Long = Difference/secondsInMilli

        Timer!!.text = getString(R.string.timer, elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds)



    }*/

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




    /* dataQuery!!.setOnClickListener {
          val userInputActivity = Intent(this, MainActivity::class.java)
          startActivityForResult(userInputActivity, 1)

                  }*/


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


