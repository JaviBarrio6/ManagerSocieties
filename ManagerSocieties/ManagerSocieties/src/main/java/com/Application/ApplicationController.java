package com.Application;

import com.Agenda.Cliente;
import com.Agenda.Empleados;
import com.Inventario.Objeto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class ApplicationController {
    ModelAndView model = new ModelAndView();
    AgendaController agendaController = new AgendaController();
    InventarioController inventarioController = new InventarioController();

    TareasController tareasController = new TareasController();
    @RequestMapping("/")
    public ModelAndView login() {
        model.setViewName("pages-login.html");
        return model;
    }

    // Inicio Agenda

        // Inicio Clientes

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientesModel() {
        return agendaController.agendaClientes();
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anyadirClienteModel(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.anyadirCliente(nombre, apellidos, id, telefono, correo, dir, premium);
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarClienteModel(String ref) {
        return agendaController.borrarCliente(ref);
    }

    @PostMapping("/editarCliente")
    public ModelAndView editarClienteModel(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);
    }

        // Fin Clientes

        // Inicio Empleados

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleadosModel() {
        return agendaController.agendaEmpleados();
    }

    @PostMapping("/anyadirEmpleado")
    public ModelAndView anyadirEmpleadoModel(String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.anyadirEmpleado(nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    @PostMapping("/borrarEmpleado")
    public ModelAndView borrarEmpleadoModel(String ref) {
        return agendaController.borrarEmpleado(ref);
    }

    @PostMapping("/editarEmpleado")
    public ModelAndView editarEmpleadoModel(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.editarEmpleado(ref, nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadasModel() {
        return agendaController.agendaEmpresasSubcontratadas();
    }

    @PostMapping("/anyadirEmpresa")
    public ModelAndView anyadirEmpresaModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirEmpresa(nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarEmpresa")
    public ModelAndView borrarEmpresaModel(String ref) {
        return agendaController.borrarEmpresa(ref);
    }

    @PostMapping("/editarEmpresa")
    public ModelAndView editarEmpresaModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarEmpresa(ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Empresas Subcontratadas

    // Inicio Proveedores

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedoresModel() {
        return agendaController.agendaProveedores();
    }

    @PostMapping("/anyadirProveedor")
    public ModelAndView anyadirProveedorModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirProveedor(nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarProveedor")
    public ModelAndView borrarProveedorModel(String ref) {
        return agendaController.borrarProveedor(ref);
    }

    @PostMapping("/editarProveedor")
    public ModelAndView editarProveedorModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarProveedor(ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Proveedores

    // Fin Agenda

    @RequestMapping("/calendario")
    public ModelAndView calendario() {
        model.setViewName("calendario.html");
        return model;
    }

    @RequestMapping("/edit-users-profile")
    public ModelAndView editUsersProfile() {
        model.setViewName("edit-users-profile.html");
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
        model.setViewName("index.html");
        return model;
    }

    // Inicio Inventario

    // Inicio Herramientas

    @RequestMapping("/inventario-herramientas")
    public ModelAndView inventarioHerramientasModel() {
        return inventarioController.inventarioHerramientas();
    }

    @RequestMapping("/anyadirHerramienta")
    public ModelAndView anyadirHerramientaModel(String marca, String modelo, double precio, int cantidad) {
        return inventarioController.anyadirHerramienta(marca, modelo, precio, cantidad);
    }

    @RequestMapping("/borrarHerramienta")
    public ModelAndView borrarHerramientaModel(String ref) {
        return inventarioController.borrarHerramienta(ref);
    }

    @RequestMapping("/editarHerramienta")
    public ModelAndView editarHerramientaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        return inventarioController.editarHerramienta(ref, marca, modelo, precio, cantidad);
    }

    // Fin Herramientas

    // Inicio Máquinas

    @RequestMapping("/inventario-maquinas")
    public ModelAndView inventarioMaquinasModel() {
        return inventarioController.inventarioMaquinas();
    }

    @RequestMapping("/anyadirMaquina")
    public ModelAndView anyadirMaquinaModel(String marca, String modelo, double precio, int cantidad) {
        return inventarioController.anyadirMaquina(marca, modelo, precio, cantidad);
    }

    @RequestMapping("/borrarMaquina")
    public ModelAndView borrarMaquinaModel(String ref) {
        return inventarioController.borrarMaquina(ref);
    }

    @RequestMapping("/editarMaquina")
    public ModelAndView editarMaquinaModel(String ref, String marca, String modelo, double precio, int cantidad) {
        return inventarioController.editarMaquina(ref, marca, modelo, precio, cantidad);
    }

    // Fin Máquinas

    // Inicio Materiales

    @RequestMapping("/inventario-materiales")
    public ModelAndView inventarioMaterialesModel() {
        return inventarioController.inventarioMateriales();
    }

    @RequestMapping("/anyadirMaterial")
    public ModelAndView anyadirMaterialModel(String marca, String modelo, double precio, int cantidad, int unidades) {
        return inventarioController.anyadirMaterial(marca, modelo, precio, cantidad, unidades);
    }

    @RequestMapping("/borrarMaterial")
    public ModelAndView borrarMaterialModel(String ref) {
        return inventarioController.borrarMaterial(ref);
    }

    @RequestMapping("/editarMaterial")
    public ModelAndView editarMaterialModel(String ref, String marca, String modelo, double precio, int cantidad, int unidades) {
        return inventarioController.editarMaterial(ref, marca, modelo, precio, cantidad, unidades);
    }

    // Fin Materiales

    // Inicio Productos
    @RequestMapping("/inventario-productos")
    public ModelAndView inventarioProductosModel() {
        return inventarioController.inventarioProductos();
    }

    @RequestMapping("/anyadirProducto")
    public ModelAndView anyadirProductoModel (String modelo, double precio, int stock, String urlFoto){
        return inventarioController.anyadirProducto(modelo, precio, stock, urlFoto);
    }

    @RequestMapping("/borrarProducto")
    public ModelAndView borrarProductoModel (String ref){
        return inventarioController.borrarProducto(ref);
    }

    @RequestMapping("/editarProducto")
    public ModelAndView editarProductoModel (String ref, String modelo, double precio, int stock, String urlFoto){
        return inventarioController.editarProducto(ref, modelo, precio, stock, urlFoto);
    }

    // Fin Productos

    // Inicio Vehículos

    @RequestMapping("/inventario-vehiculos")
    public ModelAndView inventarioVehiculosModel() {
        return inventarioController.inventarioVehiculos();
    }

    @RequestMapping("/anyadirVehiculo")
    public ModelAndView anyadirVehiculoModel(String marca, String modelo, String matricula, String color) {
        return inventarioController.anyadirVehiculo(marca, modelo, matricula, color);
    }

    @RequestMapping("/borrarVehiculo")
    public ModelAndView borrarVehiculoModel(String ref) {
        return inventarioController.borrarVehiculo(ref);
    }

    @RequestMapping("/editarVehiculo")
    public ModelAndView editarVehiculoModel(String ref, String marca, String modelo, String matricula, String color) {
        return inventarioController.editarVehiculo(ref, marca, modelo, matricula, color);
    }

    // Fin Vehículos

    // Inicio Tareas

    @RequestMapping("/tareas")
    public ModelAndView tareasModel() {
        return tareasController.tareas();
    }

    @RequestMapping("/anyadirTarea")
    public ModelAndView anyadirTareaModel (String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        return tareasController.anyadirTarea(cliente, empleados,fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);
    }

    @RequestMapping("/borrarTarea")
    public ModelAndView borrarTareaModel (String ref){
        return tareasController.borrarTarea(ref);
    }

    @RequestMapping("/editarTarea")
    public ModelAndView editarTareaModel (String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        return tareasController.editarTarea(ref, cliente, empleados, fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);
    }

    // Fin Tareas

    @RequestMapping("/pages-register")
    public ModelAndView register() {
        model.setViewName("pages-register.html");
        return model;
    }

    @RequestMapping("/users-profile")
    public ModelAndView usersProfile() {
        model.setViewName("users-profile.html");
        return model;
    }
}
