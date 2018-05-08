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

public class A3ProductoGUI extends JFrame implements ActionListener {
    private JButton bConsultar, bCapturar;
    private JTextField tfClaveProducto, tfNombre, tfMarca, tfCantidad, tfPrecio, tfClaveLinea;
    private JPanel panel1, panel2;
    private JTextArea taDatos;

    private CompanyADjdbc companyad = new CompanyADjdbc();

    public A3ProductoGUI() {
        super("Asignacion de Proveedor");
        panel1 = new JPanel();
        panel2 = new JPanel();

        taDatos = new JTextArea(9, 35);//1-3
        tfClaveProducto = new JTextField();
        tfNombre = new JTextField();
        tfMarca = new JTextField();
        tfCantidad = new JTextField();
        tfPrecio = new JTextField();
        tfClaveLinea = new JTextField();
        bCapturar = new JButton("Capturar datos");
        bConsultar = new JButton("Consulta General");

        // Adicionar addActionListener a lo JButtons
        bCapturar.addActionListener(this);
        bConsultar.addActionListener(this);;

        // 2. Definir los Layouts de los JPanels
        panel1.setLayout(new GridLayout(8, 2));
        panel2.setLayout(new FlowLayout());

        // 3. Colocar los objetos de los atributos en los JPanels correspondientes
        panel1.add(new JLabel("Clave del producto: "));
        panel1.add(tfClaveProducto);
        panel1.add(new JLabel("Nombre del producto: "));
        panel1.add(tfNombre);
        panel1.add(new JLabel("Marca: "));
        panel1.add(tfMarca);
        panel1.add(new JLabel("Cantidad: "));
        panel1.add(tfCantidad);
        panel1.add(new JLabel("Precio: "));
        panel1.add(tfPrecio);
        panel1.add(new JLabel("Clave de linea: "));
        panel1.add(tfClaveLinea);
        
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
        String clave  = tfClaveProducto.getText();
        String nombr  = tfNombre.getText();
        String marc   = tfMarca.getText();
        String cant   = tfCantidad.getText();
        String prec   = tfPrecio.getText();
        String clave2  = tfClaveLinea.getText();
        
        if(clave.isEmpty() || nombr.isEmpty() || marc.isEmpty() || cant.isEmpty() || prec.isEmpty() || clave2.isEmpty())
            datos = "vacio";
        else {
            int cla  = 0;
            int ca   = 0;
            int pre  = 0;
            int cla2 = 0;
            try { 
                //por si no hay un valor numerico
                cla   = Integer.parseInt(clave);
                ca   = Integer.parseInt(cant);
                pre  = Integer.parseInt(prec);
                cla2  = Integer.parseInt(clave2);
            } 
            catch (NumberFormatException nfe) {
                datos = "NO_NUMERICO";
            }   
            if (datos!="NO_NUMERICO")
                datos = cla+"_"+nombr+"_"+marc+"_"+ca+"_"+pre+"_"+cla2;
        }
        return datos;
    }

    public void actionPerformed(ActionEvent e) {
        String datos = "";
        if (e.getSource() == bCapturar) 
        {
			//String datos="";
			String resultado="";
			
			// 1. Obtner dato de los JTextFields
			datos = obtenerDatos();
			
			// 2. Checar si algun campo es vacio o saldo no numerico
			if(datos.equals("vacio"))
				taDatos.setText("Algun campo esta vacio...");
			
			else{
			
				// 3. Capturar los datos del cliente
				resultado = companyad.AltaProductos(datos);
				
				// 4. Desplegar resultado de la transaccion
				taDatos.setText(resultado);
			}
        }

        if (e.getSource() == bConsultar) {
            datos = companyad.consultarProducto();
            if(datos.isEmpty()){
                datos = "Datos vacios";
                
            }
            System.out.println(datos);
            taDatos.setText(datos); 
        }
    }

    public static void main(String args[]) {
        new A3ProductoGUI();
    }
}
