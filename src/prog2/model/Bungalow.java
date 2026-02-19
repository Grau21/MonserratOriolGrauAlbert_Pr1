package prog2.model;

public class Bungalow extends Casa {
    private int placesParquing;
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

    public Bungalow(String nom, String id, String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean televisio, boolean aireFred) {
        super(nom, id, 4, 7, mida, habitacions, placesPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aireFred = aireFred;
    }

    public int getPlacesParquing() { return placesParquing; }
    public void setPlacesParquing(int placesParquing) { this.placesParquing = placesParquing; }
    public boolean isTerrassa() { return terrassa; }
    public void setTerrassa(boolean terrassa) { this.terrassa = terrassa; }
    public boolean isTelevisio() { return televisio; }
    public void setTelevisio(boolean televisio) { this.televisio = televisio; }
    public boolean isAireFred() { return aireFred; }
    public void setAireFred(boolean aireFred) { this.aireFred = aireFred; }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    @Override
    public String toString() {
        return super.toString() + " Bungalow{placesParquing=" + placesParquing +
               ", terrassa=" + terrassa + ", televisio=" + televisio + ", aireFred=" + aireFred + "}";
    }
}
