import java.util.StringTokenizer;

public class SuministraDP {
    private int claveProducto, claveProveedor, cantidad;
    private String fecha;
    
    public SuministraDP(){
        this.claveProducto  = 0;
        this.claveProveedor = 0;
        this.fecha          = "";
        this.cantidad       = 0;
    }
    public SuministraDP(String datos){
        StringTokenizer st  = new StringTokenizer(datos, "_");

        this.claveProducto  = Integer.parseInt(st.nextToken());
        this.claveProveedor = Integer.parseInt(st.nextToken());
        this.fecha          = st.nextToken();
        this.cantidad       = Integer.parseInt(st.nextToken());
    }
    
/* GETTERS */
    public int getClaveProducto() {
        return this.claveProducto;
    }
    public int getClaveProveedor() {
        return this.claveProveedor;
    }
    public String getFecha() {
        return this.fecha;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
/* SETTERS */
    public void setClaveProducto(int producto) {
        this.claveProducto = producto;
    }
    public void setClaveProveedor(int proveedor) {
        this.claveProveedor = proveedor;
    }
    public void setfecha(String date) {
        this.fecha = date;
    }
    public void setCantidad(int quantity) {
        this.cantidad = quantity;
    }
 
    @Override
    public String toString(){
        return this.claveProducto + "_" + this.claveProveedor + "_" + this.fecha + "_" + this.cantidad;
    }
    public String toStringSql(){
        return "'" + this.claveProducto + "','" + this.claveProveedor + "','" + this.fecha + "'," + this.cantidad;
    }
}
