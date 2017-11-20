package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.AreasM;

public class AreasD extends Dao {

    public List<AreasM> listarAreas() throws Exception {
        List<AreasM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM AREAS ORDER BY CODA";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            AreasM tram;
            while (rs.next()) {
                tram = new AreasM();
                tram.setCodArea(rs.getString("CODA"));
                tram.setNomArea(rs.getString("NOMA"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
