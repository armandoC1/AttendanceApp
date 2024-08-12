package org.esfe.servicios.interfaces;

import org.esfe.modelos.Docente;
import org.esfe.modelos.DocenteGrupo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDocenteGrupoService {
    List<DocenteGrupo> obtenerTodos();

    Page<DocenteGrupo> buscarTodosPaginados(Pageable pageable);

    DocenteGrupo buscarPorId (Integer id);

    DocenteGrupo crearOEditar(DocenteGrupo docenteGrupo);

    void eliminarPorId(Integer id);
}
