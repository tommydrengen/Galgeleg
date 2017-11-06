package com.example.thomas.galgeleg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.thomas.galgeleg.R.id.tv;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
//grænsefladeklasse

    TextView synligtOrd;
    Button b1;
    EditText editText;
    ImageView iv;
    public static final String TAG = "ThomassBesked";
    Galgelogik gl= new Galgelogik(); // gl har alle attributter, nulstilles og opdaterer synligt ord


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);

        editText = (EditText) findViewById(R.id.et);
        Log.i(TAG,"onCreate");
        synligtOrd = (TextView) findViewById(tv);
        synligtOrd.setText(gl.getSynligtOrd());
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        iv=(ImageView) findViewById(R.id.imageView);


    }

    @Override
    public void onClick(View view) {
        if(view==b1)
        {

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





            // Intent i = new Intent(this, Spil.class);
           // startActivity(i);
        }


    }
}
