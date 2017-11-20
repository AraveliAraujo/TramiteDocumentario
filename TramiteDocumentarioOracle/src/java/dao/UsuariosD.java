package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.UsuariosM;

public class UsuariosD extends Dao{
    
    public List<UsuariosM> listarUsuarioss() throws Exception {
        List<UsuariosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "select * from VW_USUARIOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            UsuariosM tram;
            while (rs.next()) {
                tram = new UsuariosM();
                tram.setCodUsu(rs.getString("CODUSU"));
                tram.setDniUsu(rs.getString("DNIUSU"));
                tram.setNomUsu(rs.getString("NOMUSU"));
                tram.setApeUsu(rs.getString("APEUSU"));
                tram.setEmaUsu(rs.getString("EMAILUSU"));
                tram.setCelUsu(rs.getString("CELUSU"));
                tram.setDirUsum(rs.getString("DIRECUSU"));
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
    
        public void addUsuarios(UsuariosM user) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTUSUARIO(?,?,?,?,?,?,?);END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, user.getDniUsu());
            ps.setString(2, user.getNomUsu());
            ps.setString(3, user.getApeUsu());
            ps.setString(4, user.getEmaUsu());
            ps.setString(5, user.getCelUsu());
            ps.setString(6, user.getDirUsum());
            ps.setString(7, user.getCodUbi());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
        
        public List<String> queryAutoCompleteUbi(String a) throws Exception {
        this.Conectar();
        ResultSet rs;
        List<String> lista;
        String sql;
        try {
            if (a == null || "".equals(a)) {
                sql = "SELECT CODUBI,CONCAT(CONCAT(CONCAT(CONCAT(DPTO,','),PROV),','),DIST) AS NOMBRE FROM UBIGEO WHERE PROV LIKE ?";
                a = "CAÑETE";
            } else {
                sql = "SELECT CODUBI,CONCAT(CONCAT(CONCAT(CONCAT(DPTO,','),PROV),','),DIST) AS NOMBRE FROM UBIGEO WHERE Dist like UPPER(?)";
            }
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + a + "%");
            rs = ps.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                lista.add(rs.getString("NOMBRE"));
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
        
        public String leerUbi(String a) throws Exception {
        this.Conectar();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE CONCAT(CONCAT(CONCAT(CONCAT(DPTO,','),PROV),','),DIST) = ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
