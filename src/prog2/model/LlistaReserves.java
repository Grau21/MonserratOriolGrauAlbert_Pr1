package prog2.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import prog2.vista.ExcepcioReserva;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva> reserves;

    public LlistaReserves() {
        reserves = new ArrayList<>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // Comprovar disponibilitat
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            String missatge = "L'allotjament amb identificador " + allotjament.getId() +
                    " no està disponible en la data demanada " + dataEntrada.toString() +
                    " pel client " + client.getNom() + " amb DNI: " + client.getDni() + ".";
            throw new ExcepcioReserva(missatge);
        }

        // Comprovar estada mínima
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            String missatge = "Les dates sol·licitades pel client " + client.getNom() +
                    " amb DNI: " + client.getDni() +
                    " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId() + ".";
            throw new ExcepcioReserva(missatge);
        }

        // Crear i afegir reserva
        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        reserves.add(reserva);
    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate entrada, LocalDate sortida) {
        for (Reserva r : reserves) {
            if (r.getAllotjament_().equals(allotjament)) {
                // Comprovar solapament: (entrada < r.getDataSortida() && sortida > r.getDataEntrada())
                if (entrada.isBefore(r.getDataSortida()) && sortida.isAfter(r.getDataEntrada())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEstadaMinima(Allotjament allotjament, LocalDate entrada, LocalDate sortida) {
        long dies = ChronoUnit.DAYS.between(entrada, sortida);
        InAllotjament.Temp temporada = getTemporada(entrada);
        long estadaMin = allotjament.getEstadaMinima(temporada);
        return dies >= estadaMin;
    }

    private InAllotjament.Temp getTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        if (mes >= 6 && mes <= 9) {
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }
}