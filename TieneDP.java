import java.util.StringTokenizer;
public class TieneDP {
    private int numeroSucursal, claveProducto;
    
    public TieneDP(){
        this.numeroSucursal = 0;
        this.claveProducto  = 0;
    }
    public TieneDP(String datos){
        StringTokenizer st  = new StringTokenizer(datos, "_");
        this.numeroSucursal = Integer.parseInt(st.nextToken());
        this.claveProducto  = Integer.parseInt(st.nextToken());
    }
    
/* GETTERS */
    public int getNumeroSucursal() {
        return this.numeroSucursal;
    }
    public int getClaveProducto() {
        return this.claveProducto;
    }

/* SETTERS */
    public void setNumeroSucursal(int num) {
        this.numeroSucursal = num;
    }

    public void setClaveProducto(int clave) {
        this.claveProducto = clave;
    }
 
    @Override
    public String toString(){
        return this.numeroSucursal + "_" + this.claveProducto;
    }
    public String toStringSql(){
        return "'" + this.numeroSucursal + "'," + this.claveProducto;
    }
}
