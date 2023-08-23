package com.learn_with_me.models;


import java.time.LocalDate;

public class Persona {
    private String idPersona;
    private String nombreCompleto;
    private String apellidoCompleto;
    private String DNI;
    private String mail;
    private LocalDate fechaNacimiento;

    public Persona() {
    }

    public Persona(String idPersona, String nombreCompleto, String apellidoCompleto, String DNI, String mail, LocalDate fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
        this.apellidoCompleto = apellidoCompleto;
        this.DNI = DNI;
        this.mail = mail;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApellidoCompleto() {
        return apellidoCompleto;
    }

    public void setApellidoCompleto(String apellidoCompleto) {
        this.apellidoCompleto = apellidoCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
