package sk.upjs.ics.paz1c.nemocnica;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.ics.paz1c.nemocnica.Pacient;
import sk.upjs.ics.paz1c.nemocnica.Liek;
import sk.upjs.ics.paz1c.nemocnica.Diagnoza;
import sk.upjs.ics.paz1c.nemocnica.Lekar;
import java.util.Scanner;

public class Zaznam {
    
    
    private Pouzivatel pouzivatel;
    private Lekar lekar;
    private Pacient pacient;
    private Diagnoza diagnoza;
    private Liek liek;
    private Liecba liecba;

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Diagnoza getDiagnoza() {
        return diagnoza;
    }

    public void setDiagnoza(Diagnoza diagnoza) {
        this.diagnoza = diagnoza;
    }

    public Liek getLiek() {
        return liek;
    }

    public void setLiek(Liek liek) {
        this.liek = liek;
    }
    
     public Liecba getLiecba() {
        return liecba;
    }

    public void setLiecba(Liecba liecba) {
        this.liecba = liecba;
    }
     public Pouzivatel getPouzivatel() {
        return pouzivatel;
    }

    public void setPouzivatel(Pouzivatel pouzivatel) {
        this.pouzivatel = pouzivatel;
    }
                        
    @Override
    public String toString() {
        return lekar.toString() + "  |  " + pacient.toString() + "  |  "+ diagnoza.toString() + "  |  " + liek.toString() + "  |  "+ liecba.toString();
    } 

    
}
