package com.example.thomas.galgeleg;
//Jeg ville Gerne have yderligere intents i appen, så jeg havde MainMenu, GameActivity, Settings og Help

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
//grænsefladeklasse

    TextView synligtOrd;
    Button b1;
    Button b2;
    EditText editText;
    ImageView iv;
    public static final String TAG = "ThomassBesked";
    Galgelogik gl; // gl har alle attributter, nulstilles og opdaterer synligt ord
    static SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        sp = PreferenceManager.getDefaultSharedPreferences(this);


        gl = new Galgelogik();

        editText = (EditText) findViewById(R.id.et);
        Log.i(TAG,"onCreate");
        synligtOrd = (TextView) findViewById(R.id.tv);
        synligtOrd.setText(gl.getSynligtOrd());
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        iv=(ImageView) findViewById(R.id.imageView);



    }

    @Override
    public void onClick(View view) {
        if(view==b1)
        { //virker vidst ikke

            //EditText et = (android.widget.EditText) R.id.et;

            gl.gætBogstav(editText.getText().toString());
            synligtOrd.setText(gl.getSynligtOrd());

            switch (gl.getAntalForkerteBogstaver()){

                case 0:
                    iv.setImageResource(R.drawable.galge);
                    break;

                case 1:
                    iv.setImageResource(R.drawable.forkert1);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.forkert2);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.forkert3);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.forkert4);
                    break;
                case 5:
                    iv.setImageResource(R.drawable.forkert5);
                    break;
                case 6:
                    iv.setImageResource(R.drawable.forkert6);
                    break;



            }






        }

        else if(view == b2){
            gl.nulstil();
            synligtOrd.setText(gl.getSynligtOrd());

        }
        if(gl.erSpilletSlut()) {

            if (gl.erSpilletVundet()) {
                String slut="Du har vundet";
                sp.edit().putString("vundet tekst", slut).apply();

                Intent i= new Intent(this, WinActivity.class);
                startActivity(i);
            }
            else{
                String slut="Du har tabt";
                sp.edit().putString("vundet tekst", slut).apply();
                Intent i= new Intent(this, LoseActivity.class);
                startActivity(i);
            }
    }
}
}
