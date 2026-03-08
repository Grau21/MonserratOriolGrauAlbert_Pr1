package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva implements InReserva {
    private Allotjament allotjament_;
    private Client client_;
    private LocalDate dateEntrada_;
    private LocalDate dataSortida_;

    public Reserva(Allotjament allotjament_, Client client_,
                   LocalDate dateEntrada_, LocalDate dataSortida_) throws ExcepcioReserva {
        this.allotjament_ = allotjament_;
        this.client_ = client_;
        this.dateEntrada_ = dateEntrada_;
        this.dataSortida_ = dataSortida_;

        if (dataSortida_.isBefore(dateEntrada_)) { // Excepció amb un throw.
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
    }
// Getters i Setters.
    public Allotjament getAllotjament_() { return allotjament_; }

    public Client getClient() { return client_; }

    public LocalDate getDataEntrada() { return dateEntrada_; }

    public LocalDate getDataSortida()  { return dataSortida_; }

    public void setAllotjament_(Allotjament allotjament_) {
        this.allotjament_ = allotjament_;
    }

    public void setClient(Client client_) {
        this.client_ = client_;
    }

    public void setDataEntrada(LocalDate dataEntrada_) {
        this.dateEntrada_ = dataEntrada_;
    }

    public void setDataSortida(LocalDate dataSortida_) {
        this.dataSortida_ = dataSortida_;
    }
// Que té allotjament
    @Override
    public String toString() {
        return "Allotjament=" + allotjament_ + ", client=" + client_ +
                ", Data d'entrada: " + dateEntrada_ +
                ", data de sortida: " + dataSortida_ + ".";
    }
}
