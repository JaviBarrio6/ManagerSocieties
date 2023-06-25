package com.Inventario.Producto.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refProducto = "PRO";

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ref")
    private String ref;
    @Column(name = "stock")
    private int stock;
    @Column(name = "precio")
    private double precio;
    @Column(name = "url_Foto")
    private String urlFoto;

    // Fin Variables

    // Inicio Constructores
    public Producto() {
        setModelo("");
        setRef("");
        setStock(0);
        setPrecio(0);
        setUrlFoto("");
    }

    public Producto(String modelo, double precio, int stock, String urlFoto, int pos) {
        setModelo(modelo);
        setPrecio(precio);
        setStock(stock);
        setUrlFoto(urlFoto);

        setRef(generadorRef(++pos, refProducto));
    }

    public Producto(String ref, String modelo, double precio, int stock, String urlFoto) {
        setModelo(modelo);
        setPrecio(precio);
        setStock(stock);
        setUrlFoto(urlFoto);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters
    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setUrlFoto(String urlFoto) {
        if ((urlFoto == null) || (urlFoto.equals(""))){
            this.urlFoto = "/img/no-img.jpg";
        } else {
            String cadena = urlFoto.substring(0, 5);
            if (!cadena.equals("/img/")){
                this.urlFoto = "/img/" + urlFoto;
            } else {
                this.urlFoto = urlFoto;
            }
        }

    }

    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getUrlFoto() {
        return this.urlFoto;
    }

    public int getStock() {
        return this.stock;
    }

    // Fin Getters

    // Inicio Funciones
    public String generadorRef(int num, String ref) {
        int digitos = (int) (Math.log10(num) + 1);
        String refAux = "";
        for (int i = 0; i < (4 - digitos); i++) {
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }
    // Fin Funciones
}

