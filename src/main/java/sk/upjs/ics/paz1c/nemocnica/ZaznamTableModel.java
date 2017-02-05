package sk.upjs.ics.paz1c.nemocnica;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class ZaznamTableModel extends AbstractTableModel{

    private ZaznamDAO zaznamDao = DaoFactory.INSTANCE.getZaznamDao();
    
    private static final String[] NAZVY_STLPCOV = {"Lekár", "Pacient", "Diagnóza", "Liek", "Liecba, Pouzivatel"};
    
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    
    @Override
    public int getRowCount() {
        return zaznamDao.dajZaznamy().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    // pridelenie hodnot do jednotlivych stlpcov v tabulke
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaznam zaznam = zaznamDao.dajZaznamy().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zaznam.getLekar();
            case 1:
                return zaznam.getPacient();
            case 2:
                return zaznam.getDiagnoza();
            case 3:
                return zaznam.getLiek();
            case 4:
                return zaznam.getLiecba();
            case 5:
                return zaznam.getPouzivatel();    
            default:
                return "???";
        }
    } 

    
    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }
    
    // aktualizovanie tabulky
    void aktualizovat() {
        fireTableDataChanged();
    }

    // vratenie zaznamu pri jeho kliknuti v tabulke
    Zaznam getZaznamAt(int riadok) {
       return zaznamDao.dajZaznamy().get(riadok);
    }
    
}
