package com.example.covichart;

import android.content.Context;
import android.media.Image;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String date[] ;
    String time[];
    String temperature[];
    String oxygen[];
    String pulse[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, Record[] records) {
        this.context = context;
        date = new String[100];
        time = new String[100];
        temperature = new String[100];
        oxygen = new String[100];
        pulse = new String[100];
       adjustData(records);
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return date.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.textview, null);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView time = (TextView) view.findViewById(R.id.time);
        TextView temperature = (TextView) view.findViewById(R.id.temperature);
        TextView oxygen = (TextView) view.findViewById(R.id.oxygen);
        TextView pulse = (TextView) view.findViewById(R.id.pulse);
        date.setText(this.date[i]);
        time.setText(this.time[i]);
        temperature.setText(this.temperature[i]);
        oxygen.setText(this.oxygen[i]);
        pulse.setText(this.pulse[i]);

        return view;
    }

    public void adjustData(Record[] records){
        for(int i=0; i<records.length; i++){
            Record rec = records[i];
            if(rec == null)
                return;
            String temperature = rec.get_temperature();
            String oxygen = rec.get_oxygen();
            String pulse = rec.get_pulse();
            String timeStamp = rec.get_timeStamp();
            long timeStampLong = Long.parseLong(timeStamp);
            String date = getDate(timeStampLong);
            String time = getTime(timeStampLong);
            this.date[i] = date;
            this.time[i] = time;
            this.temperature[i] = temperature;
            this.oxygen[i] = oxygen;
            this.pulse[i] = pulse;
        }
    }



    public String getDate(long timeStamp){
        Date date = new Date(timeStamp);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateFormatted = formatter.format(date);

        //String dateString = DateFormat.format("mm/dd", new Date(timeStamp)).toString();
        return dateFormatted;
    }
    public String getTime(long timeStamp){
        String timeString = DateFormat.format("hh:mm", new Date(timeStamp)).toString();
        return timeString;
    }
}