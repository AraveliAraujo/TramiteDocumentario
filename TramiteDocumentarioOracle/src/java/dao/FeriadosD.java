package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelo.FeriadosM;

public class FeriadosD extends Dao{
    
    Format formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    public void addFeriados(FeriadosM feriados) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTFERIADOS(?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, formatter.format(feriados.getDiaFer()));
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public List<FeriadosM> listarFeriados() throws Exception {
        List<FeriadosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM FERIADOS ORDER BY CODFER";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            FeriadosM fer;
            while (rs.next()) {
                fer = new FeriadosM();
                fer.setCodFer(rs.getString("CODFER"));
                fer.setDiaFer(rs.getDate("FERIADOS"));
                lista.add(fer);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
