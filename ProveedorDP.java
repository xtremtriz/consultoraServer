import java.util.StringTokenizer;

public class ProveedorDP {
    private String nombre, direccion;
    private int claveProveedor, telefono;
    
    public ProveedorDP(){
        this.claveProveedor  = 0;
        this.nombre          = "";
        this.direccion       = "";
        this.telefono        = 0;
    }
    public ProveedorDP(String datos){
        StringTokenizer st  = new StringTokenizer(datos, "_");
        this.claveProveedor = Integer.parseInt(st.nextToken());
        this.nombre         = st.nextToken();
        this.direccion      = st.nextToken();
        this.telefono       = Integer.parseInt(st.nextToken());
    }

/* GETTERS */
    public int getclaveProveedor() {
        return this.claveProveedor;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public int getTelefono() {
        return this.telefono;
    }

/* SETTERS */
    public void setclaveProveedor(int clave) {
        this.claveProveedor = clave;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public void setDireccion(String address) {
        this.direccion = address;
    }
    public void setTelefono(int phone) {
        this.telefono = phone;
    }
    
    @Override
    public String toString(){
        return this.claveProveedor + "_" + this.nombre + "_" + this.direccion + "_" + this.telefono;
    }
    public String toStringSql(){
        return "'" + this.claveProveedor + "','" + this.nombre + "','" + this.direccion + "'," + this.telefono;
    }
    
}
