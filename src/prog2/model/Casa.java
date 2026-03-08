package prog2.model;

public abstract class Casa extends Allotjament {
    private String mida;
    private int habitacions;
    private int placesPersones;

    public Casa(String nom, String id, String mida,
                int habitacions, int placesPersones) {
        super(nom, id); // Heretem d'allotjament amb el super.
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }
// Getters i Setters.
    public String getMida() { return mida; }
    public void setMida(String mida) { this.mida = mida; }
    public int getHabitacions() { return habitacions; }
    public void setHabitacions(int habitacions) { this.habitacions = habitacions; }
    public int getPlacesPersones() { return placesPersones; }
    public void setPlacesPersones(int placesPersones) { this.placesPersones = placesPersones; }
// Que té casa.
    @Override
    public String toString() {
        return super.toString() + " Casa{mida=" + mida + ", habitacions=" + habitacions +
               ", placesPersones=" + placesPersones + "}";
    }
}
