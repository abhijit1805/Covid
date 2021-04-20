package com.example.covichart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecordActivity extends AppCompatActivity {
    Button _save;
    myDbAdapter _myDbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        _save = (Button)findViewById(R.id.save);
        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v instanceof Button){
                    if(R.id.save == ((Button)v).getId()){
                        addRecord();
                    }
                }
            }
        });
        _myDbAdapter = new myDbAdapter(this);
    }
    public void addRecord(){
        TextView tempTV = (TextView)findViewById(R.id.temperature);
        TextView oxygenTV = (TextView)findViewById(R.id.oxygen);
        TextView pulseTV = (TextView)findViewById(R.id.pulse);

        String temperature = tempTV.getText().toString();
        String oxygen = oxygenTV.getText().toString();
        String pulse = pulseTV.getText().toString();

        _myDbAdapter.insertData(temperature,oxygen,pulse);
    }

}