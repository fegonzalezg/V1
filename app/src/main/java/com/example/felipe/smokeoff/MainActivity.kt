package com.example.felipe.smokeoff

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

import java.util.Calendar


class MainActivity : AppCompatActivity() {

    private var mDisplayDate: TextView? = null
    private var mDateSetListener: DatePickerDialog.OnDateSetListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        mDateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            var month = month
            month = month + 1

            Log.d(TAG, "onDateSet: mm/dd/yyyy: $month/$day$year")
            val date = month.toString() + "/" + day + "/" + year
            mDisplayDate!!.text = date
        }


    }

    companion object {
        /*public static final String EXTRA_MESSAGE1 = "com.example.felipe.smokeoff.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.felipe.smokeoff.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.felipe.smokeoff.MESSAGE3";*/

        private val TAG = "MainActivity"
    }


    /* public void onClickNext(View v) {

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


}

