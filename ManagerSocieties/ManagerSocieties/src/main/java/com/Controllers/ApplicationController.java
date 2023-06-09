package com.Controllers;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Agenda.EmpresaSubcontratada.Entidad.EmpresaSub;
import com.Agenda.Proveedor.Entidad.Proveedor;
import com.Agenda.Cliente.Repository.ClientesRepository;
import com.Agenda.Empleado.Repository.EmpleadosRepository;
import com.Agenda.EmpresaSubcontratada.Repository.EmpresasRepository;
import com.Agenda.Proveedor.Repository.ProveedoresRepository;
import com.Calendario.Evento.Entidad.Evento;
import com.Calendario.Evento.Repository.EventosRepository;
import com.Inventario.Herramienta.Entidad.Herramienta;
import com.Inventario.Herramienta.Repository.HerramientasRepository;
import com.Inventario.Maquina.Entidad.Maquina;
import com.Inventario.Maquina.Repository.MaquinasRepository;
import com.Inventario.Material.Entidad.Material;
import com.Inventario.Material.Repository.MaterialesRepository;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Producto.Repository.ProductosRepository;
import com.Inventario.Vehiculo.Entidad.Vehiculo;
import com.Inventario.Vehiculo.Repository.VehiculoRepository;
import com.Repositories.*;
import com.Agenda.Service.AgendaService;
import com.Calendario.Service.CalendarioService;
import com.Inventario.Service.InventarioService;
import com.Tareas.Repository.TareasRepository;
import com.Tareas.Service.TareasService;
import com.Usuario.Service.UsuarioService;
import com.Tareas.Entidad.Tarea;
import com.Usuario.Entidad.Empresa;
import com.Usuario.Entidad.Usuario;
import com.Usuario.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class ApplicationController {

    // Variables
    ModelAndView model = new ModelAndView();

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Autowired
    private EventosRepository eventosRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private HerramientasRepository herramientasRepository;

    @Autowired
    private MaquinasRepository maquinasRepository;

    @Autowired
    private MaterialesRepository materialesRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private TareasRepository tareasRepository;

    AgendaService agendaService = new AgendaService();

    CalendarioService calendarioService = new CalendarioService();

    FacturacionController facturacionController = new FacturacionController();
    InventarioService inventarioService = new InventarioService();
    TareasService tareasService = new TareasService();
    UsuarioService usuarioService = new UsuarioService();

    boolean log = false;

    Usuario usuario = new Usuario();

    // Fin Variables

    // Inicio Login

    public boolean comprobarLog (Optional<Boolean> log){
        return log.orElse(true);
    }

    @RequestMapping("/")
    public ModelAndView loginPageModel(Optional<Boolean> credencialesCorrectas) {
        return usuarioService.loginPage(comprobarLog(credencialesCorrectas));
    }

    @RequestMapping("/login")
    public ModelAndView loginModel(String username, String password) {
        this.usuario = usuarioService.login(username, password, usuariosRepository.findAll());
        if (usuario != null){
           this.log = true;
           return index();
        } else {
           return loginPageModel(Optional.of(false));
        }
    }

    @RequestMapping("/cerrar-sesion")
    public ModelAndView cerrarSesion (){
        this.log = false;
        return loginPageModel(Optional.of(true));
    }

    @RequestMapping("/pages-register")
    public ModelAndView registerPagesModel() {
        if (this.log){
            return usuarioService.registerPage(empleadosRepository.findEmpleadosWithoutUser());
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/register")
    public ModelAndView registerModel(String ref, String username, String password, boolean admin) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Usuario usuarioAux = new Usuario(username, password, admin, "no-img.jpg", empleadosRepository.findEmpleadoByRef(ref));
                usuariosRepository.save(usuarioAux);
                empleadosRepository.findEmpleadoByRef(ref).setUsuario(usuarioAux);
                empleadosRepository.flush();
                return index();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Login

    // Inicio Agenda

        // Inicio Clientes

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientesModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return agendaService.agendaClientes(this.usuario, clientesRepository.findAll(), clientesRepository.countPeople());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anyadirClienteModel(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium, (clientesRepository.giveLastId() != null) ? clientesRepository.giveLastId(): 0);
                clientesRepository.save(cliente);
                return agendaClientesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarClienteModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                clientesRepository.delete(clientesRepository.findClienteByRef(ref));
                return agendaClientesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }


    @PostMapping("/editarCliente")
    public ModelAndView editarClienteModel(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Cliente cliente = clientesRepository.findClienteByRef(ref);
                Cliente clienteAux = new Cliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);
                cliente.setNombre(clienteAux.getNombre());
                cliente.setApellidos(clienteAux.getApellidos());
                cliente.setId(clienteAux.getId());
                cliente.setTelefono(clienteAux.getTelefono());
                cliente.setEmail(clienteAux.getEmail());
                cliente.setDireccion(clienteAux.getDireccion());
                cliente.setPremium(clienteAux.getPremium());
                clientesRepository.flush();

                return agendaClientesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Clientes

        // Inicio Empleados

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleadosModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return agendaService.agendaEmpleados(this.usuario, empleadosRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/anyadirEmpleado")
    public ModelAndView anyadirEmpleadoModel(String nombre, String apellidos, String usuario, String id, String telefono,
                                             String email, String direccion, String antiguedad, String numSS, String puesto) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Empleado empleado = new Empleado(nombre, apellidos, id, telefono, email, direccion, null, puesto, antiguedad, numSS, (empleadosRepository.giveLastId() != null) ? empleadosRepository.giveLastId(): 0);
                empleadosRepository.save(empleado);
                return agendaEmpleadosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/borrarEmpleado")
    public ModelAndView borrarEmpleadoModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                empleadosRepository.delete(empleadosRepository.findEmpleadoByRef(ref));
                return agendaEmpleadosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/editarEmpleado")
    public ModelAndView editarEmpleadoModel(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String numSS, String puesto) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Empleado empleado = empleadosRepository.findEmpleadoByRef(ref);
                Empleado empleadoAux = new Empleado(ref, nombre, apellidos, id, telefono, email, direccion, null, puesto, antiguedad, numSS);
                empleado.setNombre(empleadoAux.getNombre());
                empleado.setApellidos(empleadoAux.getApellidos());
                empleado.setId(empleadoAux.getId());
                empleado.setTelefono(empleadoAux.getTelefono());
                empleado.setEmail(empleadoAux.getEmail());
                empleado.setDireccion(empleadoAux.getDireccion());
                empleado.setPuesto(empleadoAux.getPuesto());
                empleado.setAntiguedad(empleadoAux.getAntiguedad());
                empleado.setNumSS(empleadoAux.getNumSS());
                empleadosRepository.flush();

                return agendaEmpleadosModel();

            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Empleados

        // Inicio Empresas Subcontratadas

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return agendaService.agendaEmpresasSubcontratadas(this.usuario, empresasRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/anyadirEmpresa")
    public ModelAndView anyadirEmpresaModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        if (this.log){
            if (this.usuario.isAdmin()){
                EmpresaSub empresa = new EmpresaSub(nombre, tipo, id, telefono, email, direccion, (empresasRepository.giveLastId() != null) ? empresasRepository.giveLastId(): 0);
                empresasRepository.save(empresa);
                return agendaEmpresasSubcontratadasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/borrarEmpresa")
    public ModelAndView borrarEmpresaModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                empresasRepository.delete(empresasRepository.findEmpresaByRef(ref));
                return agendaEmpresasSubcontratadasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/editarEmpresa")
    public ModelAndView editarEmpresaModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        if (this.log){
            if (this.usuario.isAdmin()){
                EmpresaSub empresa = empresasRepository.findEmpresaByRef(ref);
                EmpresaSub empresaAux = new EmpresaSub(ref, nombre, tipo, id, telefono, email, direccion);
                empresa.setNombre(empresaAux.getNombre());
                empresa.setTipo(empresaAux.getTipo());
                empresa.setId(empresaAux.getId());
                empresa.setTelefono(empresaAux.getTelefono());
                empresa.setEmail(empresaAux.getEmail());
                empresa.setDireccion(empresaAux.getDireccion());
                empresasRepository.flush();

                return agendaEmpresasSubcontratadasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Empresas Subcontratadas

        // Inicio Proveedores

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedoresModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return agendaService.agendaProveedores(this.usuario, proveedoresRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/anyadirProveedor")
    public ModelAndView anyadirProveedorModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Proveedor proveedor = new Proveedor(nombre, tipo, id, telefono, email, direccion, (proveedoresRepository.giveLastId() != null) ? proveedoresRepository.giveLastId(): 0);
                proveedoresRepository.save(proveedor);
                return agendaProveedoresModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/borrarProveedor")
    public ModelAndView borrarProveedorModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                proveedoresRepository.delete(proveedoresRepository.findProveedorByRef(ref));
                return agendaProveedoresModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @PostMapping("/editarProveedor")
    public ModelAndView editarProveedorModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Proveedor proveedor = proveedoresRepository.findProveedorByRef(ref);
                Proveedor proveedorAux = new Proveedor(ref, nombre, tipo, id, telefono, email, direccion);
                proveedor.setNombre(proveedorAux.getNombre());
                proveedor.setTipo(proveedorAux.getTipo());
                proveedor.setId(proveedorAux.getId());
                proveedor.setTelefono(proveedorAux.getTelefono());
                proveedor.setEmail(proveedorAux.getEmail());
                proveedor.setDireccion(proveedorAux.getDireccion());
                proveedoresRepository.flush();

                return agendaProveedoresModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Proveedores

    // Fin Agenda

    // Inicio Calendario

    @RequestMapping("/calendario")
    public ModelAndView calendarioModel() {
        if (this.log){
            return calendarioService.renderCalendar(this.usuario, eventosRepository.findAll());
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/sigMes")
    public ModelAndView sigMesModel (String fecha){
        if (this.log){
            String[] fechaAux = fecha.split(" ");
            int mes = Integer.parseInt(fechaAux[0]);
            int anyo = Integer.parseInt(fechaAux[1]);
            return calendarioService.renderCalendar(this.usuario, mes + 1, anyo, eventosRepository.findAll());
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/antMes")
    public ModelAndView antMesModel (String fecha){
        if (this.log){
            String[] fechaAux = fecha.split(" ");
            int mes = Integer.parseInt(fechaAux[0]);
            int anyo = Integer.parseInt(fechaAux[1]);
            return calendarioService.renderCalendar(this.usuario, mes - 1, anyo, eventosRepository.findAll());
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/anyadirEvento")
    public ModelAndView anyadirEventoModel (String tareaAsociada, String titulo, String fechaInicio, String fechaFin, String horaInicio, String horaFin){
        if (this.log){
            Evento evento = new Evento(tareaAsociada, titulo, fechaInicio, fechaFin, horaInicio, horaFin, (eventosRepository.giveLastId() != null) ? eventosRepository.giveLastId(): 0);
            eventosRepository.save(evento);
            return calendarioModel();
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/borrarEvento")
    public ModelAndView borrarEventoModel (String ref){
        if (this.log){
            eventosRepository.delete(eventosRepository.findEventoByRef(ref));
            return calendarioModel();
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Calendario

    // Inicio Facturación

        // Inicio Albaranes

    @RequestMapping("/facturacion-albaranes")
    public ModelAndView facturacionAlbaranesModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.facturacionAlbaranes(this.usuario);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirAlbaran")
    public ModelAndView anyadirAlbaranModel (String ref, String fecha, String[] productos, int[] cantidades, String[] tareas, double iva) {

        Cliente clienteAux = clientesRepository.findClienteByRef(ref);
        List<Producto> productosAux = productosRepository.findAll();
        List<Tarea> tareasAux = tareasRepository.findAll();
        HashMap<Producto, Integer> productosAuxAux = new HashMap<>();
        for (int i = 0; i < productosAux.size(); i++){
            productosAuxAux.put(productosAux.get(i), cantidades[i]);
        }

        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.anyadirAlbaran(this.usuario, clienteAux, fecha, productosAuxAux, tareasAux, iva);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarAlbaran")
    public ModelAndView borrarAlbaranModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.borrarAlbaran(this.usuario, ref);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Albaranes

        // Inicio Facturas

    @RequestMapping("/facturacion-facturas")
    public ModelAndView facturacionFacturas() {
        if (this.log){
            if (this.usuario.isAdmin()){
                model.setViewName("facturacion-facturas.html");
                return model;
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Facturas

        // Inicio Gastos

    @RequestMapping("/facturacion-gastos")
    public ModelAndView facturacionGastosModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.facturacionGastos(this.usuario, empleadosRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirGasto")
    public ModelAndView anyadirGastoModel (String empleado, String motivo, String fecha, double gasto) {

        Empleado empleadoAux = empleadosRepository.findEmpleadoByRef(empleado);

        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.anyadirGasto(this.usuario, empleadoAux, motivo, fecha, gasto);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarGasto")
    public ModelAndView borrarGastoModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.borrarGasto(this.usuario, ref);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Gastos

        // Inicio Nóminas

    @RequestMapping("/facturacion-nominas")
    public ModelAndView facturacionNominasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.facturacionNominas(this.usuario, empleadosRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirNomina")
    public ModelAndView anyadirNominaModel(String empleado, String fecha, int dias, double salarioConvenio, double prestacionAccidente,
                                           double complementoSalarial, double teletrabajo, double productividad, double pagasExtra,
                                           double contingencias, double formacionP, double desempleo) {

        Empleado empleadoAux = empleadosRepository.findEmpleadoByRef(empleado);

        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.anyadirNomina(this.usuario, empleadoAux, fecha, dias, salarioConvenio, prestacionAccidente, complementoSalarial,
                        teletrabajo, productividad, pagasExtra, contingencias, formacionP, desempleo);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarNomina")
    public ModelAndView borrarNominaModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                return facturacionController.borrarNomina(this.usuario, ref);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Nóminas

    // Fin Facturación

    // Inicio Finanzas

    @RequestMapping("/finanzas")
    public ModelAndView finanzas() {
        if (this.log){
            if (this.usuario.isAdmin()){
                model.setViewName("finanzas.html");
                return model;
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Finanzas

    // Inicio Dashboard

    @RequestMapping("/index")
    public ModelAndView index() {
        if (this.log){
            model.setViewName("index.html");
            model.addObject("usuario", this.usuario);
            return model;
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Dashboard

    // Inicio Inventario

        // Inicio Herramientas

    @RequestMapping("/inventario-herramientas")
    public ModelAndView inventarioHerramientasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioService.inventarioHerramientas(this.usuario, herramientasRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirHerramienta")
    public ModelAndView anyadirHerramientaModel(String marca, String modelo, double precio, int cantidad) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Herramienta herramienta = new Herramienta(marca, modelo, precio, cantidad, (herramientasRepository.giveLastId() != null) ? herramientasRepository.giveLastId(): 0);
                herramientasRepository.save(herramienta);
                return inventarioHerramientasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarHerramienta")
    public ModelAndView borrarHerramientaModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                herramientasRepository.delete(herramientasRepository.findHerramientaByRef(ref));
                return inventarioHerramientasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/editarHerramienta")
    public ModelAndView editarHerramientaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Herramienta herramienta = herramientasRepository.findHerramientaByRef(ref);
                Herramienta herramientaAux = new Herramienta(ref, marca, modelo, precio, cantidad);
                herramienta.setMarca(herramientaAux.getMarca());
                herramienta.setModelo(herramientaAux.getModelo());
                herramienta.setPrecio(herramientaAux.getPrecio());
                herramienta.setCantidad(herramientaAux.getCantidad());
                herramientasRepository.flush();

                return inventarioHerramientasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Herramientas

        // Inicio Máquinas

    @RequestMapping("/inventario-maquinas")
    public ModelAndView inventarioMaquinasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioService.inventarioMaquinas(this.usuario, maquinasRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirMaquina")
    public ModelAndView anyadirMaquinaModel(String marca, String modelo, double precio, int cantidad) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Maquina maquina = new Maquina(marca, modelo, precio, cantidad, (maquinasRepository.giveLastId() != null) ? maquinasRepository.giveLastId(): 0);
                maquinasRepository.save(maquina);
                return inventarioMaquinasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarMaquina")
    public ModelAndView borrarMaquinaModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                maquinasRepository.delete(maquinasRepository.findMaquinaByRef(ref));
                return inventarioMaquinasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/editarMaquina")
    public ModelAndView editarMaquinaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Maquina maquina = maquinasRepository.findMaquinaByRef(ref);
                Maquina maquinaAux = new Maquina(ref, marca, modelo, precio, cantidad);
                maquina.setMarca(maquinaAux.getMarca());
                maquina.setModelo(maquinaAux.getModelo());
                maquina.setPrecio(maquinaAux.getPrecio());
                maquina.setCantidad(maquina.getCantidad());
                maquinasRepository.flush();

                return inventarioMaquinasModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Máquinas

        // Inicio Materiales

    @RequestMapping("/inventario-materiales")
    public ModelAndView inventarioMaterialesModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioService.inventarioMateriales(this.usuario, materialesRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirMaterial")
    public ModelAndView anyadirMaterialModel(String marca, String modelo, double precio, int cantidad, int unidades) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Material material = new Material(marca, modelo, precio, cantidad, unidades, (materialesRepository.giveLastId() != null) ? materialesRepository.giveLastId(): 0);
                materialesRepository.save(material);
                return inventarioMaterialesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarMaterial")
    public ModelAndView borrarMaterialModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                materialesRepository.delete(materialesRepository.findMaterialByRef(ref));
                return inventarioMaterialesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/editarMaterial")
    public ModelAndView editarMaterialModel(String ref, String marca, String modelo, double precio, int cantidad, int unidades) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Material material = materialesRepository.findMaterialByRef(ref);
                Material materialAux = new Material(ref, modelo, modelo, precio, cantidad, unidades);
                material.setMarca(materialAux.getMarca());
                material.setModelo(materialAux.getModelo());
                material.setPrecio(material.getPrecio());
                material.setCantidad(material.getCantidad());
                material.setUnidades(material.getUnidades());
                materialesRepository.flush();
                return inventarioMaterialesModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Materiales

        // Inicio Productos

    @RequestMapping("/inventario-productos")
    public ModelAndView inventarioProductosModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioService.inventarioProductos(this.usuario, productosRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirProducto")
    public ModelAndView anyadirProductoModel (String modelo, double precio, int stock, String urlFoto){
        if (this.log){
            if (this.usuario.isAdmin()){
                Producto producto = new Producto(modelo, precio, stock, urlFoto, (productosRepository.giveLastId() != null) ? productosRepository.giveLastId(): 0);
                productosRepository.save(producto);
                return inventarioProductosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarProducto")
    public ModelAndView borrarProductoModel (String ref){
        if (this.log){
            if (this.usuario.isAdmin()){
                productosRepository.delete(productosRepository.findProductoByRef(ref));
                return inventarioProductosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/editarProducto")
    public ModelAndView editarProductoModel (String ref, String modelo, double precio, int stock, String urlFoto){
        if (this.log){
            if (this.usuario.isAdmin()){
                Producto producto = productosRepository.findProductoByRef(ref);
                Producto productoAux = new Producto(ref, modelo, precio, stock, urlFoto);
                producto.setModelo(productoAux.getModelo());
                producto.setPrecio(productoAux.getPrecio());
                producto.setStock(productoAux.getStock());
                producto.setUrlFoto(producto.getUrlFoto());
                productosRepository.flush();
                return inventarioProductosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Productos

        // Inicio Vehículos

    @RequestMapping("/inventario-vehiculos")
    public ModelAndView inventarioVehiculosModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioService.inventarioVehiculos(this.usuario, vehiculoRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirVehiculo")
    public ModelAndView anyadirVehiculoModel(String marca, String modelo, String matricula, String color) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, color, (vehiculoRepository.giveLastId() != null) ? vehiculoRepository.giveLastId(): 0);
                vehiculoRepository.save(vehiculo);
                return inventarioVehiculosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/borrarVehiculo")
    public ModelAndView borrarVehiculoModel(String ref) {
        if (this.log){
            if (this.usuario.isAdmin()){
                vehiculoRepository.delete(vehiculoRepository.findVehiculoByRef(ref));
                return inventarioVehiculosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/editarVehiculo")
    public ModelAndView editarVehiculoModel(String ref, String marca, String modelo, String matricula, String color) {
        if (this.log){
            if (this.usuario.isAdmin()){
                Vehiculo vehiculo = vehiculoRepository.findVehiculoByRef(ref);
                Vehiculo vehiculoAux = new Vehiculo(ref, marca, modelo, matricula, color);
                vehiculo.setMarca(vehiculoAux.getMarca());
                vehiculo.setModelo(vehiculoAux.getModelo());
                vehiculo.setMatricula(vehiculoAux.getMatricula());
                vehiculo.setColor(vehiculoAux.getColor());
                vehiculoRepository.flush();
                return inventarioVehiculosModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

        // Fin Vehículos

    // Fin Inventario

    // Inicio Tareas

    @RequestMapping("/tareas")
    public ModelAndView tareasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return tareasService.tareas(this.usuario, tareasRepository.findAll(), clientesRepository.findAll(),
                        empleadosRepository.findAll(), herramientasRepository.findAll(), maquinasRepository.findAll(),
                        materialesRepository.findAll(), productosRepository.findAll(), vehiculoRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/anyadirTarea")
    public ModelAndView anyadirTareaModel (String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double precio, double gastoExtra, String info, int estado, String[] inventario){
        Cliente clienteAux = clientesRepository.findClienteByRef(cliente);
        List<Empleado> empleadosAux = new ArrayList<>();
        List<Herramienta> herramientas = new ArrayList<>();
        List<Maquina> maquinas = new ArrayList<>();
        List<Material> materiales = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Vehiculo> vehiculos = new ArrayList<>();
        String ref;
        Empleado empleado = null;
        for (String s : empleados) {
            empleado = empleadosRepository.findEmpleadoByRef(s);
            empleadosAux.add(empleado);
        }
        if (inventario != null){
            for (String s: inventario) {
                ref = s.substring(0, 3);
                if (ref != null) {
                    switch (ref) {
                        case "HER":
                            Herramienta herramienta = herramientasRepository.findHerramientaByRef(s);
                            herramientas.add(herramienta);
                            break;
                        case "MAQ":
                            Maquina maquina = maquinasRepository.findMaquinaByRef(s);
                            maquinas.add(maquina);
                            break;
                        case "MAT":
                            Material material = materialesRepository.findMaterialByRef(s);
                            materiales.add(material);
                            break;
                        case "PRO":
                            Producto producto = productosRepository.findProductoByRef(s);
                            productos.add(producto);
                            break;
                        case "VEH":
                            Vehiculo vehiculo = vehiculoRepository.findVehiculoByRef(s);
                            vehiculos.add(vehiculo);
                            break;
                    }
                }
            }
        }

        Tarea tarea = new Tarea(clienteAux, empleadosAux, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado,
                herramientas, maquinas, materiales, productos, vehiculos, (tareasRepository.giveLastId() != null) ? tareasRepository.giveLastId(): 0);
        Evento evento = new Evento (tarea.getRef(), "Tarea - ".concat(clienteAux.getNombre()), fechaInicio, "-",
                hora, "-", (eventosRepository.giveLastId() != null) ? eventosRepository.giveLastId(): 0);
        tareasRepository.save(tarea);
        eventosRepository.save(evento);
        facturacionController.anyadirGasto(this.usuario, empleado, tarea.getRef(), fechaInicio, gastoExtra);
        return tareasModel();

    }

    @RequestMapping("/borrarTarea")
    public ModelAndView borrarTareaModel (String ref){
        tareasRepository.delete(tareasRepository.findTareaByRef(ref));
        eventosRepository.delete(eventosRepository.findEventoByRefTarea(ref));
        return tareasModel();
    }

    @RequestMapping("/editarTarea")
    public ModelAndView editarTareaModel (String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double precio, double gastoExtra, String info, int estado, String[] inventario){
        Tarea tarea = tareasRepository.findTareaByRef(ref);

        Cliente clienteAux = clientesRepository.findClienteByRef(cliente);
        List<Empleado> empleadosAux = new ArrayList<>();
        List<Herramienta> herramientas = new ArrayList<>();
        List<Maquina> maquinas = new ArrayList<>();
        List<Material> materiales = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Vehiculo> vehiculos = new ArrayList<>();
        String refAux;
        Empleado empleado = null;
        for (String s : empleados) {
            empleado = empleadosRepository.findEmpleadoByRef(s);
            empleadosAux.add(empleado);
        }
        if (inventario != null){
            for (String s: inventario) {
                refAux = s.substring(0, 3);
                if (refAux != null) {
                    switch (refAux) {
                        case "HER":
                            Herramienta herramienta = herramientasRepository.findHerramientaByRef(s);
                            herramientas.add(herramienta);
                            break;
                        case "MAQ":
                            Maquina maquina = maquinasRepository.findMaquinaByRef(s);
                            maquinas.add(maquina);
                            break;
                        case "MAT":
                            Material material = materialesRepository.findMaterialByRef(s);
                            materiales.add(material);
                            break;
                        case "PRO":
                            Producto producto = productosRepository.findProductoByRef(s);
                            productos.add(producto);
                            break;
                        case "VEH":
                            Vehiculo vehiculo = vehiculoRepository.findVehiculoByRef(s);
                            vehiculos.add(vehiculo);
                            break;
                    }
                }
            }
        }

        Tarea tareaAux = new Tarea(ref, clienteAux, empleadosAux, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado, herramientas, maquinas, materiales, productos, vehiculos);
        tarea.setCliente(tareaAux.getCliente());
        tarea.setEmpleados(tareaAux.getEmpleados());
        tarea.setFechaInicio(tareaAux.getFechaInicio());
        tarea.setFechaFin(tareaAux.getFechaFin());
        tarea.setHora(tareaAux.getHora());
        tarea.setPrecio(tareaAux.getPrecio());
        tarea.setGastoExtra(tareaAux.getGastoExtra());
        tarea.setInfo(tareaAux.getInfo());
        tarea.setEstado(tareaAux.getEstado());
        tarea.setHerramientas(tareaAux.getHerramientas());
        tarea.setMaquinas(tareaAux.getMaquinas());
        tarea.setMateriales(tareaAux.getMateriales());
        tarea.setProductos(tareaAux.getProductos());
        tarea.setVehiculos(tareaAux.getVehiculos());
        tareasRepository.flush();

        Evento evento = eventosRepository.findEventoByRefTarea(tarea.getRef());
        Evento eventoAux = new Evento (tarea.getRef(), "Tarea - ".concat(clienteAux.getNombre()), fechaInicio, "-",
                hora, "-", (eventosRepository.giveLastId() != null) ? eventosRepository.giveLastId(): 0);
        evento.setTitulo(eventoAux.getTitulo());
        evento.setFechaInicio(eventoAux.getFechaInicio());
        evento.setFechaFin(eventoAux.getFechaFin());
        evento.setHoraInicio(eventoAux.getHoraInicio());
        eventosRepository.flush();

        return tareasModel();
    }

    // Fin Tareas

    // Inicio Perfil del Usuario
        @RequestMapping("/users-profile")
    public ModelAndView usersProfileModel() {
        model.setViewName("users-profile.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", empresaRepository.getEmpresa());
        return model;
    }

    @RequestMapping("/edit-users-profile")
    public ModelAndView editUsersProfileModel() {
        model.setViewName("edit-users-profile.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", empresaRepository.getEmpresa());
        return model;
    }

    @RequestMapping("/edit-users-password")
    public ModelAndView editUsersPasswordModel() {
        model.setViewName("edit-users-password.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", empresaRepository.getEmpresa());
        return model;
    }

    @RequestMapping("/edit-users-enterprise")
    public ModelAndView editUsersEnterpriseModel() {
        model.setViewName("edit-users-enterprise.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", empresaRepository.getEmpresa());
        return model;
    }

    @RequestMapping("/editarUsuario")
    public ModelAndView editarUsuarioModel(String imagen, String nombre, String apellidos, String dni, String telefono, String email,
                                           String direccion, String antiguedad, String numSS, String puesto){

        Empleado empleado = empleadosRepository.findEmpleadoByRef(usuario.getEmpleado().getRef());

        empleado.setNombre(nombre);
        empleado.setApellidos(apellidos);
        empleado.setId(dni);
        empleado.setTelefono(telefono);
        empleado.setEmail(email);
        empleado.setDireccion(direccion);
        empleado.setAntiguedad(antiguedad);
        empleado.setNumSS(numSS);
        empleado.setPuesto(puesto);

        usuario.getEmpleado().setNombre(nombre);
        usuario.getEmpleado().setApellidos(apellidos);
        usuario.getEmpleado().setId(dni);
        usuario.getEmpleado().setTelefono(telefono);
        usuario.getEmpleado().setEmail(email);
        usuario.getEmpleado().setDireccion(direccion);
        usuario.getEmpleado().setAntiguedad(antiguedad);
        usuario.getEmpleado().setNumSS(numSS);
        usuario.getEmpleado().setPuesto(puesto);
        usuario.setImagenUrl(imagen);
        empleadosRepository.flush();
        usuariosRepository.flush();

        return usersProfileModel();
    }

    @RequestMapping("/editarContrasenya")
    public ModelAndView editarContrasenyaModel(String password, String newPassword, String renewPassword){
        if (!newPassword.equals(renewPassword)){
            return usersProfileModel();
        } else {
            usuario.setContrasenya(password);
            usuariosRepository.flush();
            return usersProfileModel();
        }
    }

    @RequestMapping("/editarEmpresaPropia")
    public ModelAndView editarPropiaEmpresaModel(String logo, String nombre, String cif, String telefono, String email, String direccion, String iban, String numSS){
        if (this.log){
            if (this.usuario.isAdmin()){
                if (logo != null){
                    Empresa empresa = empresaRepository.getEmpresa();
                    empresa.setLogo(logo);
                    empresa.setNombre(nombre);
                    empresa.setCif(cif);
                    empresa.setTelefono(telefono);
                    empresa.setEmail(email);
                    empresa.setDireccion(direccion);
                    empresa.setIban(iban);
                    empresa.setNumSS(numSS);
                    empresaRepository.flush();
                } else {
                    Empresa empresa = empresaRepository.getEmpresa();
                    empresa.setNombre(nombre);
                    empresa.setCif(cif);
                    empresa.setTelefono(telefono);
                    empresa.setEmail(email);
                    empresa.setDireccion(direccion);
                    empresa.setIban(iban);
                    empresa.setNumSS(numSS);
                    empresaRepository.flush();
                }
                return usersProfileModel();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Perfil del Usuario
}
