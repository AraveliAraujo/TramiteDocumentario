package controlador;

import dao.EmpleadosD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EmpleadosM;

@ManagedBean
@SessionScoped
public class EmpleadosC implements Serializable {

    EmpleadosM empleados = new EmpleadosM();
    EmpleadosD dao = new EmpleadosD();
    private List<EmpleadosM> lstEmpleados;
    private EmpleadosM selected;

    @PostConstruct
    public void inicio() {
        try {
            listarEmpleados();
        } catch (Exception e) {
        }
    }

    public void listarEmpleados() {
        try {
            lstEmpleados = dao.listarEmpleados();
        } catch (Exception e) {
        }
    }

    public void addEmpleado() throws Exception {
        try {
            empleados.setCodUbi(dao.leerUbi(empleados.getCodUbi()));
            dao.addEmpleados(empleados);
            listarEmpleados();
            limpiarEmpleados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Empleado Agregado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiarEmpleados() {
        try {
            selected = new EmpleadosM();
        } catch (Exception e) {
        }
    }

    public List<String> completeTextUbi(String query) throws Exception {
        return dao.queryAutoCompleteUbi(query);
    }

    public EmpleadosM getEmpleados() {
        return empleados;
    }

    public void setEmpleados(EmpleadosM empleados) {
        this.empleados = empleados;
    }

    public EmpleadosD getDao() {
        return dao;
    }

    public void setDao(EmpleadosD dao) {
        this.dao = dao;
    }

    public List<EmpleadosM> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(List<EmpleadosM> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }

    public EmpleadosM getSelected() {
        return selected;
    }

    public void setSelected(EmpleadosM selected) {
        this.selected = selected;
    }

}
