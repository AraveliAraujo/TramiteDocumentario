package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadosM;

public class EmpleadosD extends Dao{

    public List<EmpleadosM> listarEmpleados() throws Exception {
        List<EmpleadosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM EMPLEADOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            EmpleadosM empl;
            while (rs.next()) {
                empl = new EmpleadosM();
                empl.setCodEmple(rs.getString("CODEMP"));
                empl.setNomEmple(rs.getString("NOMEMP"));
                empl.setApeEmple(rs.getString("APEEMP"));
                empl.setDniEmple(rs.getString("DNIEMP"));
                empl.setEmaiEmple(rs.getString("EMAILEMP"));
                empl.setCelEmple(rs.getString("CELEMP"));
                empl.setDirEmple(rs.getString("DIRECEMP"));
                empl.setUserEmple(rs.getString("USEREMP"));
                empl.setLevelEmple(rs.getString("LEVELEMP"));
                empl.setCodUbi(rs.getString("CODUBI"));
                empl.setCodA(rs.getString("CODA"));
                lista.add(empl);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    
}
