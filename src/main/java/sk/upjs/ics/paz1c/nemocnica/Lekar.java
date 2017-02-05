package sk.upjs.ics.paz1c.nemocnica;

import java.util.Scanner;

public class Lekar {
    
    private int id;
    private String meno;
    private String priezvisko;
    private String specializacia;
    
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

    public String getSpecializacia() {
        return specializacia;
    }

    public void setSpecializacia(String specializacia) {
        this.specializacia = specializacia;
    }
    
    @Override
    public String toString() {
        return meno + "   " + priezvisko + "   " +specializacia;
    }
    /*
    public String toFileLine() {
        return id + "\t" + menoL + "\t" + priezviskoL + "\t" + specializacia;
    }
    public Lekar(String fileLine) {
        Scanner sc = new Scanner(fileLine);
        sc.useDelimiter("\t");
        id = sc.nextInt();
        menoL = sc.next();
        priezviskoL = sc.next();
        specializacia = sc.next();
    }
*/
}
