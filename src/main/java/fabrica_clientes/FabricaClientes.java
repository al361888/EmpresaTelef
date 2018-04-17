package fabrica_clientes;

import Direccion.Direccion;
import cliente.Empresa;
import cliente.Particular;

public class FabricaClientes implements Fabrica{

    @Override
    public Particular getParticular() {
        return new Particular();
    }

    @Override
    public Empresa getEmpresa() {
        return new Empresa();
    }

    @Override
    public Particular getParticular(String nombre, String nif, String email, Direccion direccion, String apellidos) {
        return new Particular(nombre,nif,email,direccion,apellidos);
    }

    @Override
    public Empresa getEmpresa(String nombre, String nif, String email, Direccion direccion) {
        return new Empresa(nombre,nif,email,direccion);
    }
}
