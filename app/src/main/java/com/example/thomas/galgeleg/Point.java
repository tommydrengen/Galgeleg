package com.example.thomas.galgeleg;

import java.io.Serializable;

/**
 * Created by Thomas on 07/11/2017.
 */

public class Point implements Serializable {
    public int navn=0;
    public int score;


    public Point(int navn, int score){
        this.navn = navn;
        this.score=score;
        navn++;

    }
    void setPoint(Point p, Galgelogik gl){
        p.score = gl.getOrdet().length()-gl.getAntalForkerteBogstaver();

    }

    public int getScore(){
        return this.score;
    }

    void setScore(int i){
        this.score=i;
    }

    public String toString(){
       return new Integer(navn).toString() +", "+new Integer(score).toString();
    }

}
