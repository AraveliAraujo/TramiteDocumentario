package controlador;

import dao.DerivacionD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DerivacionM;
import modelo.TramitesM;

@ManagedBean
@SessionScoped
public class DerivacionC implements Serializable{

    DerivacionM derivacion = new DerivacionM();
    DerivacionD dao = new DerivacionD();
    private List<DerivacionM> lstDerivacion;
    private DerivacionM selected;
    private TramitesM selectedTram;

    @PostConstruct
    public void inicio() {
        try {
            listarDerivacion();
        } catch (Exception e) {
        }
    }

    public void listarDerivacion() {
        try {
            lstDerivacion = dao.listarDerivaciones(selectedTram.getCodTram());
        } catch (Exception e) {
        }
    }

    public void addDerivacion() throws Exception {
        try {
            derivacion.setCodTram(selectedTram.getCodTram());
            dao.addDerivacion(derivacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Documento Derivado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void preparedTramites() throws Exception {
        selected = new DerivacionM();
    }

    public DerivacionM getDerivacion() {
        return derivacion;
    }

    public void setDerivacion(DerivacionM derivacion) {
        this.derivacion = derivacion;
    }

    public DerivacionD getDao() {
        return dao;
    }

    public void setDao(DerivacionD dao) {
        this.dao = dao;
    }

    public List<DerivacionM> getLstDerivacion() {
        return lstDerivacion;
    }

    public void setLstDerivacion(List<DerivacionM> lstDerivacion) {
        this.lstDerivacion = lstDerivacion;
    }

    public DerivacionM getSelected() {
        return selected;
    }

    public void setSelected(DerivacionM selected) {
        this.selected = selected;
    }

    public TramitesM getSelectedTram() {
        return selectedTram;
    }

    public void setSelectedTram(TramitesM selectedTram) {
        this.selectedTram = selectedTram;
    }

}
