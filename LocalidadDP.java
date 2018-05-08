import java.util.StringTokenizer;

public class LocalidadDP {
    private String calle, colonia, estado;
    private int numero, telefono, cp, claveSucursal;
    
    public LocalidadDP(){
        this.estado     = "";
        this.colonia    = "";
        this.calle      = "";
        this.numero     = 0;
        this.cp         = 0;
        this.telefono   = 0;
        this.claveSucursal = 0;
    }
    
    public LocalidadDP(String datos){
        StringTokenizer st = new StringTokenizer(datos, "_");
        this.estado     = st.nextToken();
        this.colonia    = st.nextToken();
        this.calle      = st.nextToken();
        this.numero     = Integer.parseInt(st.nextToken());
        this.cp         = Integer.parseInt(st.nextToken());
        this.telefono   = Integer.parseInt(st.nextToken());
        this.claveSucursal = Integer.parseInt(st.nextToken());
    }
/* GETTERS */
    public String getEstado() {
        return this.estado;
    }
    public String getColonia() {
        return this.colonia;
    }
    public String getCalle() {
        return this.calle;
    }
    public int getNumero() {
        return this.numero;
    }
    public int getCp() {
        return this.cp;
    }
    public int getTelefono() {
        return this.telefono;
    }
    public int getclaveSucursal(){
        return this.claveSucursal;
    }
/* SETTERS */
    public void setEstado(String state) {
        this.estado = state;
    }
    public void setColonia(String col) {
        this.colonia = col;
    }
    public void setCalle(String street) {
        this.calle = street;
    }
    public void setNumero(int number) {
        this.numero = number;
    }
    public void setCp(int code) {
        this.cp = code;
    }
    public void setTelefono(int phone) {
        this.telefono = phone;
    }

    public void setClaveSucursal(int claveSuc){
        this.claveSucursal = claveSuc;
    }
    

    @Override
    public String toString(){
        return this.estado + "_" + this.colonia + "_" + this.calle + "_" + this.numero + "_" + this.cp + "_" + this.telefono + "_" + this.claveSucursal;
    }
    
    public String toStringSql(){
        return "'" + this.estado + "','" + this.colonia + "','" + this.calle + "','" + this.numero + "','" + this.cp + "','" + this.telefono + "'," + this.claveSucursal;
    }
}
