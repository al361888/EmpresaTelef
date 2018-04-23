package fabrica_clientes;

import direccion.Direccion;
import cliente.Empresa;
import cliente.Particular;

public interface Fabrica {

    Particular getParticular();
    Empresa getEmpresa();
    Particular getParticular(String nombre, String nif, String email, Direccion direccion, String apellidos);
    Empresa getEmpresa(String nombre, String nif, String email, Direccion direccion);

}
