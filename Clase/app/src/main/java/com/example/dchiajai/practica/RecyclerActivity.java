package com.example.dchiajai.practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dchiajai.practica.adaptadores.WordListAdapter;

import java.util.LinkedList;

public class RecyclerActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }
        mRecyclerView = findViewById(R.id.rc_prueba);
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addList(View v){
        int wordListSize = mWordList.size();
        // Add a new word to the wordList.
        mWordList.addLast("+ Word " + wordListSize);
        // Notify the adapter, that the data has changed.
        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
        // Scroll to the bottom.
        mRecyclerView.smoothScrollToPosition(wordListSize);
    }
}
