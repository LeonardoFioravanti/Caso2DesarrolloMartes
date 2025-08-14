package com.farmacia.farmaciaweb.dao;

import com.farmacia.farmaciaweb.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
}
