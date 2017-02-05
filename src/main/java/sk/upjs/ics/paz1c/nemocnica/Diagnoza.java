package sk.upjs.ics.paz1c.nemocnica;

import java.util.Scanner;

public class Diagnoza {
    
    private int id;
    private String nazov;

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return nazov;
    }
}
