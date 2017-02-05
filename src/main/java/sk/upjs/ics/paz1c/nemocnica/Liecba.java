
package sk.upjs.ics.paz1c.nemocnica;

public class Liecba {
    
    private int id;
    private String nazov;
    private String popis;

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String toString() {
        return nazov;
    }
}
