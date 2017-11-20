package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresasM;

public class EmpresasD extends Dao {

    public List<EmpresasM> listarEmpresas() throws Exception {
        List<EmpresasM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VW_EMPRESAS";
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
                tram.setDpto(rs.getString("DPTO"));
                tram.setProv(rs.getString("PROV"));
                tram.setDist(rs.getString("DIST"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public void addEmpresas(EmpresasM empre) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTEMPRESA(?,?,?,?,?);END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, empre.getNomEmpre());
            ps.setString(2, empre.getRucEmpre());
            ps.setString(3, empre.getDirEmpre());
            ps.setString(4, empre.getTelEmpre());
            ps.setString(5, empre.getCodUbi());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
