package Modelo.fabrica_clientes;

import Modelo.direccion.Direccion;
import Modelo.cliente.Empresa;
import Modelo.cliente.Particular;

public interface Fabrica {

    Particular getParticular();
    Empresa getEmpresa();
    Particular getParticular(String nombre, String nif, String email, Direccion direccion, String apellidos);
    Empresa getEmpresa(String nombre, String nif, String email, Direccion direccion);

}
