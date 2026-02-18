package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private float estadaMinimaTemporadaAlta;
    private float estadaMinimaTemporadaBaixa;

    public Allotjament(String nom, String id, float estadaMinimaTemporadaAlta, float estadaMinimaTemporadaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaTemporadaAlta = estadaMinimaTemporadaAlta;
        this.estadaMinimaTemporadaBaixa = estadaMinimaTemporadaBaixa;
    }

    @Override
    public String getNom() { return nom; }

    @Override
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public long getEstadaMinima(Temp temp) {
        return temp == Temp.ALTA ? estadaMinimaTemporadaAlta : estadaMinimaTemporadaBaixa;
    }

    @Override
    public void setEstadaMinima(float estadaMinimaTemporadaAlta, float estadaMinimaTemporadaBaixa) {
        this.estadaMinimaTemporadaAlta = estadaMinimaTemporadaAlta;
        this.estadaMinimaTemporadaBaixa = estadaMinimaTemporadaBaixa;
    }

    @Override
    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + 
               ", estada mínima en temporada alta: " + estadaMinimaTemporadaAlta + 
               ", estada mínima en temporada baixa: " + estadaMinimaTemporadaBaixa + ".";
    }
}
