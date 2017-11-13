package modelo;

public class DocumentosM {

    private String TipoDocs, Tupa;
    private int CodDocs, DiaDocs;
    private float CostDocs;

    public int getCodDocs() {
        return CodDocs;
    }

    public void setCodDocs(int CodDocs) {
        this.CodDocs = CodDocs;
    }

    public String getTipoDocs() {
        return TipoDocs;
    }

    public void setTipoDocs(String TipoDocs) {
        this.TipoDocs = TipoDocs;
    }

    public int getDiaDocs() {
        return DiaDocs;
    }

    public void setDiaDocs(int DiaDocs) {
        this.DiaDocs = DiaDocs;
    }

    public float getCostDocs() {
        return CostDocs;
    }

    public void setCostDocs(float CostDocs) {
        this.CostDocs = CostDocs;
    }

    public String getTupa() {
        return Tupa;
    }

    public void setTupa(String Tupa) {
        this.Tupa = Tupa;
    }

}
