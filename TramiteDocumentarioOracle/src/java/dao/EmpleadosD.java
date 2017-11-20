package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadosM;

public class EmpleadosD extends Dao {

    public List<EmpleadosM> listarEmpleados() throws Exception {
        List<EmpleadosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VW_EMPLEADOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            EmpleadosM empl;
            while (rs.next()) {
                empl = new EmpleadosM();
                empl.setDniEmple(rs.getString("DNIEMP"));
                empl.setNomEmple(rs.getString("NOMEMP"));
                empl.setApeEmple(rs.getString("APEEMP"));
                empl.setEmaiEmple(rs.getString("EMAILEMP"));
                empl.setCelEmple(rs.getString("CELEMP"));
                empl.setDirEmple(rs.getString("DIRECEMP"));
                empl.setUserEmple(rs.getString("USEREMP"));
                empl.setLevelEmple(rs.getString("LEVELEMP"));
                empl.setDpto(rs.getString("DPTO"));
                empl.setProv(rs.getString("PROV"));
                empl.setDist(rs.getString("DIST"));
                empl.setNomA(rs.getString("NOMA"));
                lista.add(empl);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public void addEmpleados(EmpleadosM emple) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTEMPLEADO(?,?,?,?,?,?,?,?,?,?,?);END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, emple.getDniEmple());
            ps.setString(2, emple.getNomEmple());
            ps.setString(3, emple.getApeEmple());
            ps.setString(4, emple.getEmaiEmple());
            ps.setString(5, emple.getCelEmple());
            ps.setString(6, emple.getDirEmple());
            ps.setString(7, emple.getUserEmple());
            ps.setString(8, emple.getPssEmple());
            ps.setString(9, emple.getLevelEmple());
            ps.setString(10, emple.getCodUbi());
            ps.setString(11, emple.getCodA());
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
