package com.Application;

import com.Usuario.Empresa;
import com.Usuario.Usuario;
import com.Application.CustomErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
public class ApplicationController {
    ModelAndView model = new ModelAndView();
    AgendaController agendaController = new AgendaController();
    InventarioController inventarioController = new InventarioController();
    TareasController tareasController = new TareasController();
    UsuarioController usuarioController = new UsuarioController();

    Empresa empresa = new Empresa("empresa.png", "Superlux S.A.", "A58456484", "934212797", "superlux@superlux.com",
            "Rambla Badal, 32, Barcelona, 08014", "ES0001822222110123456789");

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
            return usuarioController.registerPage();
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    @RequestMapping("/register")
    public ModelAndView registerModel(String ref, String username, String password, boolean admin) {
        if (this.log){
            usuarioController.register(ref, username, password, admin);
            return index();
        } else {
            return loginPageModel(Optional.of(true));
        }
    }

    // Inicio Agenda

    // Inicio Clientes

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientesModel() {
        if (this.usuario.isAdmin()){
            return agendaController.agendaClientes(this.usuario);
        } else {
            return index();
        }
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anyadirClienteModel(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.anyadirCliente(this.usuario, nombre, apellidos, id, telefono, correo, dir, premium);
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarClienteModel(String ref) {
        return agendaController.borrarCliente(this.usuario, ref);
    }

    @PostMapping("/editarCliente")
    public ModelAndView editarClienteModel(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.editarCliente(this.usuario, ref, nombre, apellidos, id, telefono, correo, dir, premium);
    }

        // Fin Clientes

        // Inicio Empleados

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleadosModel() {
        if (this.usuario.isAdmin()){
            return agendaController.agendaEmpleados(this.usuario);
        } else {
            return index();
        }
    }

    @PostMapping("/anyadirEmpleado")
    public ModelAndView anyadirEmpleadoModel(String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.anyadirEmpleado(this.usuario, nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    @PostMapping("/borrarEmpleado")
    public ModelAndView borrarEmpleadoModel(String ref) {
        return agendaController.borrarEmpleado(this.usuario, ref);
    }

    @PostMapping("/editarEmpleado")
    public ModelAndView editarEmpleadoModel(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.editarEmpleado(this.usuario, ref, nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadasModel() {
        if (this.usuario.isAdmin()){
            return agendaController.agendaEmpresasSubcontratadas(this.usuario);
        } else {
            return index();
        }
    }

    @PostMapping("/anyadirEmpresa")
    public ModelAndView anyadirEmpresaModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirEmpresa(this.usuario, nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarEmpresa")
    public ModelAndView borrarEmpresaModel(String ref) {
        return agendaController.borrarEmpresa(this.usuario, ref);
    }

    @PostMapping("/editarEmpresa")
    public ModelAndView editarEmpresaModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarEmpresa(this.usuario, ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Empresas Subcontratadas

    // Inicio Proveedores

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedoresModel() {
        if (this.usuario.isAdmin()){
            return agendaController.agendaProveedores(this.usuario);
        } else {
            return index();
        }
    }

    @PostMapping("/anyadirProveedor")
    public ModelAndView anyadirProveedorModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirProveedor(this.usuario, nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarProveedor")
    public ModelAndView borrarProveedorModel(String ref) {
        return agendaController.borrarProveedor(this.usuario, ref);
    }

    @PostMapping("/editarProveedor")
    public ModelAndView editarProveedorModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarProveedor(this.usuario, ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Proveedores

    // Fin Agenda

    @RequestMapping("/calendario")
    public ModelAndView calendario() {
        model.setViewName("calendario.html");
        model.addObject("usuario", this.usuario);
        return model;
    }

    @RequestMapping("/facturacion-albaranes")
    public ModelAndView facturacionAlbaranes() {
        model.setViewName("facturacion-albaranes.html");
        return model;
    }

    @RequestMapping("/facturacion-facturas")
    public ModelAndView facturacionFacturas() {
        model.setViewName("facturacion-facturas.html");
        return model;
    }

    @RequestMapping("/facturacion-gastos")
    public ModelAndView facturacionGastos() {
        model.setViewName("facturacion-gastos.html");
        return model;
    }

    @RequestMapping("/facturacion-nominas")
    public ModelAndView facturacionNominas() {
        model.setViewName("facturacion-nominas.html");
        return model;
    }

    @RequestMapping("/finanzas")
    public ModelAndView finanzas() {
        model.setViewName("finanzas.html");
        return model;
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
        return inventarioController.inventarioHerramientas(this.usuario);
    }

    @RequestMapping("/anyadirHerramienta")
    public ModelAndView anyadirHerramientaModel(String marca, String modelo, double precio, int cantidad) {
        return inventarioController.anyadirHerramienta(this.usuario, marca, modelo, precio, cantidad);
    }

    @RequestMapping("/borrarHerramienta")
    public ModelAndView borrarHerramientaModel(String ref) {
        return inventarioController.borrarHerramienta(this.usuario, ref);
    }

    @RequestMapping("/editarHerramienta")
    public ModelAndView editarHerramientaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        return inventarioController.editarHerramienta(this.usuario, ref, marca, modelo, precio, cantidad);
    }

    // Fin Herramientas

    // Inicio Máquinas

    @RequestMapping("/inventario-maquinas")
    public ModelAndView inventarioMaquinasModel() {
        return inventarioController.inventarioMaquinas(this.usuario);
    }

    @RequestMapping("/anyadirMaquina")
    public ModelAndView anyadirMaquinaModel(String marca, String modelo, double precio, int cantidad) {
        return inventarioController.anyadirMaquina(this.usuario, marca, modelo, precio, cantidad);
    }

    @RequestMapping("/borrarMaquina")
    public ModelAndView borrarMaquinaModel(String ref) {
        return inventarioController.borrarMaquina(this.usuario, ref);
    }

    @RequestMapping("/editarMaquina")
    public ModelAndView editarMaquinaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        return inventarioController.editarMaquina(this.usuario, ref, marca, modelo, precio, cantidad);
    }

    // Fin Máquinas

    // Inicio Materiales

    @RequestMapping("/inventario-materiales")
    public ModelAndView inventarioMaterialesModel() {
        return inventarioController.inventarioMateriales(this.usuario);
    }

    @RequestMapping("/anyadirMaterial")
    public ModelAndView anyadirMaterialModel(String marca, String modelo, double precio, int cantidad, int unidades) {
        return inventarioController.anyadirMaterial(this.usuario, marca, modelo, precio, cantidad, unidades);
    }

    @RequestMapping("/borrarMaterial")
    public ModelAndView borrarMaterialModel(String ref) {
        return inventarioController.borrarMaterial(this.usuario, ref);
    }

    @RequestMapping("/editarMaterial")
    public ModelAndView editarMaterialModel(String ref, String marca, String modelo, double precio, int cantidad, int unidades) {
        return inventarioController.editarMaterial(this.usuario, ref, marca, modelo, precio, cantidad, unidades);
    }

    // Fin Materiales

    // Inicio Productos
    @RequestMapping("/inventario-productos")
    public ModelAndView inventarioProductosModel() {
        return inventarioController.inventarioProductos(this.usuario);
    }

    @RequestMapping("/anyadirProducto")
    public ModelAndView anyadirProductoModel (String modelo, double precio, int stock, String urlFoto){
        return inventarioController.anyadirProducto(this.usuario, modelo, precio, stock, urlFoto);
    }

    @RequestMapping("/borrarProducto")
    public ModelAndView borrarProductoModel (String ref){
        return inventarioController.borrarProducto(this.usuario, ref);
    }

    @RequestMapping("/editarProducto")
    public ModelAndView editarProductoModel (String ref, String modelo, double precio, int stock, String urlFoto){
        return inventarioController.editarProducto(this.usuario, ref, modelo, precio, stock, urlFoto);
    }

    // Fin Productos

    // Inicio Vehículos

    @RequestMapping("/inventario-vehiculos")
    public ModelAndView inventarioVehiculosModel() {
        return inventarioController.inventarioVehiculos(this.usuario);
    }

    @RequestMapping("/anyadirVehiculo")
    public ModelAndView anyadirVehiculoModel(String marca, String modelo, String matricula, String color) {
        return inventarioController.anyadirVehiculo(this.usuario, marca, modelo, matricula, color);
    }

    @RequestMapping("/borrarVehiculo")
    public ModelAndView borrarVehiculoModel(String ref) {
        return inventarioController.borrarVehiculo(this.usuario, ref);
    }

    @RequestMapping("/editarVehiculo")
    public ModelAndView editarVehiculoModel(String ref, String marca, String modelo, String matricula, String color) {
        return inventarioController.editarVehiculo(this.usuario, ref, marca, modelo, matricula, color);
    }

    // Fin Vehículos

    // Inicio Tareas

    @RequestMapping("/tareas")
    public ModelAndView tareasModel() {
        return tareasController.tareas(this.usuario);
    }

    @RequestMapping("/anyadirTarea")
    public ModelAndView anyadirTareaModel (String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        return tareasController.anyadirTarea(this.usuario, cliente, empleados,fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);
    }

    @RequestMapping("/borrarTarea")
    public ModelAndView borrarTareaModel (String ref){
        return tareasController.borrarTarea(this.usuario, ref);
    }

    @RequestMapping("/editarTarea")
    public ModelAndView editarTareaModel (String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        return tareasController.editarTarea(this.usuario, ref, cliente, empleados, fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);
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
                                           String direccion, String antiguedad, String puesto){
        usuarioController.editarUsuario(this.usuario, nombre, apellidos, dni, telefono, email, direccion, antiguedad, puesto, imagen);
        agendaController.editarEmpleado(this.usuario, this.usuario.getEmpleado().getRef(), nombre, apellidos, this.usuario.getEmpleado().getUsuario(), dni, telefono, email, direccion, antiguedad, puesto);
        this.usuario = usuarioController.dameUsuario(this.usuario.getEmpleado().getUsuario(), this.usuario.getContrasenya());
        return usersProfileModel();
    }

    @RequestMapping("/editarContrasenya")
    public ModelAndView editarContrasenyaModel(String password, String newPassword, String renewPassword){
        if (!newPassword.equals(renewPassword)){
            return usersProfileModel();
        } else {
            usuarioController.editarContrasenya(this.usuario, password, newPassword);
            this.usuario = usuarioController.dameUsuario(this.usuario.getEmpleado().getUsuario(), this.usuario.getContrasenya());
            return usersProfileModel();
        }
    }

    @RequestMapping("/editarEmpresaPropia")
    public ModelAndView editarPropiaEmpresaModel(String logo, String nombre, String cif, String telefono, String email, String direccion, String iban){
        if (logo != null){
            this.empresa = new Empresa(logo, nombre, cif, telefono, email, direccion, iban);
        } else {
            this.empresa.editarEmpresa(nombre, cif, telefono, email, direccion, iban);
        }
        return usersProfileModel();
    }

    // Fin Perfil del Usuario
}
