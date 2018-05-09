import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class A5AsignarProductoaSucursalGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bCapturar;
    private JButton bConsultarSucursal, bConsultarProducto;
    private JTextField tfNumSucursal, tfClaveProducto;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private StringTokenizer st;

    private Conexion conexion = new Conexion();

    private CompanyADjdbc companyad = new CompanyADjdbc();

    public A5AsignarProductoaSucursalGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfNumSucursal = new JTextField();
        tfClaveProducto = new JTextField();
        bCapturar = new JButton("Capturar datos");
        bConsultar = new JButton("Consulta General");
        bConsultarSucursal = new JButton("Consultar Sucursales");
        bConsultarProducto = new JButton("Consultar Productos");

        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarSucursal.addActionListener(this);
        bConsultarProducto.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Numero de sucursal: "));
        panel1.add(tfNumSucursal);
        panel1.add(new JLabel("Clave de producto: "));
        panel1.add(tfClaveProducto);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarSucursal);
        panel1.add(bConsultarProducto);
        // panel1.add(bSalir);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));

        // 4. Adicionar el panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void tokenizar(String datos){
        String token = "";
        st = new StringTokenizer(datos,"*");
        while(st.hasMoreTokens()){
            token = token + st.nextToken() + '\n';
            System.out.println(token);
            taDatos.setText(token);
        }
    }

    public JPanel getPanel2() {
        return this.panel2;
    }

    public String obtenerDatos(){
        String datos = "";
        String num  = tfNumSucursal.getText();
        String cla  = tfClaveProducto.getText();
        
        if(num.isEmpty() || cla.isEmpty())
            datos = "vacio";
        else {
            int num1 = 0;
            int cla1 = 0;
            try { 
                //por si no hay un valor numerico
                num1 = Integer.parseInt(num);
                cla1   = Integer.parseInt(cla);
            } 
            catch (NumberFormatException nfe) {
                datos = "NO_NUMERICO";
            }   
            if (datos!="NO_NUMERICO")
                datos = num+"_"+cla;
        } 
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        String datos = "";
        if (e.getSource() == bCapturar) 
        {
			//String datos="";
			String respuesta="";
			
			// 1. Obtner dato de los JTextFields
			datos = obtenerDatos();
			
			// 2. Checar si algun campo es vacio o saldo no numerico
			if(datos.equals("vacio"))
				respuesta = "Algun campo esta vacio...";
			
			else{
                                // 2.1 Establecer conexion con el server
                                conexion.establecerConexion();
                                
                                // 2.2 Enviar la transaccion a realizar
                                conexion.enviarDatos("AltaTiene");
			
				// 2.3 Enviar los datos a capturar en la DB
                                conexion.enviarDatos(datos);
				
				// 2.4 Recibir resultado de la transaccion
                                respuesta = conexion.recibirDatos();
                                
                                // 2.5 Cerrar la conexion
                                conexion.cerrarConexion();
				// 3. Capturar los datos del cliente
				
			}                        
                        taDatos.setText(respuesta);
		}


        if (e.getSource() == bConsultar) {
            //datos = companyad.consultarTiene();
            // 1. Establecer conexion con el Server
            conexion.establecerConexion();
            // 2. Enviar transaccion a realizar
            conexion.enviarDatos("consultarTiene");
            // 3. Recibir resultado de la transaccion
            datos = conexion.recibirDatos();
            // 4. Cerrrar conexion
            conexion.cerrarConexion();
            // 5. Desplegar datos
            // taDatos.setText(datos);
            tokenizar(datos);
            if(datos.isEmpty()){
                datos = "Datos vacios";
            }
            //taDatos.setText(datos); 
        }
        
        if (e.getSource() == bConsultarSucursal) {
            //datos = companyad.consultarSucursales();
            // 1. Establecer conexion con el Server
            conexion.establecerConexion();
            // 2. Enviar transaccion a realizar
            conexion.enviarDatos("consultarSucursales");
            // 3. Recibir resultado de la transaccion
            datos = conexion.recibirDatos();
            // 4. Cerrrar conexion
            conexion.cerrarConexion();
            // 5. Desplegar datos
            // taDatos.setText(datos);
            tokenizar(datos);
            if(datos.isEmpty()){
                datos = "Datos vacios";
            }
            //taDatos.setText(datos); 
        }
        if (e.getSource() == bConsultarProducto) {
            //datos = companyad.consultarProducto();
            // 1. Establecer conexion con el Server
            conexion.establecerConexion();
            // 2. Enviar transaccion a realizar
            conexion.enviarDatos("consultarProducto");
            // 3. Recibir resultado de la transaccion
            datos = conexion.recibirDatos();
            // 4. Cerrrar conexion
            conexion.cerrarConexion();
            // 5. Desplegar datos
            // taDatos.setText(datos);
            tokenizar(datos);
            if(datos.isEmpty()){
                datos = "Datos vacios";
            }
            //taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new A5AsignarProductoaSucursalGUI();
    }
}
