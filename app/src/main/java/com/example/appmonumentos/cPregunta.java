package com.example.appmonumentos;

public class cPregunta {
    private String imagen;
    private String nombre;
    private String correcta;
    private String opcio1;
    private String opcio2;
    private String opcio3;
    private String opcio4;
    private Boolean mostrada;

    public cPregunta(String sImagen,String sNombre, String sCorrecta, String sOpcio1, String sOpcio2, String sOpcio3, String sOpcio4, Boolean sMostrada) {
        imagen = sImagen;
        nombre = sNombre;
        correcta = sCorrecta;
        opcio1 = sOpcio1;
        opcio2 = sOpcio2;
        opcio3 = sOpcio3;
        opcio4 = sOpcio4;
        mostrada = sMostrada;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getOpcio1() {
        return opcio1;
    }

    public void setOpcio1(String opcio1) {
        this.opcio1 = opcio1;
    }

    public String getOpcio3() {
        return opcio3;
    }

    public void setOpcio3(String opcio3) {
        this.opcio3 = opcio3;
    }

    public String getOpcio2() {
        return opcio2;
    }

    public void setOpcio2(String opcio2) {
        this.opcio2 = opcio2;
    }

    public String getOpcio4() {
        return opcio4;
    }

    public void setOpcio4(String opcio4) {
        this.opcio4 = opcio4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getMostrada() {
        return mostrada;
    }

    public void setMostrada(Boolean mostrada) {
        this.mostrada = mostrada;
    }
}
