package com.pucmm.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        System.out.println("Hi");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        ) {
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                Intent intent = new Intent();
                intent.setClass(this, InfoActivity.class);
                System.out.println("Details");
                System.out.println(PlaceholderContent.ITEMS.get(requestCode).getDetails());
                intent.putExtra("INFO", requestCode);
                intent.putExtra("TITLE", PlaceholderContent.ITEMS.get(requestCode).getName());

                startActivity(intent);
            } else {
                InfoFragment infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.iFragment);
                infoFragment.newInfo(PlaceholderContent.ITEMS.get(requestCode));
            }
        } else {
            Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView(), "You should have all permissions", Snackbar.LENGTH_LONG);
            mySnackbar.show();
        }
    }
}