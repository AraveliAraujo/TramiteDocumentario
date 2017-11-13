package controlador;

import dao.EmpleadosD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.EmpleadosM;

@ManagedBean
@SessionScoped
public class EmpleadosC implements Serializable{

    EmpleadosM empleados = new EmpleadosM();
    EmpleadosD dao = new EmpleadosD();
    private List<EmpleadosM> lstEmpleados;
    
    @PostConstruct
    public void inicio(){
        try {
            listarEmpleados();
        } catch (Exception e) {
        }
    }
    
    public void listarEmpleados(){
        try {
            lstEmpleados = dao.listarEmpleados();
        } catch (Exception e) {
        }
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
    
    
}
