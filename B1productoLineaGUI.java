import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.StringTokenizer;

public class B1productoLineaGUI extends JFrame implements ActionListener {
    private JButton bConsultar;
    private JTextField tfClaveLinea;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    // private CompanyADjdbc companyad = new CompanyADjdbc();
    private Conexion conexion = new Conexion();

    public B1productoLineaGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfClaveLinea = new JTextField();
        bConsultar = new JButton("Consultar Productos");

        // Adicionar addActionListener a lo JButtons
        bConsultar.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(6, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave de linea: "));
        panel1.add(tfClaveLinea);

        panel1.add(bConsultar);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JPanel getPanel2() {
        return this.panel2;
    }

    public int obtenerDatos(){
        String num  = tfClaveLinea.getText();
        int linea = 0;
        //String cla  = tfClaveProducto.getText();
        
        if(num.isEmpty())
            linea = -1;
        else {
            //int cla1 = 0;
            try { 
                //por si no hay un valor numerico
                linea = Integer.parseInt(num);
                //cla1   = Integer.parseInt(cla);
            }catch (NumberFormatException nfe) {
                linea = -2;
            }  
        } 
        return linea;
    }

    private void tokenizar(String datos){
        String token = "";
        StringTokenizer st = new StringTokenizer(datos,"*");
        while(st.hasMoreTokens()){
            token = token + st.nextToken() + '\n';
            System.out.println(token);
            taDatos.setText(token);
        }
    }

     public void actionPerformed(ActionEvent e) {
        String datos = "";

        if (e.getSource() == bConsultar) {
            int linea = obtenerDatos();
            //System.out.println("linea ="+linea);
            if(linea == -1){
                datos = "Datos vacios";
            }
            else if(linea == -2)
                datos = "Ingrese el NUMERO de linea";
            else{
                datos = ""+linea;
                // datos = companyad.consultarLineaProd(linea);
                conexion.establecerConexion();
                conexion.enviarDatos("consultarLineaProd");
                conexion.enviarDatos(datos);
                datos = conexion.recibirDatos();
                conexion.cerrarConexion();
                tokenizar(datos);
            }
            // System.out.println("En GUI: "+datos);
            if(datos.isEmpty())
                datos = "No se encontraron registros de "+tfClaveLinea.getText();
            // taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new B1productoLineaGUI();
    }
}