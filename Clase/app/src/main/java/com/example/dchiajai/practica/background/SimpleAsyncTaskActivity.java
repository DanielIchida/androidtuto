package com.example.dchiajai.practica.background;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dchiajai.practica.R;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTaskActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_async_task);
        mTextView = findViewById(R.id.textView1);
        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view){
        new SimpleAsyncTask(mTextView).execute();
    }

    public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

        private WeakReference<TextView> mTextView;

        SimpleAsyncTask(TextView tv) {
            mTextView = new WeakReference<>(tv);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... voids) {
            // Generate a random number between 0 and 10
            Random r = new Random();
            int n = r.nextInt(11);
            // Make the task take long enough that we have
            // time to rotate the phone while it is running
            int s = n * 200;
            // Sleep for the random amount of time
            try {
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Return a String result
            return "Awake at last after sleeping for " + s + " milliseconds!";
        }

        @Override
        protected void onPostExecute(String s) {
            mTextView.get().setText(s);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE,
                mTextView.getText().toString());
    }
}
