import javax.swing.*;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.StringTokenizer;

public class B4productoSucursalGUI extends JFrame implements ActionListener {
    private JButton bConsultar;
    private JTextField tfClaveProducto;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private Conexion conexion = new Conexion();

    public B4productoSucursalGUI() {
        super("Consulta de productos");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3        
        tfClaveProducto = new JTextField();
        bConsultar = new JButton("Consultar Sucursales");

        // Adicionar addActionListener a lo JButtons
        bConsultar.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
         panel1.add(new JLabel("Clave del producto: "));
        panel1.add(tfClaveProducto);
       
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
        int datos = 0;
        
        if(tfClaveProducto.getText().isEmpty())
            datos = -1;
        else {
            try{
                datos = Integer.parseInt(tfClaveProducto.getText());
            }catch(NumberFormatException nfe){
                datos = -2;
                System.out.println("Error al convertir el numero");
            }
        } 
        // System.out.println("\n "+datos);
        return datos;
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
        int clave = 0;

        if (e.getSource() == bConsultar) {
            //datos = companyad.consultaAsignacionEmpleadosProyecto();
            clave = obtenerDatos();
            if(clave == -1)
                datos = "Ingrese una producto a consultar";
            else if(clave == -2)
                datos = "Ingrese el NUMERO de producto";
            else{
                // datos = companyad.consultarSucursalProducto(clave);
                datos = ""+clave;
                conexion.establecerConexion();
                conexion.enviarDatos("consultarSucursalProducto");
                conexion.enviarDatos(datos);
                datos = conexion.recibirDatos();
                conexion.cerrarConexion();
                tokenizar(datos);
            }
            if(datos.isEmpty())
                datos = "No se encontraron registros de "+tfClaveProducto.getText();
            //taDatos.setText(datos); 
            // taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new B4productoSucursalGUI();
    }
}
