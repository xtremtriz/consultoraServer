import java.util.StringTokenizer;

public class LineaDP {
    private int claveLinea;
    private String nombre, descripcion;
    
    public LineaDP(){
        this.claveLinea  = 0;
        this.nombre      = "";
        this.descripcion = "";
    }
    
    public LineaDP(String datos){
    StringTokenizer st = new StringTokenizer(datos, "_");
        this.claveLinea   = Integer.parseInt(st.nextToken());
        this.nombre       = st.nextToken();
        this.descripcion  = st.nextToken();
    }
/* GETTERS */
    public int getclaveLinea() {
        return this.claveLinea;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
/* SETTERS */
    public void setclaveLinea(int linea) {
        this.claveLinea = linea;
    }
    public void setNombre(String name) {
        this.nombre = name;
    }
    public void setDescripcion(String description) {
        this.descripcion = description;
    }
 
    @Override
    public String toString(){
        return this.claveLinea + "_" + this.nombre + "_" + this.descripcion;
    }
    
    public String toStringSql(){
        return "'" + this.claveLinea + "','" + this.nombre + "','" + this.descripcion + "'";
    }
}
