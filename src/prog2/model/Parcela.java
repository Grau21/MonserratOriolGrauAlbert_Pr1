package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String id, float mida, boolean connexioElectrica) {
        super(nom, id, 4, 2); // Heretem d'allotjament amb el super.
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }
// Getters i Setters.
    public float getMida() { return mida; }
    public void setMida(float mida) { this.mida = mida; }
    public boolean isConnexioElectrica() { return connexioElectrica; }
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }
// Correcte Funcionament.
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }
// Que té Parcela.
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}
