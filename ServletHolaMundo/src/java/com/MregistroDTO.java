package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marti
 */
public class MregistroDTO {
    private String nombre ="";
    private String appat ="";
    private String apmat ="";
    private int edad =0;
    private String correo ="";
    private int idUsu=0;
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the appat
     */
    public String getAppat() {
        return appat;
    }

    /**
     * @param appat the appat to set
     */
    public void setAppat(String appat) {
        this.appat = appat;
    }

    /**
     * @return the apmat
     */
    public String getApmat() {
        return apmat;
    }

    /**
     * @param apmat the apmat to set
     */
    public void setApmat(String apmat) {
        this.apmat = apmat;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the idUsu
     */
    public int getIdUsu() {
        return idUsu;
    }

    /**
     * @param idUsu the idUsu to set
     */
    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }
    
}
