package com;

import com.Agenda.Cliente;
import com.Agenda.Empleado;
import com.Agenda.EmpresaSub;
import com.Agenda.Proveedor;
import com.Repositories.ClientesRepository;
import com.Repositories.EmpleadosRepository;
import com.Repositories.EmpresasRepository;
import com.Repositories.ProveedoresRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class DataBaseUsage {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @PostConstruct
    public void initDataBase () throws IOException {
        //Inicio de Agenda

            // Inicio Clientes
        clientesRepository.save(new Cliente("Sofía", "García Rodríguez", "53852030Z", "674851283",
                "sofi@gmail.com", "C. Primavera 34, Ciudad Jardín, 12345", true,0));
        clientesRepository.save(new Cliente("Emiliano", "Pérez Martínez", "12345678Z", "666987654",
                "emiliano@gmail.com", "Av. del Sol 56, Villa Esperanza, 67890", false,1));
        clientesRepository.save(new Cliente("Mireia", "Gaya González", "45678901G", "677894561",
                "mireia@gmail.com", "C. Mayor 12, Pueblo Nuevo, 45678", false,2));
        clientesRepository.save(new Cliente("Manuel", "Pujol Ramírez", "87654321X", "655432198",
                "manuel@gmail.com", "Pa. de la Luna 78, Villa Serena, 23456", true,3));
        clientesRepository.save(new Cliente("Alejandra", "Martín López", "98765432M", "644567890",
                "ale@gmail.com", "Av. de los Pinos 90, Ciudad del Mar, 78901", false,4));
        clientesRepository.save(new Cliente("Suelos", "S.L.", "B20846838", "612345678",
                "suelossl@gmail.com", "C. San Martín 45, El Pueblo Viejo, 56789", false,5));
            // Fin Clientes
            // Inicio Empleados
        empleadosRepository.save(new Empleado("Juan", "García López", "47564785A", "623456789",
                "juan.garcia@example.com", "C. Principal 123, Barcelona", null, "Analista de datos", "01/01/2020", "12345678901234567", 0));
        empleadosRepository.save(new Empleado("María", "Rodríguez Fernández", "87654321X", "687654321",
                "maria.rodriguez@example.com", "Av. Central 456, Barcelona", null, "Gerente de Ventas", "01/01/2018", "98765432109876543", 1));
        empleadosRepository.save(new Empleado("Pedro", "Martínez Sánchez", "56789012B", "654321987",
                "pedro.martinez@example.com", "C. Secundaria 783, Barcelona", null, "Desarrollador Software", "01/01/2021", "56789012345678901", 2));
        empleadosRepository.save(new Empleado("Laura", "López García", "34567890V", "789654321",
                "laura.lopez@example.com", "Av. Principal 123, Barcelona", null, "Diseñadora Gráfica", "01/01/2022", "34567890123456789", 3));
        empleadosRepository.save(new Empleado("Andrés", "Fernández Pérez", "90123456A", "621654987",
                "andres.fernandez@example.com", "C. Central 123, Barcelona", null, "RRHH", "01/01/2019", "90123456789012345", 4));
            // Fin Empleados
            // Inicio Empresas Subcontratadas
        empresasRepository.save(new EmpresaSub("BBVA", "SA", "A48265169", "900102801", "bbva@bbva.es", "GV. de Don Diego López de Haro, 12, Bilbao", 0));
        empresasRepository.save(new EmpresaSub("SEUR", "SA", "G85804011", "927629063", "seur@seur.com", "C. Gamonal, 6, Madrid", 1));
        empresasRepository.save(new EmpresaSub("BERMA", "SL", "B20846838", "900102801", "berma@gmail.eus", "C. Jose Artetxe, 19, Azpeitia", 2));
        empresasRepository.save(new EmpresaSub("SEIN", "SL", "B20846838", "943157115", "admin@sein.es", "C. Garmendipe, 1, Azpeitia", 3));
            // Fin Empresas Subcontratadas
            // Inicio Proveedores
        proveedoresRepository.save(new Proveedor("FreeMate", "SL", "B64560428", "933602222", "Freemate@freemate.com", "C. Castillejos, 316, Barcelona", 0));
        proveedoresRepository.save(new Proveedor("KP Limpieza", "SL", "B27311763", "699837191", "kplimpieza@kplimpieza.es", "C. Horizonte, 7, Sevilla", 1));
            // Fin Proveedores
    }
}
