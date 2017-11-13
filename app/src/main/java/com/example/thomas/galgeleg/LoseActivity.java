package com.example.thomas.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class LoseActivity extends AppCompatActivity {

    public static HighScore highscore = new HighScore();

    ListView lv;
    LayoutInflater li;
    BaseAdapter ba;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();
        String s=sp.getString("Du har vundet","tillykke");


        editor.putString("name", "Thomas");
        editor.putString(sp.getString(/*point[1],[2],...*/)); //key, value




        String score= ;
        for(int i = 0; i < score.length(); i++){
            // score += Point p.toString();
        }
        editor.commit();

        Log.d("HEJ", sp.getString("name", s));



    }

}
