import java.util.StringTokenizer;

public class SucursalDP {

    private String nombre, direccion;
    private int numSucursal, telefono;

    public SucursalDP() {
        this.numSucursal = 0;
        this.nombre      = "";
        this.direccion   = "";
        this.telefono    = 0;
    }
    
    public SucursalDP(String datos){
    StringTokenizer st = new StringTokenizer(datos,"_");        
        this.numSucursal = Integer.parseInt(st.nextToken());
        this.nombre      = st.nextToken();
        this.direccion   = st.nextToken();
        this.telefono    = Integer.parseInt(st.nextToken());
    }
/* GETTERS */
    public int getnumSucursal() {
        return this.numSucursal;
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
    public void setnumSucursal(int num_S) {
        this.numSucursal = num_S;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public void setDireccion(String dir) {
        this.direccion = dir;
    }
    public void setTelefono(int tel) {
        this.telefono = tel;
    }

    @Override
    public String toString(){
        return this.numSucursal + "_" + this.nombre + "_" + this.direccion + "_" + this.telefono;
    }
    public String toStringSql(){
        return "'" + this.numSucursal + "','" + this.nombre + "','" + this.direccion + "'," + this.telefono;
    }
}
