import java.util.StringTokenizer;

public class ProductoDP {    
    private String nombre, marca;
    private int claveProducto, cantidadExistente, precioUnitario, claveLinea;
    
    public ProductoDP() {
        this.claveProducto      = 0;
        this.nombre             = "";
        this.marca              = "";
        this.cantidadExistente  = 0;
        this.precioUnitario     = 0;
        this.claveLinea         = 0;        
    }
    
    public ProductoDP(String datos){
    StringTokenizer st = new StringTokenizer(datos,"_");        
        this.claveProducto      = Integer.parseInt(st.nextToken());
        this.nombre             = st.nextToken();
        this.marca              = st.nextToken();
        this.cantidadExistente  = Integer.parseInt(st.nextToken());
        this.precioUnitario     = Integer.parseInt(st.nextToken());
        this.claveLinea         = Integer.parseInt(st.nextToken());
    }
/* GETTERS */
    public int getclaveProducto() {
        return this.claveProducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getMarca() {
        return this.marca;
    }
    public int getcantidadExistente() {
        return this.cantidadExistente;
    }
    public int getprecioUnitario() {
        return this.precioUnitario;
    }
    public int getclaveLinea() {
        return this.claveLinea;
    }

/* SETTERS */
    public void setclaveProducto(int producto) {
        this.claveProducto = producto;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public void setMarca(String brand) {
        this.marca = brand;
    }
    public void setcantidadExistente(int cantidad) {
        this.cantidadExistente = cantidad;
    }
    public void setprecioUnitario(int precio) {
        this.precioUnitario = precio;
    }
    public void setclaveLinea(int linea) {
        this.claveLinea = linea;
    }
    
    @Override
    public String toString(){
        return this.claveProducto + "_" + this.nombre + "_" + this.marca + "_" + this.cantidadExistente + "_" + this.precioUnitario + "_" + this.claveLinea;
    }
    public String toStringSql(){
        return "'" + this.claveProducto + "','" + this.nombre + "','" + this.marca + "','" + this.cantidadExistente + "','" + this.precioUnitario + "'," + this.claveLinea;
    }
}
