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
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class A2ProveedorGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bCapturar;
    private JTextField tfClaveProveedor, tfNombre, tfDireccion, tfTelefono;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    //private CompanyADjdbc companyad = new CompanyADjdbc();
    private CompanyADjdbc companyad = new CompanyADjdbc();
    
    public A2ProveedorGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfClaveProveedor = new JTextField();
        tfNombre = new JTextField();
        tfDireccion = new JTextField();
        tfTelefono = new JTextField();
        bCapturar = new JButton("Capturar datos");
        bConsultar = new JButton("Consulta General");

        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);;

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave del proveedor: "));
        panel1.add(tfClaveProveedor);
        panel1.add(new JLabel("Nombre de Proveedor: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Direccion: "));
        panel1.add(tfDireccion);
        panel1.add(new JLabel("Telefono: "));
        panel1.add(tfTelefono);
        
        panel1.add(bCapturar);
        panel1.add(bConsultar);
        // panel1.add(bSalir);

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

    public String obtenerDatos(){
        String datos = "";
        String clave     = tfClaveProveedor.getText();
        String nombr      = tfNombre.getText();
        String direccion  = tfDireccion.getText();
        String telefono  = tfTelefono.getText();
        
        if(clave.isEmpty() || nombr.equals("") || direccion.equals("") || telefono.isEmpty())
            datos ="vacio";
        else
        {
            int cla = 0;
            int tel = 0;
            try {
                cla  = Integer.parseInt(clave);
                tel = Integer.parseInt(telefono);
                datos = clave+"_"+nombr+"_"+direccion+"_"+telefono;
            } 
            catch (NumberFormatException nfe) {
                datos = "NO_NUMERICO";
            }
            if (datos!="NO_NUMERICO")
                datos = cla+"_"+nombr+"_"+direccion+"_"+tel;
        }
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bCapturar)
		{
			String datos="";
			String resultado="";
			
			// 1. Obtner dato de los JTextFields
			datos = obtenerDatos();
			
			// 2. Checar si algun campo es vacio o saldo no numerico
			if(datos.equals("vacio"))
				taDatos.setText("Algun campo esta vacio...");
			
			else{
			
				// 3. Capturar los datos del cliente
				resultado = companyad.AltaProveedor(datos);
				
				// 4. Desplegar resultado de la transaccion
				taDatos.setText(resultado);
			}
		}

        if (e.getSource() == bConsultar) {
            String datos = companyad.consultarProveedor();
            if(datos.isEmpty()){
                datos = "Datos vacios";
            }
            taDatos.setText(datos);  
        }
    }

    public static void main(String args[]) {
        new A2ProveedorGUI();
    }
}

