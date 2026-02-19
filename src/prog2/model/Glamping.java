package prog2.model;

public class Glamping extends Casa {
    private String material;
    private boolean casaMascota;

    public Glamping(String nom, String id, String mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota) {
        super(nom, id, 3, 3, mida, habitacions, placesPersones);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public boolean isCasaMascota() { return casaMascota; }
    public void setCasaMascota(boolean casaMascota) { this.casaMascota = casaMascota; }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        return super.toString() + " Glamping{material=" + material +
               ", casaMascota=" + casaMascota + "}";
    }
}
