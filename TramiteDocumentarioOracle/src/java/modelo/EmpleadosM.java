package modelo;

public class EmpleadosM {

    private String CodEmple,
            DniEmple, Dpto, Prov, Dist,
            NomEmple, ApeEmple, NomA,
            EmaiEmple, CelEmple,
            DirEmple, UserEmple, PssEmple,
            LevelEmple, CodUbi, CodA;

    public String getCodEmple() {
        return CodEmple;
    }

    public void setCodEmple(String CodEmple) {
        this.CodEmple = CodEmple;
    }

    public String getDniEmple() {
        return DniEmple;
    }

    public void setDniEmple(String DniEmple) {
        this.DniEmple = DniEmple;
    }

    public String getNomEmple() {
        return NomEmple;
    }

    public void setNomEmple(String NomEmple) {
        this.NomEmple = NomEmple;
    }

    public String getApeEmple() {
        return ApeEmple;
    }

    public void setApeEmple(String ApeEmple) {
        this.ApeEmple = ApeEmple;
    }

    public String getEmaiEmple() {
        return EmaiEmple;
    }

    public void setEmaiEmple(String EmaiEmple) {
        this.EmaiEmple = EmaiEmple;
    }

    public String getCelEmple() {
        return CelEmple;
    }

    public void setCelEmple(String CelEmple) {
        this.CelEmple = CelEmple;
    }

    public String getDirEmple() {
        return DirEmple;
    }

    public void setDirEmple(String DirEmple) {
        this.DirEmple = DirEmple;
    }

    public String getUserEmple() {
        return UserEmple;
    }

    public void setUserEmple(String UserEmple) {
        this.UserEmple = UserEmple;
    }

    public String getPssEmple() {
        return PssEmple;
    }

    public void setPssEmple(String PssEmple) {
        this.PssEmple = PssEmple;
    }

    public String getLevelEmple() {
        return LevelEmple;
    }

    public void setLevelEmple(String LevelEmple) {
        this.LevelEmple = LevelEmple;
    }
    
    public String getNivel(){
        switch (Integer.parseInt(String.valueOf(this.LevelEmple))) {
            case 1:
                return "Administrador";
            case 2:
                return "Usuario";
            case 3:
                return "Encargado de Área";
            default:
                return "Desconocido";
        }
    }

    public String getCodUbi() {
        return CodUbi;
    }

    public void setCodUbi(String CodUbi) {
        this.CodUbi = CodUbi;
    }

    public String getCodA() {
        return CodA;
    }

    public void setCodA(String CodA) {
        this.CodA = CodA;
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

    public String getNomA() {
        return NomA;
    }

    public void setNomA(String NomA) {
        this.NomA = NomA;
    }
    
    
}
