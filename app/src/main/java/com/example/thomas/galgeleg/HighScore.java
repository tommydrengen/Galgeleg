package com.example.thomas.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HighScore extends AppCompatActivity implements OnItemClickListener, Serializable{
    static final String TAG ="" ;
    //inspireret af Jacobs BenytListView
    ListView listView;
    /*final*/ Point[]  score = new Point[10];
   // JSONArray js;
    int spillernr = 1;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    ArrayAdapter<String> aa;
    String hs;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();
        editor.putString(String.valueOf(R.id.highScoreListe), listView.toString());
        String s=sp.getString("Du har vundet","tillykke");
        listView = (ListView) findViewById(R.id.highScoreListe);
        aa.add(sp.toString());


        hs = score.toString();

        listView = (ListView) editor.putString("score", this.hPoint());
        //listView.set = (ListView) this.hPoint()

        //sp.edit().putString(("point",1+ hPoint());

        String score= sp.getString("score", this.hPoint());



        Log.d(TAG, "onCreate: hPoint");







        editor.commit();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        listView =  findViewById(R.id.highScoreListe);

        System.out.println("oncreate");


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listeelement_layout, R.id.spillernavn) {


            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                ListView listView = v.findViewById(R.id.highScoreListe);
                TextView point = v.findViewById(R.id.point);
                point.setText("" + position);
                TextView snavn = v.findViewById(R.id.spillernavn);

                snavn.setText(listView.toString());


                return v;
            }
        };
        Log.d(TAG, "getView: "+(listView.toString()));

        // listView = (ListView) findViewById(R.id.highScoreListe);
        System.out.println(adapter);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

    }

    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        Toast.makeText(this, "Klik på " + position, Toast.LENGTH_SHORT).show();
    }
    public void add(Galgelogik gl){

        Point p = null;
       // p.score= gl.getOrdet().length()- gl.getAntalForkerteBogstaver();

        for( int i=0; i < score.length; i++){
            if(score[i].equals(null)){
                score[i]= p;
                if (p.getScore() > score[10].getScore()) {
                    score[10]=p;
                    sort();
                }
                }
                break;
        }
        sort();
        spillernr++;
        }

    public Point getScore(int i) {
        return score[i];
    }

    public  String hPoint(){
        String points="";

        for(int i = 0; i < this.score.length; i++){
            points += ", "+ this.score[i].toString();
        }
        return  points;
    }


    //sort

    public  void sort(){
        int i;
        for( int j = 1; j < score.length; j++){
            int p = score[j].getScore();
            i=j-1;
            while(i>0 && score[i].getScore()> p){
                score[i+1]=score[i];
                i--;
                score[i+1].score = p;
            }
        }

    }
    //serialisér ArrayAdaptor adaptor
    public void set(ArrayAdapter adapter){




        // Writing "foo" to a stream (for example, a file)
        try{
// Step 1. Create an output stream

// that is, create bucket to receive the bytes

            FileOutputStream out = new FileOutputStream(getFilesDir()+"/hiscore.ser");

// Step 2. Create ObjectOutputStream

// that is, create a hose and put its head in the bucket

            ObjectOutputStream os = new ObjectOutputStream(out);

// Step 3. Write a string and an object to the stream

// that is, let the stream flow into the bucket



            os.writeObject(score);

// Step 4. Flush the data to its destination

            os.flush();

        }
        catch (Exception e){
            e.printStackTrace();
        }


        try{
            // Reading an object from a stream

// Step 1. Create an input stream

            FileInputStream in = new FileInputStream(score.toString());

// Step 2. Create an object input stream

            ObjectInputStream ins = new ObjectInputStream(in);

// Step 3. Got to know what you are reading

            score = (Point[]) ins.readObject();
            ins.close();


            System.out.println("hurra");

        }

        catch (Exception e){e.printStackTrace();}

    }

}