package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;

    public MobilHome(String nom, String id, String mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa) {
        super(nom, id, mida, habitacions, placesPersones); // Heretem de casa amb el super.
        this.terrassaBarbacoa = terrassaBarbacoa;
    }

    public boolean isTerrassaBarbacoa() { return terrassaBarbacoa; }
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa) { this.terrassaBarbacoa = terrassaBarbacoa; }
// Correcte Funcionament.
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa;
    }
// Que té MobilHome.
    @Override
    public String toString() {
        return super.toString() + " MobilHome{terrassaBarbacoa=" + terrassaBarbacoa + "}";
    }
}
