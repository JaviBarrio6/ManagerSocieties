package com.Tareas.Entidad;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Inventario.Herramienta.Entidad.Herramienta;
import com.Inventario.Maquina.Entidad.Maquina;
import com.Inventario.Material.Entidad.Material;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Vehiculo.Entidad.Vehiculo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "tareas")
public class Tarea implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refTareas = "TAR";
    @Column (name = "ref")
    private String ref;

    @OneToOne
    private Cliente cliente;
    @Column (name = "fecha_Inicio")
    private String fechaInicio;
    @Column (name = "fecha_Fin")
    private String fechaFin;

    @Column (name = "hora")
    private String hora;

    @ManyToMany
    private List<Empleado> empleados;
    @Column (name = "precio")
    private double precio;
    @Column (name = "gasto_Extra")
    private double gastoExtra;

    @ManyToMany
    private List<Herramienta> herramientas;
    @ManyToMany
    private List<Maquina> maquinas;
    @ManyToMany
    private List<Material> materiales;
    @ManyToMany
    private List<Producto> productos;
    @ManyToMany
    private List<Vehiculo> vehiculos;
    @Column (name = "info")
    private String info;

    @Column (name = "estado")
    private int estado;

    // Fin Variables

    // Inicio Constructores
    public Tarea (){
       setRef("");
       setCliente(null);
       setFechaInicio("-");
       setFechaFin("-");
       setPrecio(0);
       setGastoExtra(0);
       setInfo("");
       setEstado(0);
       setEmpleados(null);
       setHora("-");
       setHerramientas(null);
       setMaquinas(null);
       setMateriales(null);
       setProductos(null);
       setVehiculos(null);
    }

    public Tarea (Cliente cliente, List<Empleado> empleados, String fechaInicio, String fechaFin, String hora, double precio,
                  double gastoExtra, String info, int estado, List<Herramienta> herramientas, List<Maquina> maquinas,
                  List<Material> materiales, List<Producto> productos, List<Vehiculo> vehiculos, int pos){
        setCliente(cliente);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setPrecio(precio);
        setGastoExtra(gastoExtra);
        setInfo(info);
        setEstado(estado);
        setEmpleados(empleados);
        setHora(hora);
        setHerramientas(herramientas);
        setMaquinas(maquinas);
        setMateriales(materiales);
        setProductos(productos);
        setVehiculos(vehiculos);

        setRef(generadorRef(++pos, refTareas));
    }

    public Tarea (String ref, Cliente cliente, List<Empleado> empleados, String fechaInicio, String fechaFin, String hora, double precio,
                  double gastoExtra, String info, int estado, List<Herramienta> herramientas, List<Maquina> maquinas,
                  List<Material> materiales, List<Producto> productos, List<Vehiculo> vehiculos){
        setCliente(cliente);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setPrecio(precio);
        setGastoExtra(gastoExtra);
        setInfo(info);
        setEstado(estado);
        setEmpleados(empleados);
        setHora(hora);
        setHerramientas(herramientas);
        setMaquinas(maquinas);
        setMateriales(materiales);
        setProductos(productos);
        setVehiculos(vehiculos);

        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio == null){
            this.fechaInicio = "-";
        } else if (fechaInicio.equals("")){
            this.fechaInicio = "-";
        } else {
            this.fechaInicio = (darFormatoFecha(fechaInicio));

        }
    }

    public void setFechaFin(String fechaFin) {
        if (fechaFin == null){
            this.fechaFin = "-";
        } else if (fechaFin.equals("")){
            this.fechaFin = "-";
        } else {
            this.fechaFin = (darFormatoFecha(fechaFin));

        }
    }

    public void setHora (String hora){
        this.hora = hora;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setGastoExtra(double gastoExtra) {
        this.gastoExtra = gastoExtra;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCliente (Cliente cliente){
        this.cliente = cliente;
    }

    public void setEmpleados (List<Empleado> empleados){
        this.empleados = empleados;
    }

    public void setHerramientas (List<Herramienta> herramientas){
        this.herramientas = herramientas;
    }

    public void setMaquinas(List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setEstado (int estado){
        if (estado < 0 || estado > 2){
            this.estado = 0;
        } else {
            this.estado = estado;
        }
    }

    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public String getHora() {
        return this.hora;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }
    public double getPrecio(){
        return this.precio;
    }

    public double getGastoExtra() {
        return this.gastoExtra;
    }

    public List<Herramienta> getHerramientas() {
        return this.herramientas;
    }

    public List<Maquina> getMaquinas() {
        return this.maquinas;
    }

    public List<Material> getMateriales() {
        return this.materiales;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public String getInfo() {
        return this.info;
    }

    public int getEstado() {
        return this.estado;
    }


    // Fin Getters

    // Inicio Funciones
    public String generadorRef (int num, String ref){
        int digitos = (int)(Math.log10(num)+ 1);
        String refAux = "";
        for (int i = 0; i < (4-digitos); i++){
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }

    public String darFormatoFecha (String fecha){
        String[] campos = fecha.split("-");
        if (campos.length != 3){
            return fecha;
        } else {
            return campos[2].concat("/".concat(campos[1]).concat("/").concat(campos[0]));
        }
    }

    public String desformatearFecha (String fecha){
        if (fecha.equals("-")){
            return fecha;
        } else {
            String[] campos = fecha.split("/");
            return campos[2].concat("-".concat(campos[1]).concat("-").concat(campos[0]));
        }
    }

    public boolean contieneEmpleado (String empleado, String[] empleados){
        for (int contador = 0; contador < empleados.length; contador++){
            if (empleado.equals(empleados[contador])){
                return true;
            }
        }
        return false;
    }

    public boolean contieneInventario (String objeto, String[] inventario){
        if (inventario == null){
            return false;
        }
        for (int contador = 0; contador < inventario.length; contador++){
            if (objeto.equals(inventario[contador])){
                return true;
            }
        }
        return false;
    }

    // Fin Funciones
}
