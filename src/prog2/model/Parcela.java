package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    public Parcela(String nom, String id, float mida, boolean connexioElectrica) {
        super(nom, id, 4, 2);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida() { return mida; }
    public void setMida(float mida) { this.mida = mida; }
    public boolean isConnexioElectrica() { return connexioElectrica; }
    public void setConnexioElectrica(boolean connexioElectrica) { this.connexioElectrica = connexioElectrica; }

    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}
