package Modelo.cliente;

import java.util.HashMap;

public class ClienteManager {
    private HashMap<String, Cliente> clientes;

    //Constructor
    public ClienteManager() {
        HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    }

    //Métodos
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean nuevoCliente(Cliente c) {
        if (c == null)
            return false;
        else {
            if (clientes.containsKey(c.getNIF()))
                return false;
            else {
                clientes.put(c.getNIF(), c);
                return true;
            }
        }
    }

    public boolean borrarCliente(Cliente c) {
        if (c == null)
            return false;
        else {
            if (clientes.containsKey(c.getNIF())) {
                clientes.remove(c);
                return true;
            } else
                return false;
        }

    }

    public Cliente encontrarCliente(String nif) {
        if (clientes.containsKey(nif)) {
            return clientes.get(nif);
        }
        return null;
    }

}