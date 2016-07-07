package com.luxoft.training.dev018.androidexamples.layouts;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.luxoft.training.dev018.androidexamples.R;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class RelativeExample extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativeexcemple);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DateFormat df = DateFormat.getDateTimeInstance (DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("en", "EN"));
        String formattedDate = df.format (new Date());
        for (int i = 0; i < 4; i++) {
            RelativeContactItemFragment item = RelativeContactItemFragment.newInstance(
                    "Header " + i, "Small text " + i, formattedDate);
            fragmentTransaction.add(R.id.fragment_container, item, "HELLO");
        }
        fragmentTransaction.commit();
    }
}
