package com.farmacia.farmaciaweb.service;

import com.farmacia.farmaciaweb.domain.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> listarReservas();
    void guardarReserva(Reserva reserva);
    void eliminarReserva(Integer id);
    Reserva encontrarReserva(Integer id);
}
