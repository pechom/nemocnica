package sk.upjs.ics.paz1c.nemocnica;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class PacientTableModel extends AbstractTableModel{

    private PacientDAO pacientDao = DaoFactory.INSTANCE.getPacientDao();
    
    private static final String[] NAZVY_STLPCOV = {"Meno", "Priezvisko", "Vek"};
    
    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;
    
    @Override
    public int getRowCount() {
        return pacientDao.dajPacietov().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    // pridelenie hodnot do jednotlivych stlpcov v tabulke
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacient pacient = pacientDao.dajPacietov().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pacient.getMeno();
            case 1:
                return pacient.getPriezvisko();
            case 2:
                return pacient.getVek();
          
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
    Pacient getPacientAt(int riadok) {
       return pacientDao.dajPacietov().get(riadok);
    }
    
}