package com.example.felipe.smokeoff

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.support.v4.app.DialogFragment
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import java.util.*

class PageTwoActivity : AppCompatActivity() {

    var mHandler = Handler()
    var mInterval: Long = 1000
    var TickTimer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two)

        TickTimer = findViewById(R.id.textViewTimer) as TextView

        val StartTime: Date = Date()

        val MessageReceiver = getIntent()
        val firstMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE1)
        val secondMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE2)
        val thirdMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE3)
        //val firstTextView = findViewById(R.id.textViewCongrats) as TextView
        val secondTextView = findViewById(R.id.textView2) as TextView
        val thirdTextView = findViewById(R.id.textView3) as TextView
        //firstTextView.text = firstMessage
        secondTextView.text = secondMessage
        thirdTextView.text = thirdMessage



        mHandler.postDelayed(object : Runnable {
            override fun run() {

                TickTimer(StartTime)

                mHandler.postDelayed(this, mInterval)
            }
        }, mInterval)

    }

    fun TickTimer(StartTime: Date) {

        val NowDate = Date()
        var Difference = NowDate.time - StartTime.time
        val secondsInMilli: Long = 1000
        val minutesInMilli: Long = secondsInMilli * 60
        val hoursInMilli: Long = minutesInMilli * 60
        val daysInMilli: Long = hoursInMilli * 24

        val elapsedDays: Long = Difference / daysInMilli
        Difference = Difference % daysInMilli

        val elapsedHours: Long = Difference / hoursInMilli
        Difference = Difference % hoursInMilli

        val elapsedMinutes: Long = Difference / minutesInMilli
        Difference = Difference % minutesInMilli

        val elapsedSeconds: Long = Difference / secondsInMilli

        TickTimer!!.text = getString(R.string.timer, elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds)

    }


}