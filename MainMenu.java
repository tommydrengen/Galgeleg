package com.example.thomas.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = new Intent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==b1){
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);

        }
        if(view==b2){
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);

        }
        if(view==b3){
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);

        }

    }
}
