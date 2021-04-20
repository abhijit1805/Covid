package com.example.covichart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    ImageView _addRecord, _viewReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _addRecord = (ImageView)findViewById(R.id.plus);
        _viewReport = (ImageView)findViewById(R.id.report);
        _addRecord.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               // Toast.makeText(getApplicationContext(),"plus is clicked", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, AddRecordActivity.class);
                startActivity(i);
            }
        });

        ImageView report = (ImageView)findViewById(R.id.report);
        _viewReport.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               /* Toast.makeText(getApplicationContext(),"report is clicked", Toast.LENGTH_LONG).show();*/
                Intent i = new Intent(MainActivity.this,ViewRecords.class);
                startActivity(i);
            }
        });


    }





}