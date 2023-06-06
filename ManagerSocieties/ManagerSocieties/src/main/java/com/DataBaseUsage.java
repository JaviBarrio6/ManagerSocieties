package com;

import com.Agenda.Cliente;
import com.Repositories.ClientesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DataBaseUsage {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostConstruct
    public void initDataBase () throws IOException {

        clientesRepository.save(new Cliente("Sofía", "García Rodríguez", "53852030Z", "674851283",
                "sofi@gmail.com", "C. Primavera 34, Ciudad Jardín, 12345", true,0));
        clientesRepository.save(new Cliente("Emiliano", "Pérez Martínez", "12345678A", "666987654",
                "emiliano@gmail.com", "Av. del Sol 56, Villa Esperanza, 67890", false,1));
        clientesRepository.save(new Cliente("Mireia", "Gaya González", "45678901C", "677894561",
                "mireia@gmail.com", "C. Mayor 12, Pueblo Nuevo, 45678", false,2));
        clientesRepository.save(new Cliente("Manuel", "Pujol Ramírez", "87654321D", "655432198",
                "manuel@gmail.com", "Pa. de la Luna 78, Villa Serena, 23456", true,3));
        clientesRepository.save(new Cliente("Alejandra", "Martín López", "98765432B", "644567890",
                "ale@gmail.com", "Av. de los Pinos 90, Ciudad del Mar, 78901", false,4));
        clientesRepository.save(new Cliente("Suelos", "S.L.", "B20846838", "612345678",
                "suelossl@gmail.com", "C. San Martín 45, El Pueblo Viejo, 56789", false,5));

    }
}
