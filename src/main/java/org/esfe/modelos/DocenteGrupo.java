package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "docentes_grupos")
public class DocenteGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;



    private int anio;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @NotBlank(message = "El ciclo de estudio es requerido")
    private String ciclo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    public @NotBlank(message = "El ciclo de estudio es requerido") String getCiclo() {
        return ciclo;
    }

    public void setCiclo(@NotBlank(message = "El ciclo de estudio es requerido") String ciclo) {
        this.ciclo = ciclo;
    }
}
