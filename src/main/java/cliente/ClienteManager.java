package cliente;

import java.util.HashMap;

public class ClienteManager {
    private HashMap<String, Cliente> clientes;

    public ClienteManager(){
        HashMap<String,Cliente> clientes = new HashMap<String, Cliente>();
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean nuevoCliente(Cliente c){//Meh
        if(c==null)
            return false;
        else{
            clientes.put(c.getNIF(),c);
            return true;
        }
    }

    public boolean borrarCliente(Cliente c){//Meh
        if(c==null)
            return false;
        else{
            if(clientes.containsKey(c.getNIF())){
                clientes.remove(c);
                return true;
            } else
                return false;
        }

    }

    public void encontrarCliente(String nif){//Completar

    }



}