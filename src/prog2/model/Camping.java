package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament>  allotjamentsList;
    private ArrayList<Client> clientsList;


    public String getNom() { return nom; }

    //LlistaReserves getLlistaReserves();

    public ArrayList<Allotjament> getLlistaAllotjaments() { return allotjamentsList; }

    public ArrayList<Client> getLlistaClients() { return clientsList; }

    public int getNumAllotjaments() { return allotjamentsList.size(); }

    //int getNumReserves();

    public int getNumClients() { return clientsList.size(); }

    //void afegirClient(String nom_, String dni_);

    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        allotjamentsList.add(p);
    }

    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow b = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones,
                                         placesParquing, terrassa, tv, aireFred);
        allotjamentsList.add(b);
    }

    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi) {
        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones,
                                                 placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjamentsList.add(bp);
    }


    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota) {
        Glamping g = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjamentsList.add(g);
    }

    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                         boolean terrassaBarbacoa) {
        MobilHome mh = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjamentsList.add(mh);
    }

    //void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva;

    //int calculAllotjamentsOperatius();

    //Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp);

}
