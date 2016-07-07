package com.luxoft.training.dev018.androidexamples.intents;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.luxoft.training.dev018.androidexamples.DbHelper;
import com.luxoft.training.dev018.androidexamples.R;
import com.luxoft.training.dev018.androidexamples.network.ApiConstants;

public class PassDataFirst extends AppCompatActivity implements OnClickListener {

    EditText etFName;
    EditText etLName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_data);

        etFName = (EditText) findViewById(R.id.etFName);
        etLName = (EditText) findViewById(R.id.etLName);

        Intent i = getIntent();
        etFName.setText(i.getStringExtra(ApiConstants.FIRST_NAME_KEY));
        etLName.setText(i.getStringExtra(ApiConstants.LAST_NAME_KEY));
    }


    @Override
    public void onClick(View v) {

        if (!checkNames())
        {
            Toast.makeText(this, R.string.FirstLastNameCheckToast, Toast.LENGTH_LONG);
            return;
        }
        DbHelper dbHelper = new DbHelper(this);
        try {
            dbHelper.deleteVariables(new String[]{ApiConstants.FIRST_NAME_KEY, ApiConstants.LAST_NAME_KEY});
            dbHelper.insertVariable(ApiConstants.FIRST_NAME_KEY, etFName.getText().toString());
            dbHelper.insertVariable(ApiConstants.LAST_NAME_KEY, etLName.getText().toString());
        }finally {
            if(null != dbHelper)
                dbHelper.close();
        }


        Intent intent = new Intent(this, PassedDataReceiverActivity.class);
        startActivity(intent);
    }

    private boolean checkNames() {
        return !TextUtils.isEmpty(etFName.getText().toString()) &&
                !TextUtils.isEmpty(etLName.getText().toString());
    }
}
