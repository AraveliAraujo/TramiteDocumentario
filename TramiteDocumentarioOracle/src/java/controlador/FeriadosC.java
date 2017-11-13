package controlador;

import dao.FeriadosD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.FeriadosM;

@ManagedBean
@SessionScoped
public class FeriadosC implements Serializable{

    FeriadosM feriados = new FeriadosM();
    FeriadosD dao = new FeriadosD();
    private List<FeriadosM> lstFeriados;
    private FeriadosM selected;
    
    @PostConstruct
    public void inicio(){
        try {
            listarFeriados();
        } catch (Exception e) {
        }
    }
    
    public void listarFeriados() throws Exception{
        try {
            lstFeriados = dao.listarFeriados();
        } catch (Exception e) {
            throw e;
        }
    }

    public void addaaaferiado() throws Exception {
        try {
            dao.addFeriados(feriados);
            listarFeriados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Trámite Ingresado"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void preparedFeriados() throws Exception {
        selected = new FeriadosM();
    }
    
    public FeriadosM getFeriados() {
        return feriados;
    }

    public void setFeriados(FeriadosM feriados) {
        this.feriados = feriados;
    }

    public FeriadosD getDao() {
        return dao;
    }

    public void setDao(FeriadosD dao) {
        this.dao = dao;
    }

    public List<FeriadosM> getLstFeriados() {
        return lstFeriados;
    }

    public void setLstFeriados(List<FeriadosM> lstFeriados) {
        this.lstFeriados = lstFeriados;
    }

    public FeriadosM getSelected() {
        return selected;
    }

    public void setSelected(FeriadosM selected) {
        this.selected = selected;
    }
    
}
