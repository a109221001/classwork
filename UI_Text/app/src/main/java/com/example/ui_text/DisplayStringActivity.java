package com.example.ui_text;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayStringActivity extends AppCompatActivity
{
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);

        TextView txvShow = (TextView)  findViewById(R.id.txvShow);
        Intent intent = getIntent();
        txvShow.setText(intent.getStringExtra("userName")+"您好!");
    }
}
