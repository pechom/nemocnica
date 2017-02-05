package sk.upjs.ics.paz1c.nemocnica;

import java.util.Scanner;

public class Pacient {
    
    private int id;
    private String meno;
    private String priezvisko;
    private int vek;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }
 
    @Override
    public String toString() {
        return meno + "   " + priezvisko;
    }
}
