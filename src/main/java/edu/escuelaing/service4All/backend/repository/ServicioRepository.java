package edu.escuelaing.service4All.backend.repository;

import edu.escuelaing.service4All.backend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository  extends JpaRepository<Servicio,Integer> {
}