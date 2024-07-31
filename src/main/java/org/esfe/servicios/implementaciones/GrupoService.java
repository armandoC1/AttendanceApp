package org.esfe.servicios.implementaciones;

import org.esfe.modelos.Grupo;
import org.esfe.repositorios.IGrupoRepository;
import org.esfe.servicios.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService implements IGrupoService {

    @Autowired
    private IGrupoRepository grupoRepository;


    @Override
    public Page<Grupo> buscarTodosPaginados(Pageable pageable) {
        return grupoRepository.findAll(pageable);
    }

    @Override
    public List<Grupo> obtenerTodos() {
        return grupoRepository.findAll();
    }

    @Override
    public Optional<Grupo> buscarPorId(Integer id) {
        return grupoRepository.findById(id);
    }

    @Override
    public Grupo crearOEditra(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        grupoRepository.deleteById(id);
    }
}
