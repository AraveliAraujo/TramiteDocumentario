package modelo;

import org.hibernate.validator.constraints.Email;

public class UsuariosM {

    private String CodUsu, DniUsu, NomUsu, Dpto, Prov, Dist,
            ApeUsu, CelUsu, DirUsum, CodUbi;

    @Email(message = "Corregir el correo ingresado")
    private String EmaUsu;

    public String getCodUsu() {
        return CodUsu;
    }

    public void setCodUsu(String CodUsu) {
        this.CodUsu = CodUsu;
    }

    public String getDniUsu() {
        return DniUsu;
    }

    public void setDniUsu(String DniUsu) {
        this.DniUsu = DniUsu;
    }

    public String getNomUsu() {
        return NomUsu;
    }

    public void setNomUsu(String NomUsu) {
        this.NomUsu = NomUsu;
    }

    public String getApeUsu() {
        return ApeUsu;
    }

    public void setApeUsu(String ApeUsu) {
        this.ApeUsu = ApeUsu;
    }

    public String getEmaUsu() {
        return EmaUsu;
    }

    public void setEmaUsu(String EmaUsu) {
        this.EmaUsu = EmaUsu;
    }

    public String getCelUsu() {
        return CelUsu;
    }

    public void setCelUsu(String CelUsu) {
        this.CelUsu = CelUsu;
    }

    public String getDirUsum() {
        return DirUsum;
    }

    public void setDirUsum(String DirUsum) {
        this.DirUsum = DirUsum;
    }

    public String getCodUbi() {
        return CodUbi;
    }

    public void setCodUbi(String CodUbi) {
        this.CodUbi = CodUbi;
    }

    public String getDpto() {
        return Dpto;
    }

    public void setDpto(String Dpto) {
        this.Dpto = Dpto;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String Prov) {
        this.Prov = Prov;
    }

    public String getDist() {
        return Dist;
    }

    public void setDist(String Dist) {
        this.Dist = Dist;
    }

}
