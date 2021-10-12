package com.pucmm.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        System.out.println("Info Activity");
        this.setTitle(getIntent().getStringExtra("TITLE"));
        InfoFragment infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.iFragment);
        int index = getIntent().getIntExtra("INFO", 0);
        System.out.println("Index ");
        System.out.println(index);
        infoFragment.newInfo(PlaceholderContent.ITEMS.get(index));
    }
}