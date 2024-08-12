package org.esfe.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El texto no corresponde a un email valido")
    private String email;

    @NotBlank(message = "El telefono es requerido")
    private String telefono;

    @NotBlank(message = "El nombre de la escuela es requerido")
    private String escuela;

    //Propiedad que vincula grupos con Docente
    @ManyToMany
    @JoinTable(
        name = "docentes_grupos",
        joinColumns = @JoinColumn(name = "docente_id"),
        inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private Set<Grupo> grupos = new HashSet<>();

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es requerido") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El apellido es requerido") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido es requerido") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El email es requerido") @Email(message = "El texto no corresponde a un email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es requerido") @Email(message = "El texto no corresponde a un email valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "El telefono es requerido") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El telefono es requerido") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "El nombre de la escuela es requerido") String getEscuela() {
        return escuela;
    }

    public void setEscuela(@NotBlank(message = "El nombre de la escuela es requerido") String escuela) {
        this.escuela = escuela;
    }
}


