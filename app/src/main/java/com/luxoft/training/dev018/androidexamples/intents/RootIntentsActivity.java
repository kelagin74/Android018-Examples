package com.luxoft.training.dev018.androidexamples.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.luxoft.training.dev018.androidexamples.DbHelper;
import com.luxoft.training.dev018.androidexamples.R;
import com.luxoft.training.dev018.androidexamples.network.ApiConstants;

import org.w3c.dom.Text;

public class RootIntentsActivity extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    TextView tvResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rootintents);
        etFirstName = (EditText) findViewById(R.id.etFName);
        etLastName = (EditText) findViewById(R.id.etLName);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setText();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void onSubmitClick(View view){
        if (!checkNames()){
            Toast.makeText(this, R.string.FirstLastNameCheckToast, Toast.LENGTH_LONG);
            return;}

        Intent i = new Intent(this, PassDataFirst.class);
        i.putExtra(ApiConstants.FIRST_NAME_KEY, etFirstName.getText().toString());
        i.putExtra(ApiConstants.LAST_NAME_KEY, etLastName.getText().toString());
        startActivity(i);
    }

    private boolean checkNames() {
        return !TextUtils.isEmpty(etFirstName.getText().toString()) &&
                !TextUtils.isEmpty(etLastName.getText().toString());
    }

    void setText()
    {
        DbHelper dbHelper = new DbHelper(this);
        try {
            String fName = dbHelper.getVariable(ApiConstants.FIRST_NAME_KEY);
            String lName = dbHelper.getVariable(ApiConstants.LAST_NAME_KEY);
            etFirstName.setText(fName);
            etLastName.setText(lName);
            tvResult.setText("Your saved name is: " + fName + " " + lName);
        } finally {
            if(null != dbHelper)
                dbHelper.close();
        }
    }
}
