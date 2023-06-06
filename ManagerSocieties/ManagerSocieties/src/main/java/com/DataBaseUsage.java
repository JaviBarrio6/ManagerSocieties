package com;

import com.Agenda.Cliente;
import com.Repositories.ClientesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseUsage {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostConstruct
    public void initDateBase () {

        clientesRepository.save(new Cliente("CLI0001","Juan José", "Rodríguez", "53852030Z", "674851283",
                "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true));
        clientesRepository.save(new Cliente("CLI0002","Emiliano", "Pérez", "53852030Z", "674851283",
                "emiliano@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false));
        clientesRepository.save(new Cliente("CLI0003","Mireia", "Gaya", "53852030Z", "674851283",
                "mireia@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false));
        clientesRepository.save(new Cliente("CLI0004","Manuel", "Pujol", "53852030Z", "674851283",
                "manuel@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true));
        clientesRepository.save(new Cliente("CLI0005","Alejandra", "Martín", "53852030Z", "674851283",
                "ale@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false));
        clientesRepository.save(new Cliente("CLI0006","Suelos", "S.L.", "B20846838", "674851283",
                "suelossl@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", false));

    }
}
