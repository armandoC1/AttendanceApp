package org.esfe.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  // Importa esta anotación desde jakarta.persistence
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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


