package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.DocumentosM;

public class DocumentosD extends Dao{
    
    public List<DocumentosM> listarDocumentos() throws Exception {
        List<DocumentosM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM DOCUMENTOS ORDER BY CODDOCS";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList();
            DocumentosM tram;
            while (rs.next()) {
                tram = new DocumentosM();
                tram.setCodDocs(rs.getInt("CODDOCS"));
                tram.setTipoDocs(rs.getString("TIPDOCS"));
                tram.setDiaDocs(rs.getInt("DIADOCS"));
                tram.setCostDocs(rs.getFloat("COSTODOCS"));
                tram.setTupa(rs.getString("TUPA"));
                lista.add(tram);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
    public void addDocumentos(DocumentosM docs) throws Exception {
        try {
            this.Conectar();
            String sql = "BEGIN INSERTDOCUMENTO(?,?,?,?); END;";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, docs.getTipoDocs());
            ps.setInt(2, docs.getDiaDocs());
            ps.setFloat(3, docs.getCostDocs());
            ps.setString(4, docs.getTupa());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
