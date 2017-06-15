package com.example.felipe.smokeoff

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mDisplayDate: TextView? = null
    private var TestText: TextView? = null
    private var Timer: TextView? = null
    private var mDateSetListener: OnDateSetListener? = null
    var DatePasser: Date = Date()
    var mHandler = Handler()
    var mInterval: Long = 1000
    var dateInputChooser: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer = findViewById(R.id.textViewTimer) as TextView
        TestText = findViewById(R.id.textViewTest) as TextView
        mDisplayDate = findViewById(R.id.tvDate) as TextView





        mDisplayDate!!.setOnClickListener {
            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)


            val dialog = DatePickerDialog(
                    this@MainActivity,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,
                    year, month, day)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }

        mDateSetListener = OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1
            val cal = Calendar.getInstance()
            val minutes = cal.get(Calendar.MINUTE)
            val hours = cal.get(Calendar.HOUR_OF_DAY)
            var seconds = cal.get(Calendar.SECOND)
            val StartDate = Date()
            seconds = seconds + hours*60*60 + minutes*60


            val date = month.toString() + "/" + day + "/" + year
            mDisplayDate!!.text = date
            TestText!!.text = seconds.toString()
            DatePasser = StartDate
            dateInputChooser = 1
            TickTimer(StartDate)

        }


        mHandler.postDelayed(object:Runnable {
            override fun run(){

                if (dateInputChooser == 1)
                TickTimer(DatePasser)

                mHandler.postDelayed(this, mInterval)
            }
        }, mInterval )

    }

    fun TickTimer(StartTime: Date) {

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



    }







    }

    /*companion object {
        public static final String EXTRA_MESSAGE1 = "com.example.felipe.smokeoff.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.felipe.smokeoff.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.felipe.smokeoff.MESSAGE3";

        private val TAG = "MainActivity"
    }


    public void onClickNext(View v) {

        Intent NextPage = new Intent(this, PageTwoActivity.class);
        EditText CigsPerDay = (EditText) findViewById(R.id.how_many_cigs_per_day);
        EditText CigsPerPack = (EditText) findViewById(R.id.how_many_per_pack);
        EditText PackCost = (EditText) findViewById(R.id.cost_per_pack);

        String CigsPerDayString = CigsPerDay.getText().toString();
        String CigsPerPackString = CigsPerPack.getText().toString();
        String PackCostString = PackCost.getText().toString();

        NextPage.putExtra(EXTRA_MESSAGE1, CigsPerDayString);
        NextPage.putExtra(EXTRA_MESSAGE2, CigsPerPackString);
        NextPage.putExtra(EXTRA_MESSAGE3, PackCostString);

        startActivity(NextPage);

    }*/




