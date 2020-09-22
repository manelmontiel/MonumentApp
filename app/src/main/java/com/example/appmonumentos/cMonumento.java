package com.example.appmonumentos;

public class cMonumento {
    private String imagen;
    private String nombre;
    private String continente;
    private String pais;
    private String ciudad;
    private String url;
    private String ubicacion;
    private String informacion;
    /*private String informacion;
     */

    public cMonumento(String sImagen, String sNombre, String sContinente, String sPais, String sCiudad, String sUrl, String sUbicacion, String sInformacion) {
        imagen = sImagen;
        nombre = sNombre;
        continente = sContinente;
        pais = sPais;
        ciudad = sCiudad;
        url = sUrl;
        ubicacion = sUbicacion;
        informacion = sInformacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
