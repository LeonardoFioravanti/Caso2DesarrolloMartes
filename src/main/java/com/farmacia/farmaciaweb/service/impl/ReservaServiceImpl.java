package com.farmacia.farmaciaweb.service;

import com.farmacia.farmaciaweb.dao.ReservaDao;
import com.farmacia.farmaciaweb.domain.Reserva;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public List<Reserva> listarReservas() {
        return reservaDao.findAll();
    }

    @Override
    public void guardarReserva(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public void eliminarReserva(Integer id) {
        reservaDao.deleteById(id);
    }

    @Override
    public Reserva encontrarReserva(Integer id) {
        return reservaDao.findById(id).orElse(null);
    }
}
