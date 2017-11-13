package controlador;

import dao.UsuariosD;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.LogeoM;
import modelo.UsuariosM;
import servicios.SessionUtils;

@ManagedBean
@SessionScoped
public class UsuariosC implements Serializable {

    UsuariosM usuarios = new UsuariosM();
    UsuariosD dao = new UsuariosD();
    private List<UsuariosM> lstUsuarios;
    
    @PostConstruct
    public void inicio(){
        try {
            listarUsuarios();
        } catch (Exception e) {
        }
    }
    
    public void listarUsuarios(){
        try {
            lstUsuarios = dao.listarDocumentos();
        } catch (Exception e) {
        }
    }
    
    public void filterSession() throws IOException{
        try {
            LogeoM usu = SessionUtils.getUserName();
            if (usu == null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../../faces/index.xhtml");
            }
        } catch (IOException e) {
            throw e;
        }
    }
      

    public UsuariosM getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosM usuarios) {
        this.usuarios = usuarios;
    }

    public UsuariosD getDao() {
        return dao;
    }

    public void setDao(UsuariosD dao) {
        this.dao = dao;
    }

    public List<UsuariosM> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<UsuariosM> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    
}
