package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresasM;

public class EmpresasD extends Dao{
    
    public List<EmpresasM> listarEmpresas() throws Exception {
        List<EmpresasM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM EMPRESAS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            EmpresasM tram;
            while (rs.next()) {
                tram = new EmpresasM();
                tram.setCodEmpre(rs.getString("CODEMPRE"));
                tram.setNomEmpre(rs.getString("NOMEMPRE"));
                tram.setRucEmpre(rs.getString("RUCEMPRE"));
                tram.setDirEmpre(rs.getString("DIRECEMPRE"));
                tram.setTelEmpre(rs.getString("TELEMPRE"));
                tram.setCodUbi(rs.getString("CODUBI"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
