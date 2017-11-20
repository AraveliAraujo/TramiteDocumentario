package controlador;

import dao.EmpresasD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EmpresasM;

@ManagedBean
@SessionScoped
public class EmpresasC implements Serializable{
    
    EmpresasM empresas = new EmpresasM();
    EmpresasD dao = new EmpresasD();
    private List<EmpresasM> lstEmpresas;
    private EmpresasM selected;
    
    @PostConstruct
    public void inicio(){
        try {
            listarEmpresas();
        } catch (Exception e) {
        }
    }
    
    public void listarEmpresas(){
        try {
            lstEmpresas = dao.listarEmpresas();
        } catch (Exception e) {
        }
    }
    
    public void addEmpresa() throws Exception{
        try {
            dao.addEmpresas(empresas);
            listarEmpresas();
            limpiarEmpresas();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Empresa Ingresada"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public void limpiarEmpresas() {
        try {
            empresas = new EmpresasM();
        } catch (Exception e) {
        }
    }
    
public void preparedEmpresas() throws Exception {
        selected = new EmpresasM();
    }

    public EmpresasM getEmpresas() {
        return empresas;
    }

    public void setEmpresas(EmpresasM empresas) {
        this.empresas = empresas;
    }

    public EmpresasD getDao() {
        return dao;
    }

    public void setDao(EmpresasD dao) {
        this.dao = dao;
    }

    public List<EmpresasM> getLstEmpresas() {
        return lstEmpresas;
    }

    public void setLstEmpresas(List<EmpresasM> lstEmpresas) {
        this.lstEmpresas = lstEmpresas;
    }

    public EmpresasM getSelected() {
        return selected;
    }

    public void setSelected(EmpresasM selected) {
        this.selected = selected;
    }
    
    
}
