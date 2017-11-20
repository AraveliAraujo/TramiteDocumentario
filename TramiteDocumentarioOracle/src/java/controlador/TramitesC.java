package controlador;

import dao.TramitesD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.TramitesM;

@ManagedBean
@SessionScoped
public class TramitesC implements Serializable {

    TramitesM tramites = new TramitesM();
    TramitesD dao = new TramitesD();
    private List<TramitesM> lstTramites;
    private List<TramitesM> lstTramFechas;
    private List<TramitesM> lstTramBusqueda;
    private List<TramitesM> lstEmpleados;
    private List<TramitesM> lstDerivacion;
    private List<TramitesM> lstTraFilter;
    private TramitesM selected;
    private String dni = null;
    private TramitesM SelectedTramites;

    @PostConstruct
    public void inicio() {
        try {
            listarTramFechas();
            listarEmpleados();
            listarTramitesAll();
        } catch (Exception e) {
        }
    }

    public void listarTramites() throws Exception {
        try {
            lstTramites = dao.listarAllTramites();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Trámites", "Pendientes"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTramitesAll() throws Exception {
        try {
            lstTramites = dao.listarAllTramites();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Trámites", "Todos"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTramitesInac() throws Exception {
        try {
            lstTramites = dao.listarTramitesInac();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Trámites", "Cerrados"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarTramFechas() {
        try {
            lstTramFechas = dao.listarTramFechas();
        } catch (Exception e) {
        }
    }

    public void listarEmpleados() {
        try {
            lstEmpleados = dao.listarEmpleado();
        } catch (Exception e) {
        }
    }

    public void listarTramBusqueda() {
        try {
            dao = new TramitesD();
            lstTramBusqueda = dao.listarTramBusqueda(dni);
            limpiar();
        } catch (Exception e) {
            System.out.println("No Encontrado" + e);
        }
    }

    public void addTramite() throws Exception {
        try {
            tramites.setCodUsu(dao.leerUsu(tramites.getCodUsu()));
            tramites.setCodEmpre(dao.leerEmpre(tramites.getCodEmpre()));
            dao.addTramites(tramites);
            listarTramites();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Trámite Ingresado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        try {
            tramites = new TramitesM();
        } catch (Exception e) {
        }
    }

    public void addDerivacion() throws Exception {
        try {
            tramites.setCodTram(selected.getCodTram());
            dao.addDerivacion(tramites);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarTram() throws Exception {
        try {
            dao.editTramite(tramites);
            listarTramites();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void pasar() throws Exception {
        try {
            tramites = dao.leer(selected.getCodTram());
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public List<String> completeTextUsu(String query) throws Exception {
        return dao.queryAutoCompleteUsu(query);
    }
   
    public List<String> completeTextEmpre(String query) throws Exception {
        return dao.queryAutoCompleteEmpre(query);
    }

    public void preparedTramites() throws Exception {
        selected = new TramitesM();
    }

    public TramitesM getTramites() {
        return tramites;
    }

    public void setTramites(TramitesM tramites) {
        this.tramites = tramites;
    }

    public TramitesD getDao() {
        return dao;
    }

    public void setDao(TramitesD dao) {
        this.dao = dao;
    }

    public List<TramitesM> getLstTramites() {
        return lstTramites;
    }

    public void setLstTramites(List<TramitesM> lstTramites) {
        this.lstTramites = lstTramites;
    }

    public List<TramitesM> getLstTramFechas() {
        return lstTramFechas;
    }

    public void setLstTramFechas(List<TramitesM> lstTramFechas) {
        this.lstTramFechas = lstTramFechas;
    }

    public TramitesM getSelected() {
        return selected;
    }

    public void setSelected(TramitesM selected) {
        this.selected = selected;
    }

    public List<TramitesM> getLstTramBusqueda() {
        return lstTramBusqueda;
    }

    public void setLstTramBusqueda(List<TramitesM> lstTramBusqueda) {
        this.lstTramBusqueda = lstTramBusqueda;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<TramitesM> getLstDerivacion() {
        return lstDerivacion;
    }

    public void setLstDerivacion(List<TramitesM> lstDerivacion) {
        this.lstDerivacion = lstDerivacion;
    }

    public List<TramitesM> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<TramitesM> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }

    public TramitesM getSelectedTramites() {
        return SelectedTramites;
    }

    public void setSelectedTramites(TramitesM SelectedTramites) {
        this.SelectedTramites = SelectedTramites;
    }

    public List<TramitesM> getLstTraFilter() {
        return lstTraFilter;
    }

    public void setLstTraFilter(List<TramitesM> lstTraFilter) {
        this.lstTraFilter = lstTraFilter;
    }

}
