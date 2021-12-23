package com.example.listviewvolley;

public class ElementosLista {
    public String nombres;
    public String identificador;
    public String area;
    public String JPG;
    public String jpg;

    public ElementosLista(String nombres, String identificador, String area, String JPG, String jpg) {
        this.nombres = nombres;
        this.identificador = identificador;
        this.area = area;
        this.JPG = JPG;
        this.jpg = jpg;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getJPG() {
        return JPG;
    }

    public void setJPG(String JPG) {
        this.JPG = JPG;
    }

    public String getJpg() {
        return jpg;
    }

    public void setJpg(String jpg) {
        this.jpg = jpg;
    }
}
