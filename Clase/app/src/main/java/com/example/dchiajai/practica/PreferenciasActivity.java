package com.example.dchiajai.practica;

import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreferenciasActivity extends AppCompatActivity {

    private static final String COUNT_KEY = "COUNT";
    private static final String COLOR_KEY = "COLOR";
    private int mCount = 0;
    private TextView mShowCount;
    private int mColor;

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.dchiajai.practica";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(COUNT_KEY);
            if (mCount != 0) {
                mShowCount.setText(String.format("%s", mCount));
            }
            mColor = savedInstanceState.getInt(COLOR_KEY);
            mShowCount.setBackgroundColor(mColor);
        }
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        mShowCount = (TextView) findViewById(R.id.textView3);
        mColor = ContextCompat.getColor(this,
                R.color.green);
        mPreferences = getSharedPreferences(
                sharedPrefFile, MODE_PRIVATE);
        // Restore preferences
        mCount = mPreferences.getInt(COUNT_KEY, 0);
        mShowCount.setText(String.format("%s", mCount));
        mColor = mPreferences.getInt(COLOR_KEY, mColor);
        mShowCount.setBackgroundColor(mColor);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.apply();
    }

    public void reset(View view) {
        // Reset count
        mCount = 0;
        mShowCount.setText(String.format("%s", mCount));

        // Reset color
        mColor = ContextCompat.getColor(this, R.color.green);
        mShowCount.setBackgroundColor(mColor);

        // Clear preferences
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();

    }
}
