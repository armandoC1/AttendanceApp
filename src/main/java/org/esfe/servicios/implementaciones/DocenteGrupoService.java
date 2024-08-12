package org.esfe.servicios.implementaciones;

import org.esfe.modelos.DocenteGrupo;
import org.esfe.repositorios.IDocenteGrupoRepository;
import org.esfe.repositorios.IDocenteRepository;
import org.esfe.servicios.interfaces.IDocenteGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteGrupoService implements IDocenteGrupoService {
    @Autowired
    private IDocenteGrupoRepository docenteGrupoRepository;
    @Override
    public List<DocenteGrupo> obtenerTodos() {
        return docenteGrupoRepository.findAll();
    }

    @Override
    public Page<DocenteGrupo> buscarTodosPaginados(Pageable pageable) {
        return docenteGrupoRepository.findByOrderByDocenteDesc(pageable);
    }

    @Override
    public DocenteGrupo buscarPorId(Integer id) {
        return docenteGrupoRepository.findById(id).get();
    }

    @Override
    public DocenteGrupo crearOEditar(DocenteGrupo docenteGrupo) {
        return docenteGrupoRepository.save(docenteGrupo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        docenteGrupoRepository.deleteById(id);
    }
}
