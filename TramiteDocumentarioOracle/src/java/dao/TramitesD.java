package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TramitesM;

public class TramitesD extends Dao {

    public void addTramites(TramitesM tramites) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTTRAMITE(?,?,?,?,?,?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "EN ESPERA");
            ps.setString(2, tramites.getRptaTram());
            ps.setString(3, tramites.getObserTram());
            ps.setString(4, tramites.getFoliacion());
            ps.setString(5, tramites.getAsuntoTram());
            ps.setString(6, tramites.getCodUsu());
            ps.setString(7, tramites.getCodEmpre());
            ps.setString(8, tramites.getCodA());
            ps.setString(9, tramites.getCodDocs());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    

    public List<TramitesM> listarTramites() throws Exception {
        List<TramitesM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM TRAMITES ORDER BY CODTRAM";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            TramitesM tram;
            while (rs.next()) {
                tram = new TramitesM();
                tram.setCodTram(rs.getString("CodTram"));
                tram.setFechTram(rs.getDate("FechTram"));
                tram.setEstatram(rs.getString("EstadTram"));
                tram.setRptaTram(rs.getString("RptaTram"));
                tram.setObserTram(rs.getString("ObserTram"));
                tram.setFoliacion(rs.getString("Foliacion"));
                tram.setAsuntoTram(rs.getString("AsuntoTram"));
                tram.setCodUsu(rs.getString("CodUsu"));
                tram.setCodEmpre(rs.getString("CodEmpre"));
                tram.setCodA(rs.getString("CodA"));
                tram.setCodDocs(rs.getString("CodDocs"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<TramitesM> listarEmpleado() throws Exception {
        List<TramitesM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM EMPLEADOS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            TramitesM tram;
            while (rs.next()) {
                tram = new TramitesM();
                tram.setCodEmp(rs.getString("CodEmp"));
                tram.setNomEmp(rs.getString("NomEmp"));
                tram.setApeEmp(rs.getString("ApeEmp"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<TramitesM> listarTramFechas() throws Exception {
        List<TramitesM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VW_TRAMITES";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            TramitesM tram;
            while (rs.next()) {
                tram = new TramitesM();
                tram.setCodTram(rs.getString("CodTram"));
                tram.setFechTram(rs.getDate("FechTram"));
                tram.setAsuntoTram(rs.getString("AsuntoTram"));
                tram.setEstatram(rs.getString("EstadTram"));
                tram.setDiasLegales(rs.getString("DiasLegales"));
                tram.setDiasExcedidos(rs.getString("DiasExcedidos"));
                tram.setDiasReales(rs.getString("DiasReales"));
                tram.setCodUsu(rs.getString("CodUsu"));
                tram.setCodEmpre(rs.getString("CodEmpre"));
                tram.setCodA(rs.getString("CodA"));
                tram.setCodDocs(rs.getString("CodDocs"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public List<TramitesM> listarTramBusqueda(String dni) throws Exception {
        List<TramitesM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM VW_Busqueda where DniUsu = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            lista = new ArrayList();
            TramitesM tram;
            while (rs.next()) {
                tram = new TramitesM();
                tram.setCodTram(rs.getString("CodTram"));
                tram.setFechTram(rs.getDate("FechTram"));
                tram.setAsuntoTram(rs.getString("AsuntoTram"));
                tram.setEstatram(rs.getString("EstadTram"));
                tram.setDiasLegales(rs.getString("DiasLegales"));
                tram.setDiasExcedidos(rs.getString("DiasExcedidos"));
                tram.setDiasReales(rs.getString("DiasReales"));
                tram.setCodUsu(rs.getString("CodUsu"));
                tram.setCodEmpre(rs.getString("CodEmpre"));
                tram.setCodA(rs.getString("CodA"));
                tram.setCodDocs(rs.getString("CodDocs"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public void addDerivacion(TramitesM tramites) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTDERIVACION(?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tramites.getCodEmp());
            ps.setString(2, tramites.getCodA());
            ps.setString(3, tramites.getObserTram());
            ps.setString(4, tramites.getCodTram());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
   
    
    public void editTramite(TramitesM tram) throws Exception {
        this.Conectar();
        try {
            String sql = "BEGIN updatetramite(?,?,?,?,?,?,?,?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, tram.getCodTram());
            ps.setDate(2, tram.getFechTram());
            ps.setString(3, tram.getEstatram());
            ps.setString(4, tram.getRptaTram());
            ps.setString(5, tram.getObserTram());
            ps.setString(6, tram.getFoliacion());
            ps.setString(7, tram.getAsuntoTram());
            ps.setString(8, tram.getCodUsu());
            ps.setString(9, tram.getCodEmp());
            ps.setString(10, tram.getCodA());
            ps.setString(11, tram.getCodDocs());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

     public TramitesM leer(String codTram) throws Exception {
        ResultSet rs;
        TramitesM tram = null;
        try {
            this.Conectar();
            String sql = "select * from tramites where codTram = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, codTram);
            rs = ps.executeQuery();
            if (rs.next()) {
                tram = new TramitesM();
                tram.setCodTram(rs.getString("CODTRAM"));
                tram.setFechTram(rs.getDate("FECHTRAM"));
                tram.setEstatram(rs.getString("ESTADTRAM"));
                tram.setRptaTram(rs.getString("RPTATRAM"));
                tram.setObserTram(rs.getString("OBSERTRAM"));
                tram.setFoliacion(rs.getString("FOLIACION"));
                tram.setAsuntoTram(rs.getString("ASUNTOTRAM"));
                tram.setCodUsu(rs.getString("CODUSU"));
                tram.setCodEmpre(rs.getString("CODEMPRE"));
                tram.setCodA(rs.getString("CODA"));
                tram.setCodDocs(rs.getString("CODDOCS"));
            }
        } catch (Exception e) {
            throw e;
        }
        return tram;
    }
     
}
