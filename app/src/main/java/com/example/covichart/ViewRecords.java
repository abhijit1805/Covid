package com.example.covichart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ViewRecords extends AppCompatActivity {

    ListView simpleList;

    myDbAdapter _myDbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);
        _myDbAdapter = new myDbAdapter(this);
        Record[] records = _myDbAdapter.getData();
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), records);
        View headerView = getLayoutInflater().inflate(R.layout.view_records_header, null);
        simpleList.addHeaderView(headerView);
        simpleList.setAdapter(customAdapter);
    }


}