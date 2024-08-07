package org.esfe.repositorios;

import org.esfe.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
}
