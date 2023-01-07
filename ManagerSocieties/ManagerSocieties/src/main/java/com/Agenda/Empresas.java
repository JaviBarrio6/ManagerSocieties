package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Empresas {
    public LinkedHashMap <String, Empresa> empresas = new LinkedHashMap<>();

    Empresa empresa01 = new Empresa("BBVA", "SA", "A48265169", "900102801", "bbva@bbva.es", "GV. de Don Diego López de Haro, 12, Bilbao");
    Empresa empresa02 = new Empresa("SEUR", "SA", "G85804011", "927629063", "seur@seur.com", "C. Gamonal, 6, Madrid");
    Empresa empresa03 = new Empresa("BERMA", "SL", "B20846838", "900102801", "berma@gmail.eus", "C. Jose Artetxe, 19, Azpeitia");
    Empresa empresa04 = new Empresa("SEIN", "SL", "B20846838", "943157115", "admin@sein.es", "C. Garmendipe, 1, Azpeitia");

    public Empresas (){
        this.empresas.put(empresa01.getRef(), empresa01);
        this.empresas.put(empresa02.getRef(), empresa02);
        this.empresas.put(empresa03.getRef(), empresa03);
        this.empresas.put(empresa04.getRef(), empresa04);
    }

    public void editarEmpresa (String ref, String nombre, String tipo, String id, String telefono, String correo, String dir){
        this.empresas.put(ref, new Empresa(ref, nombre, tipo, id, telefono, correo, dir));
    }
}
