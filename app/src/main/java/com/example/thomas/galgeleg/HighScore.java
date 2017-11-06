package com.example.thomas.galgeleg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HighScore extends AppCompatActivity implements OnItemClickListener {
//inspireret af Jacobs BenytListView
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        System.out.println("oncreate");

        final String[] navne = {"Danmark", "Norge", "Sverige", "Finland", "Holland", "Italien", "Tyskland",
                "Frankrig", "Spanien", "Portugal", "Nepal", "Indien", "Kina", "Japan", "Thailand"};

        int[] score = new int[100];

        ArrayAdapter adapter= new ArrayAdapter(this, R.layout.listeelement_layout, R.id.spillernavn, navne) {


            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                TextView point = v.findViewById(R.id.point);
                point.setText(""+position);
                TextView snavn = v.findViewById(R.id.spillernavn);
                snavn.setText("hans");

                return v;
            }
        };

        listView = (ListView) findViewById(R.id.highScoreListe);
        System.out.println(adapter);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

    }

    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        Toast.makeText(this, "Klik på " + position, Toast.LENGTH_SHORT).show();
    }
/*    public void add(int point){
        for( int i=0; i < score.length; i++){
            if(score[i]==null){
                score[i]= point;
                break;
            }
        }

        //sort
        int i;
        for( int j = 1; j < score.length; j++){
            point = score[j];
            i=j-1;
            while(i>0 && score[i]> point){
                score[i+1]=score[i];
                i--;
                score[i+1] = point;
            }
        }

    }*/

}