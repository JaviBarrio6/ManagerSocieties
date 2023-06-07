package com.Controllers;

import com.Agenda.Cliente;
import com.Agenda.Empleado;
import com.Agenda.EmpresaSub;
import com.Agenda.Proveedor;
import com.Inventario.Producto;
import com.Repositories.ClientesRepository;
import com.Repositories.EmpleadosRepository;
import com.Repositories.EmpresasRepository;
import com.Repositories.ProveedoresRepository;
import com.Services.AgendaService;
import com.Tareas.Tarea;
import com.Usuario.Empresa;
import com.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class ApplicationController {
    ModelAndView model = new ModelAndView();

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private EmpresasRepository empresasRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    AgendaService agendaService = new AgendaService();

    CalendarioController calendarioController = new CalendarioController();

    FacturacionController facturacionController = new FacturacionController();
    InventarioController inventarioController = new InventarioController();
    TareasController tareasController = new TareasController();
    UsuarioController usuarioController = new UsuarioController();

    Empresa empresa = new Empresa("empresa.png", "Superlux S.A.", "A58456484", "934212797", "superlux@superlux.com",
            "Rambla Badal, 32, Barcelona, 08014", "ES0001822222110123456789", "28/17754764/41");

    Usuario usuario = new Usuario();

    boolean log = false;

    // Inicio Login

    public boolean comprobarLog (Optional<Boolean> log){
        return log.orElse(true);
    }

    @RequestMapping("/")
    public ModelAndView loginPageModel(Optional<Boolean> credencialesCorrectas) {
        return usuarioController.loginPage(comprobarLog(credencialesCorrectas));
    }

    @RequestMapping("/login")
    public ModelAndView loginModel(String username, String password) {
       if (usuarioController.login(username, password)){
           this.log = true;
           this.usuario = usuarioController.dameUsuario(username, password);
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
            return usuarioController.registerPage(empleadosRepository.findAll());
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/register")
    public ModelAndView registerModel(String ref, String username, String password, boolean admin) {
        if (this.log){
            if (this.usuario.isAdmin()){
                usuarioController.register(empleadosRepository.findEmpleadoByRef(ref), username, password, admin);
                return index();
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

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
                Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium, clientesRepository.giveLastId());
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
                Cliente cliente = new Cliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);
                return agendaService.editarCliente(this.usuario, clientesRepository.findClienteByRef(ref), cliente, clientesRepository.findAll(), clientesRepository.countPeople());
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
                Empleado empleado = new Empleado(nombre, apellidos, id, telefono, email, direccion, null, puesto, antiguedad, numSS, empleadosRepository.giveLastId());
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
                Empleado empleado = new Empleado(ref, nombre, apellidos, id, telefono, email, direccion, null, puesto, antiguedad, numSS);
                return agendaService.editarEmpleado(this.usuario, empleadosRepository.findEmpleadoByRef(ref), empleado, empleadosRepository.findAll());

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
                EmpresaSub empresa = new EmpresaSub(nombre, tipo, id, telefono, email, direccion, empresasRepository.giveLastId());
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
                EmpresaSub empresaSub = new EmpresaSub(ref, nombre, tipo, id, telefono, email, direccion);
                return agendaService.editarEmpresa(this.usuario, empresasRepository.findEmpresaByRef(ref), empresaSub, empresasRepository.findAll());
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
                Proveedor proveedor = new Proveedor(nombre, tipo, id, telefono, email, direccion, proveedoresRepository.giveLastId());
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
                Proveedor proveedor = new Proveedor(ref, nombre, tipo, id, telefono, email, direccion);
                return agendaService.editarProveedor(this.usuario, proveedoresRepository.findProveedorByRef(ref), proveedor, proveedoresRepository.findAll());
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Proveedores

    // Fin Agenda

    @RequestMapping("/calendario")
    public ModelAndView calendarioModel() {
        if (this.log){
            return calendarioController.renderCalendar(this.usuario);
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
            return calendarioController.renderCalendar(this.usuario, mes + 1, anyo);
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
            return calendarioController.renderCalendar(this.usuario, mes - 1, anyo);
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/anyadirEvento")
    public ModelAndView anyadirEventoModel (String tareaAsociada, String titulo, String fechaInicio, String fechaFin, String horaInicio, String horaFin){
        if (this.log){
            return calendarioController.anyadirEvento (this.usuario, tareaAsociada, titulo, fechaInicio, fechaFin, horaInicio, horaFin);
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping ("/borrarEvento")
    public ModelAndView borrarEventoModel (String ref){
        if (this.log){
            return calendarioController.borrarEvento (this.usuario, ref);
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Inicio Facturación

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
        ArrayList<Producto> productosAux = inventarioController.dameProductos(productos);
        ArrayList<Tarea> tareasAux = tareasController.dameTareas(tareas);
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

    // Inicio Inventario

    // Inicio Herramientas

    @RequestMapping("/inventario-herramientas")
    public ModelAndView inventarioHerramientasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return inventarioController.inventarioHerramientas(this.usuario);
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
                return inventarioController.anyadirHerramienta(this.usuario, marca, modelo, precio, cantidad);
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
                return inventarioController.borrarHerramienta(this.usuario, ref);
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
                return inventarioController.editarHerramienta(this.usuario, ref, marca, modelo, precio, cantidad);
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
                return inventarioController.inventarioMaquinas(this.usuario);
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
                return inventarioController.anyadirMaquina(this.usuario, marca, modelo, precio, cantidad);
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
                return inventarioController.borrarMaquina(this.usuario, ref);
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
                return inventarioController.editarMaquina(this.usuario, ref, marca, modelo, precio, cantidad);
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
                return inventarioController.inventarioMateriales(this.usuario);
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
                return inventarioController.anyadirMaterial(this.usuario, marca, modelo, precio, cantidad, unidades);
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
                return inventarioController.borrarMaterial(this.usuario, ref);
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
                return inventarioController.editarMaterial(this.usuario, ref, marca, modelo, precio, cantidad, unidades);
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
                return inventarioController.inventarioProductos(this.usuario);
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
                return inventarioController.anyadirProducto(this.usuario, modelo, precio, stock, urlFoto);
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
                return inventarioController.borrarProducto(this.usuario, ref);
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
                return inventarioController.editarProducto(this.usuario, ref, modelo, precio, stock, urlFoto);
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
                return inventarioController.inventarioVehiculos(this.usuario);
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
                return inventarioController.anyadirVehiculo(this.usuario, marca, modelo, matricula, color);
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
                return inventarioController.borrarVehiculo(this.usuario, ref);
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
                return inventarioController.editarVehiculo(this.usuario, ref, marca, modelo, matricula, color);
            } else {
                return index();
            }
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Fin Vehículos

    // Inicio Tareas

    @RequestMapping("/tareas")
    public ModelAndView tareasModel() {
        if (this.log){
            if (this.usuario.isAdmin()){
                return tareasController.tareas(this.usuario);
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
        Empleado empleado = empleadosRepository.findEmpleadoByRef(empleados[0]);
        String[] nombresEmpleado = new String[empleados.length];
        for (int i = 0; i < empleados.length; i++){
            nombresEmpleado[i] = empleadosRepository.findEmpleadoByRef(empleados[i]).getNombre() + ' ' + empleadosRepository.findEmpleadoByRef(empleados[i]).getApellidos();
        }
        Tarea tarea = new Tarea(clienteAux, nombresEmpleado, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado, inventario);
        calendarioController.anyadirEvento(this.usuario, tarea.getRef(), "Tarea - ".concat(clienteAux.getNombre()), fechaFin, "¿?",
                hora, hora);
        facturacionController.anyadirGasto(this.usuario, empleado, tarea.getRef(), fechaInicio, gastoExtra);
        return tareasController.anyadirTarea(this.usuario, tarea);

    }

    @RequestMapping("/borrarTarea")
    public ModelAndView borrarTareaModel (String ref){
        return tareasController.borrarTarea(this.usuario, ref);
    }

    @RequestMapping("/editarTarea")
    public ModelAndView editarTareaModel (String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double precio, double gastoExtra, String info, int estado, String[] inventario){
        return tareasController.editarTarea(this.usuario, ref, cliente, empleados, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado, inventario);
    }

    // Fin Tareas

    // Inicio Perfil del Usuario
        @RequestMapping("/users-profile")
    public ModelAndView usersProfileModel() {
        model.setViewName("users-profile.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", this.empresa);
        return model;
    }

    @RequestMapping("/edit-users-profile")
    public ModelAndView editUsersProfileModel() {
        model.setViewName("edit-users-profile.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", this.empresa);
        return model;
    }

    @RequestMapping("/edit-users-password")
    public ModelAndView editUsersPasswordModel() {
        model.setViewName("edit-users-password.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", this.empresa);
        return model;
    }

    @RequestMapping("/edit-users-enterprise")
    public ModelAndView editUsersEnterpriseModel() {
        model.setViewName("edit-users-enterprise.html");
        model.addObject("usuario", this.usuario);
        model.addObject("empresa", this.empresa);
        return model;
    }

    @RequestMapping("/editarUsuario")
    public ModelAndView editarUsuarioModel(String imagen, String nombre, String apellidos, String dni, String telefono, String email,
                                           String direccion, String antiguedad, String numSS, String puesto){
        usuarioController.editarUsuario(this.usuario, nombre, apellidos, dni, telefono, email, direccion, antiguedad, puesto, imagen);
        return usersProfileModel();
    }

    @RequestMapping("/editarContrasenya")
    public ModelAndView editarContrasenyaModel(String password, String newPassword, String renewPassword){
        if (!newPassword.equals(renewPassword)){
            return usersProfileModel();
        } else {
            usuarioController.editarContrasenya(this.usuario, password, newPassword);
            this.usuario = usuarioController.dameUsuario("", this.usuario.getContrasenya());
            return usersProfileModel();
        }
    }

    @RequestMapping("/editarEmpresaPropia")
    public ModelAndView editarPropiaEmpresaModel(String logo, String nombre, String cif, String telefono, String email, String direccion, String iban, String numSS){
        if (this.log){
            if (this.usuario.isAdmin()){
                if (logo != null){
                    this.empresa = new Empresa(logo, nombre, cif, telefono, email, direccion, iban, numSS);
                } else {
                    this.empresa.editarEmpresa(nombre, cif, telefono, email, direccion, iban);
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
