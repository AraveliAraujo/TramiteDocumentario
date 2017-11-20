package controlador;

import dao.DocumentosD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DocumentosM;

@ManagedBean
@SessionScoped
public class DocumentosC implements Serializable {

    DocumentosM documentos = new DocumentosM();
    DocumentosD dao = new DocumentosD();
    private List<DocumentosM> lstDocumentos;
    private DocumentosM selected;
    private boolean acdes;
    private int tupa;

    @PostConstruct
    public void inicio() {
        try {
            listarDocs();
        } catch (Exception e) {
        }
    }

    public void listarDocs() throws Exception {
        try {
            lstDocumentos = dao.listarDocumentos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void addDocs() {
        try {
            dao.addDocumentos(documentos);
            listarDocs();
            limpiarDocs();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Documento Ingresado"));
        } catch (Exception e) {
        }
    }

    public void limpiarDocs() {
        try {
            documentos = new DocumentosM();
        } catch (Exception e) {
        }
    }

    public void preparedDocs() throws Exception {
        selected = new DocumentosM();
    }

    public void condicion() {
        if (getTupa()== 1) {
            setAcdes(true);
        } else {
            setAcdes(true);
        }
    }

    public DocumentosM getDocumentos() {
        return documentos;
    }

    public void setDocumentos(DocumentosM documentos) {
        this.documentos = documentos;
    }

    public DocumentosD getDao() {
        return dao;
    }

    public void setDao(DocumentosD dao) {
        this.dao = dao;
    }

    public List<DocumentosM> getLstDocumentos() {
        return lstDocumentos;
    }

    public void setLstDocumentos(List<DocumentosM> lstDocumentos) {
        this.lstDocumentos = lstDocumentos;
    }

    public DocumentosM getSelected() {
        return selected;
    }

    public void setSelected(DocumentosM selected) {
        this.selected = selected;
    }

    public boolean isAcdes() {
        return acdes;
    }

    public void setAcdes(boolean acdes) {
        this.acdes = acdes;
    }

    public int getTupa() {
        return tupa;
    }

    public void setTupa(int tupa) {
        this.tupa = tupa;
    }


}
