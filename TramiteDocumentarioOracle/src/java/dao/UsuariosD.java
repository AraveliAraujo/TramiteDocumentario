package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.UsuariosM;

public class UsuariosD extends Dao{
    
    public List<UsuariosM> listarDocumentos() throws Exception {
        List<UsuariosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM USUARIOS";
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
                tram.setCodUbi(rs.getString("CODUBI"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
