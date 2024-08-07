package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Docente;
import org.esfe.repositorios.IDocenteRepository;
import org.esfe.servicios.interfaces.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService implements IDocenteService {
    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public Page<Docente> buscarTodosPaginados(Pageable pageable) {
        return docenteRepository.findAll(pageable);
    }

    @Override
    public List<Docente> obtenerTodos() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> buscarPorId(Integer id) {
        return docenteRepository.findById(id);
    }

    @Override
    public Docente crearOEditar(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public void eliminarPorId(Integer id) {
        docenteRepository.deleteById(id);
    }
}
