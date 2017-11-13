package controlador;

import dao.AreasD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.AreasM;

@ManagedBean
@SessionScoped
public class AreasC implements Serializable{

    AreasM areas = new AreasM();
    AreasD dao = new AreasD();
    private List<AreasM> lstAreas;
    
    @PostConstruct
    public void inicio(){
        try {
            listarAreas();
        } catch (Exception e) {
        }
    }
    
    public void listarAreas(){
        try {
            lstAreas = dao.listarAreas();
        } catch (Exception e) {
        }
    }

    public AreasM getAreas() {
        return areas;
    }

    public void setAreas(AreasM areas) {
        this.areas = areas;
    }

    public AreasD getDao() {
        return dao;
    }

    public void setDao(AreasD dao) {
        this.dao = dao;
    }

    public List<AreasM> getLstAreas() {
        return lstAreas;
    }

    public void setLstAreas(List<AreasM> lstAreas) {
        this.lstAreas = lstAreas;
    }
    
    
    
}
