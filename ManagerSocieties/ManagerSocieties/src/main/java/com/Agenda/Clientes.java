package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Clientes {
    public ArrayList<Cliente> clientes = new ArrayList<>();

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
    Cliente cliente06 = new Cliente("Suelos", "S.L.", "B7584256H", "674851283",
            "suelossl@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false);

    public Clientes (){
        this.clientes.add(cliente01);
        this.clientes.add(cliente02);
        this.clientes.add(cliente03);
        this.clientes.add(cliente04);
        this.clientes.add(cliente05);
        this.clientes.add(cliente06);
    }

    public int[] getClientesEmpresas () {
        int[] empresas = {0, 0};
        for (Cliente c: this.clientes) {
            if (c.esDni(c.getId())){
                empresas[0] += 1;
            } else {
                empresas[1] += 1;
            }
        }
        return empresas;
    }

    public Cliente findByRef (String ref) {
        for (Cliente cliente: this.clientes){
            if (cliente.getRef().equals(ref)){
                return cliente;
            }
        }
        return null;
    }

    public void editarCliente (String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        int pos = 0;
        for (Cliente cliente: this.clientes){
            if (cliente.getRef().equals(ref)){
                this.clientes.get(pos).editarCliente(nombre, apellidos, id, telefono, correo, dir, premium);
            } else {
                pos += 1;
            }
        }
    }
}
