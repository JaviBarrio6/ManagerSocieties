package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Clientes {
    public LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

    Cliente cliente01 = new Cliente("Juan José", "Rodríguez", "53852030Z", "674851283",
            "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true);
    Cliente cliente02 = new Cliente("Emiliano", "Pérez", "53852030Z", "674851283",
            "emiliano@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false);
    Cliente cliente03 = new Cliente("Mireia", "Gaya", "53852030Z", "674851283",
            "mireia@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false);
    Cliente cliente04 = new Cliente("Manuel", "Pujol", "53852030Z", "674851283",
            "manuel@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true);
    Cliente cliente05 = new Cliente("Alejandra", "Martín", "53852030Z", "674851283",
            "ale@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false);
    Cliente cliente06 = new Cliente("Suelos", "S.L.", "B20846838", "674851283",
            "suelossl@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false);

    public Clientes (){
        this.clientes.put(cliente01.getRef(), cliente01);
        this.clientes.put(cliente02.getRef(), cliente02);
        this.clientes.put(cliente03.getRef(), cliente03);
        this.clientes.put(cliente04.getRef(), cliente04);
        this.clientes.put(cliente05.getRef(), cliente05);
        this.clientes.put(cliente06.getRef(), cliente06);
    }

    public int[] getClientesEmpresas () {
        int[] empresas = {0, 0};
        for (Cliente c: this.clientes.values()) {
            if (c.esDni(c.getId())){
                empresas[0] += 1;
            } else {
                empresas[1] += 1;
            }
        }
        return empresas;
    }

    public void editarCliente (String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        this.clientes.put(ref, new Cliente(ref, nombre, apellidos, id, telefono, correo, dir, premium));
    }
}
