package com.example.thomas.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class WinActivity extends AppCompatActivity {

    private ListView lv;
    LayoutInflater li;
    BaseAdapter ba;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        ////li = (LayoutInflater) getSystemService(Context.class.getClass().getField( Point p);
        //li = R.layout.highscore;
        //li =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();
        String s=sp.getString("Du har vundet","tillykke");


        editor.putString("name", "Thomas");
        editor.commit();

        Log.d("HEJ", sp.getString("name", s));


        // ba =  R.layout.highscore;


//    }
    }
}
