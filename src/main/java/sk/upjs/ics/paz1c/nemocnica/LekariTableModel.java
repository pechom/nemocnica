package sk.upjs.ics.paz1c.nemocnica;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class LekariTableModel extends AbstractTableModel{

    private LekarDAO lekarDao = DaoFactory.INSTANCE.getLekarDao();
    
    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Specializacia"};
    
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    
    @Override
    public int getRowCount() {
        return lekarDao.dajLekarov().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    // pridelenie hodnot do jednotlivych stlpcov v tabulke
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lekar lekar = lekarDao.dajLekarov().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return lekar.getMeno();
            case 1:
                return lekar.getPriezvisko();
            case 2:
                return lekar.getSpecializacia();
          
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
    Lekar getLekarAt(int riadok) {
       return lekarDao.dajLekarov().get(riadok);
    }
    
}