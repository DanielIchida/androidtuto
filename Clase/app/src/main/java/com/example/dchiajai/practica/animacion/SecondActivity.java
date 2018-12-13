package com.example.dchiajai.practica.animacion;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

import com.example.dchiajai.practica.R;

public class SecondActivity extends BaseClass {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dos);

        // Initialize the views.
        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        ImageView yellowBlock = findViewById(R.id.yellowBlock);
        ImageView androidBlock = findViewById(R.id.androidBlock);

        // Set the methods from the base class to the appropriate ImageViews.
        explodeTransition(this, redBlock);
        fadeTransition(this, blueBlock);
        rotateView(yellowBlock);
        switchAnimation(androidBlock,blueBlock,new Intent(
                this,MainActivity.class),this);
    }
}
