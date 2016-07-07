package com.luxoft.training.dev018.androidexamples.intents;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.luxoft.training.dev018.androidexamples.DbHelper;
import com.luxoft.training.dev018.androidexamples.R;
import com.luxoft.training.dev018.androidexamples.network.ApiConstants;

public class PassedDataReceiverActivity extends AppCompatActivity {
    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passed_data_receiver);

        tvView = (TextView) findViewById(R.id.tvView);
        setText();
    }

    void setText()
    {
        DbHelper dbHelper = new DbHelper(this);
        try {
            String fName = dbHelper.getVariable(ApiConstants.FIRST_NAME_KEY);
            String lName = dbHelper.getVariable(ApiConstants.LAST_NAME_KEY);
            tvView.setText("Your name is: " + fName + " " + lName);
        } finally {
            if(null != dbHelper)
                dbHelper.close();
        }
    }
}
