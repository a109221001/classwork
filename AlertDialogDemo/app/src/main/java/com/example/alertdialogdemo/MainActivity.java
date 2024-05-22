package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.NativeActivity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button about = (Button) findViewById(R.id.about);
        about.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("關於本書")
                    .setMessage("安卓程式設計與應用\n作者:nm\n教師:nd")
                    .setCancelable(true)
                    .setPositiveButton("確定",null)
                    .show();
        });
        Button end = (Button) findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("昂")
                        .setMessage("要結束嗎")
                        .setPositiveButton("好", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {finish();}
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消鍵",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
        Button color=(Button) findViewById(R.id.color);
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選一個色")
                        .setItems(new String[]{"red","yellow","green"}, (DialogInterface.OnClickListener) MainActivity.this)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog,int which)
    {
        Button color = (Button) findViewById(R.id.color);
        switch (which)
        {
            case 0:
                color.setBackgroundColor(Color.RED);
                break;
            case 1:
                color.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                color.setBackgroundColor(Color.GREEN);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this,"按取消",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}