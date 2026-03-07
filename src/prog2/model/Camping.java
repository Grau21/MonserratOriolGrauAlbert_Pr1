package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping {
    private String nom;
    private ArrayList<Allotjament>  allotjamentsList;
    private ArrayList<Client> clientsList;
    private LlistaReserves reserves;

    public Camping(String nom) {
        this.nom = nom;
        this.allotjamentsList = new ArrayList<>();
        this.clientsList = new ArrayList<>();
        this.reserves = new LlistaReserves();
    }

    // ----------------- //
    // Getters i Setters //
    // ----------------- //

    public String getNom() { return nom; }

    public LlistaReserves getLlistaReserves() { return reserves; }

    public ArrayList<Allotjament> getLlistaAllotjaments() { return allotjamentsList; }

    public ArrayList<Client> getLlistaClients() { return clientsList; }

    public int getNumAllotjaments() { return allotjamentsList.size(); }

    public int getNumReserves() { return reserves.getNumReserves(); }

    public int getNumClients() { return clientsList.size(); }

    // ---------------- //
    // Metodes d'afegir //
    // ---------------- //

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client c = new Client(nom_, dni_);
        clientsList.add(c);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        allotjamentsList.add(p);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow b = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones,
                                         placesParquing, terrassa, tv, aireFred);
        allotjamentsList.add(b);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi) {
        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones,
                                                 placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        allotjamentsList.add(bp);
    }


    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota) {
        Glamping g = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        allotjamentsList.add(g);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                         boolean terrassaBarbacoa) {
        MobilHome mh = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        allotjamentsList.add(mh);
    }
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament a = buscarAllotjament(id_);
        Client c = buscarClient(dni_);

        reserves.afegirReserva(a ,c , dataEntrada, dataSortida);
    }

    //int calculAllotjamentsOperatius();

    // ---------------- //
    // Mètodes de temps //
    // ---------------- //

    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {

        Iterator<Allotjament> it = allotjamentsList.iterator();

        // Comprovacio previa: Està buit l'arrayList?
        if (!it.hasNext()) {
            return null;
        }

        Allotjament millor = it.next();

        while (it.hasNext()) {
            Allotjament actual = it.next();

            if (actual.getEstadaMinima(temp) < millor.getEstadaMinima(temp)) {
                millor = actual;
            }
        }

        return millor;
    }


    public static InAllotjament.Temp getTemporada(LocalDate data){

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        if((mes > 3 && mes < 9) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20)){
            return InAllotjament.Temp.ALTA;
        }

        return InAllotjament.Temp.BAIXA;
    }

    // ----------------- //
    // Mètodes de suport //
    // ----------------- //

    private Allotjament buscarAllotjament(String id){

        Iterator<Allotjament> it = allotjamentsList.iterator();

        while(it.hasNext()){
            Allotjament a = it.next();

            if(a.getId().equals(id)){
                return a;
            }
        }

        return null;
    }

    private Client buscarClient(String dni){

        Iterator<Client> it = clientsList.iterator();

        while(it.hasNext()){
            Client c = it.next();

            if(c.getDni().equals(dni)){
                return c;
            }
        }

        return null;
    }
}
