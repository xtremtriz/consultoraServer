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

public class A7LocalidadGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bCapturar, bConsultarSucursal;
    private JTextField tfEstado, tfColonia, tfCalle, tfNumero, tfCp, tfTelefono, tfClaveSucursal;
    private JPanel panel1, panel2;
    private JTextArea taDatos;
    private StringTokenizer st;

    private Conexion conexion = new Conexion();
    private CompanyADjdbc companyad = new CompanyADjdbc();

    public A7LocalidadGUI() {
        super("Asignacion de Sucursal");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfEstado = new JTextField();
        tfColonia = new JTextField();
        tfCalle = new JTextField();
        tfNumero = new JTextField();
        tfCp = new JTextField();
        tfTelefono = new JTextField();
        tfClaveSucursal = new JTextField();
        bCapturar = new JButton("Capturar datos");
        bConsultar = new JButton("Consulta General");
        bConsultarSucursal = new JButton("Consulta de sucursales");

        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);
        bConsultarSucursal.addActionListener(this);

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(10, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Estado: "));
        panel1.add(tfEstado);
        panel1.add(new JLabel("Colonia: "));
        panel1.add(tfColonia);
        panel1.add(new JLabel("Calle: "));
        panel1.add(tfCalle);
        panel1.add(new JLabel("Numero: "));
        panel1.add(tfNumero);
        panel1.add(new JLabel("Codigo Postal: "));
        panel1.add(tfCp);
        panel1.add(new JLabel("Telefono: "));
        panel1.add(tfTelefono);
        panel1.add(new JLabel("Clave de Sucursal: "));
        panel1.add(tfClaveSucursal);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        panel1.add(bConsultarSucursal);
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
        String est     = tfEstado.getText();
        String col      = tfColonia.getText();
        String call  = tfCalle.getText();
        String num  = tfNumero.getText();
        String cp   = tfCp.getText();
        String tel  = tfTelefono.getText();
        String suc  = tfClaveSucursal.getText();
        
        if(est.isEmpty() || col.isEmpty() || call.isEmpty() || num.isEmpty() || cp.isEmpty() || tel.isEmpty() || suc.isEmpty())
            datos = "vacio";
        else {
            int num1 = 0;
            int cp1 = 0;
            int tel1 = 0;
            int suc1 = 0;
            try { 
                //por si no hay un valor numerico
                num1 = Integer.parseInt(num);
                cp1 = Integer.parseInt(cp);
                tel1 = Integer.parseInt(tel);
                suc1 = Integer.parseInt(suc);
            } 
            catch (NumberFormatException nfe) {
                datos = "NO_NUMERICO";
            }   
            if (datos!="NO_NUMERICO")
                datos = est+"_"+col+"_"+call+"_"+num1+"_"+cp1+"_"+tel1+"_"+suc1;
        } 
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        String datos = "";
        if(e.getSource() == bCapturar)
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
                                conexion.enviarDatos("altaLocalidad");
			
				// 2.3 Enviar los datos a capturar en la DB
                                conexion.enviarDatos(datos);
				
				// 2.4 Recibir resultado de la transaccion
                                respuesta = conexion.recibirDatos();
                                
                                // 2.5 Cerrar la conexion
                                conexion.cerrarConexion();
			
				// 3. Capturar los datos del cliente
				//resultado = companyad.altaLocalidad(datos);
				
			}taDatos.setText(respuesta);
		}


        if (e.getSource() == bConsultar) { 
            // 1. Establecer conexion con el Server
            conexion.establecerConexion();
            // 2. Enviar transaccion a realizar
            conexion.enviarDatos("consultarLocalidad");
            // 3. Recibir resultado de la transaccion
            datos = conexion.recibirDatos();
            // 4. Cerrrar conexion
            conexion.cerrarConexion();
            // 5. Desplegar datos
            // taDatos.setText(datos);
            tokenizar(datos);
            //String datos = companyad.consultarSucursales();
            if(datos.isEmpty()){
                datos = "Datos vacios";
            } 
        }
        if (e.getSource() == bConsultarSucursal) { 
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
            //String datos = companyad.consultarSucursales();
            if(datos.isEmpty()){
                datos = "Datos vacios";
            } 
        }
    }

    public static void main(String args[]) {
        new A7LocalidadGUI();
    }
}

