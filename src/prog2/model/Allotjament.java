package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;

    public Allotjament(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    /*  Aquest constructor no usa estadaMinimaALTA_ ni estadaMinimaBAIXA_. */
    public Allotjament(String nom, String id) {
        this.nom = nom;
        this.id = id;
    }
// Getters i Setters.
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
        switch (temp) {
            case ALTA: return this.estadaMinimaALTA_;
            case BAIXA: return this.estadaMinimaBAIXA_;
            // default: throw new IllegalArgumentException("Temp no vàlid");
        }
    // Error, no s'hauria d'arribar mai a aquesta linia de codi
    return -1;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }
// Correcte Funcionament
    @Override
    public abstract boolean correcteFuncionament();
// Estada Minima Alta i Baixa.
    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + 
               ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
               ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
