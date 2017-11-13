package controlador;

import dao.EmpresasD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.EmpresasM;

@ManagedBean
@SessionScoped
public class EmpresasC implements Serializable{
    
    EmpresasM empresas = new EmpresasM();
    EmpresasD dao = new EmpresasD();
    private List<EmpresasM> lstEmpresas;
    
    @PostConstruct
    public void inicio(){
        try {
            listarTramites();
        } catch (Exception e) {
        }
    }
    
    public void listarTramites(){
        try {
            lstEmpresas = dao.listarEmpresas();
        } catch (Exception e) {
        }
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
    
    
}
