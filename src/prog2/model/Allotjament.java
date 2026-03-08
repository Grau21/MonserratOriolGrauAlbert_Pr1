package prog2.model;

public abstract class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    // Hem fet aquests dos atributs estàtics perquè té més sentit que
    // siguin compartits per a tots els objectes de tipus Allotjaments
    private static long estadaMinimaALTA_;
    private static long estadaMinimaBAIXA_;

    public Allotjament(String nom, String id, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.nom = nom;
        this.id = id;
        Allotjament.estadaMinimaALTA_ = estadaMinimaALTA_;
        Allotjament.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    /*  Aquest constructor no usa estadaMinimaALTA_ ni estadaMinimaBAIXA_
        perquè són "static" i llavors no fa falta canviar-les sempre. */
    public Allotjament(String nom, String id) {
        this.nom = nom;
        this.id = id;
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
        switch (temp) {
            case ALTA: return Allotjament.estadaMinimaALTA_;
            case BAIXA: return Allotjament.estadaMinimaBAIXA_;
            // default: throw new IllegalArgumentException("Temp no vàlid");
        }
    // Error, no s'hauria d'arribar mai a aquesta linia de codi
    return -1;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        Allotjament.estadaMinimaALTA_ = estadaMinimaALTA_;
        Allotjament.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    @Override
    public abstract boolean correcteFuncionament();

    @Override
    public String toString() {
        return "Nom=" + nom + ", Id=" + id + 
               ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
               ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
