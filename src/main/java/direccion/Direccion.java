package direccion;

/**
 * Created by al361888 on 27/02/18.
 */
public class Direccion {
    private String cp;
    private String provincia;
    private String poblacion;

    public Direccion(){
        this.cp = null;
        this.provincia = null;
        this.poblacion=null;
    }

    public Direccion(String cp, String provincia, String poblacion){
        this.cp = cp;
        this.provincia=provincia;
        this.poblacion=poblacion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString(){
        return cp + " " + provincia + " " + poblacion;
    }
}