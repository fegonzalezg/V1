package com.example.felipe.smokeoff;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.Calendar;

public class PageTwoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        /*// Get the Intent that started this activity and extract the string
        Intent MessageReceiver = getIntent();
        String firstMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String secondMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String thirdMessage = MessageReceiver.getStringExtra(MainActivity.EXTRA_MESSAGE3);

        // Capture the layout's TextView and set the string as its text
        TextView firstTextView = (TextView) findViewById(R.id.textView);
        TextView secondTextView = (TextView) findViewById(R.id.textView2);
        TextView thirdTextView = (TextView) findViewById(R.id.textView3);

        firstTextView.setText(firstMessage);
        secondTextView.setText(secondMessage);
        thirdTextView.setText(thirdMessage);*/
    }
}