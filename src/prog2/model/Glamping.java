package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String id, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, id, mida, habitacions, placesPersones); // Heretem de casa amb el super.
        this.material = material;
        this.casaMascota = casaMascota;
    }
// Getters i Setters.
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public boolean isCasaMascota() { return casaMascota; }
    public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }
// Correcte Funcionament.
    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }
// Que té Glamping.
    @Override
    public String toString() {
        return super.toString() + " Glamping{material=" + material +
               ", casaMascota=" + casaMascota + "}";
    }
}
