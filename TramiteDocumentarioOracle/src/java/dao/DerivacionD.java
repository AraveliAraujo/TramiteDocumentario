package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DerivacionM;
import modelo.TramitesM;

public class DerivacionD extends Dao {

    public void addDerivacion(DerivacionM derivacion) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTDERIVACION(?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, derivacion.getCodEmple());
            ps.setString(2, derivacion.getCodA());
            ps.setString(3, derivacion.getObserDer());
            ps.setString(4, derivacion.getCodTram());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<DerivacionM> listarDerivaciones(String doc) throws Exception {
        List<DerivacionM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VW_DERIVACION where CodTram = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, doc);
            rs = ps.executeQuery();
            lista = new ArrayList();
            DerivacionM der;
            while (rs.next()) {
                der = new DerivacionM();
                der.setCodDer(rs.getString("CodDer"));
                der.setNomEmple(rs.getString("NomEmp"));
                der.setApeEmple(rs.getString("ApeEmp"));
                der.setFecDer(rs.getString("FecDer"));
                der.setNomArea(rs.getString("NomA"));
                der.setObserDer(rs.getString("ObserDer"));
                der.setCodTram(rs.getString("CodTram"));
                lista.add(der);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
