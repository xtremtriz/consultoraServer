
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CompanyGUI extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu admin_T, sucursal, proveedor, reportes, producto, linea;
    private JMenuItem productoLinea, proveedorProducto, sucursalProducto, productoSucursal;
    private JMenuItem mExit, AsignarSucursal;
    private JMenuItem AsignarProveedor, AsignarProducto, AsignarLinea, AsignarProductoaSuc, AsignProdProv, AsignarLocalidad;
    
    private JPanel panel;

    private A1SucursalGUI sucursalgui = new A1SucursalGUI();
    private A2ProveedorGUI proveedorgui = new A2ProveedorGUI();
    private A3ProductoGUI productogui = new A3ProductoGUI();
    private A4LineaGUI lineagui = new A4LineaGUI();
    
    private A5AsignarProductoaSucursalGUI asignarproducto = new A5AsignarProductoaSucursalGUI();
    private A6AsignarProductodeProveedorGUI asignarproductoproveedor = new A6AsignarProductodeProveedorGUI();
    private A7LocalidadGUI localidadgui = new A7LocalidadGUI();
    
    private B1productoLineaGUI productolineagui = new B1productoLineaGUI();
    private B2proveedorProductoGUI proveedorproductogui = new B2proveedorProductoGUI();
    private B3sucursalProductoGUI sucursalproductogui = new B3sucursalProductoGUI();
    private B4productoSucursalGUI productosucursalgui = new B4productoSucursalGUI();
      
    public CompanyGUI() {
        super("Company GUI");

        menuBar = new JMenuBar();
        admin_T = new JMenu("Administracion");
        sucursal = new JMenu("Sucursal");
        proveedor = new JMenu("Proveedor");
        producto = new JMenu("Producto");
        reportes = new JMenu("Reportes");
        linea = new JMenu("Linea");
        
        productoLinea = new JMenuItem("Productos que pertenecen a una linea");
        proveedorProducto = new JMenuItem("Productos que suministra un Proveedor");
        sucursalProducto = new JMenuItem("Productos de las Sucursal");
        productoSucursal = new JMenuItem("Producto en Sucursal");
                
        AsignarSucursal = new JMenuItem("Introducir datos sucursal");
        AsignarProveedor = new JMenuItem("Introducir datos de proveedor");
        AsignarProducto = new JMenuItem("Ingresar productos");
        AsignarLinea = new JMenuItem("Ingresar datos de linea");
        
        
        AsignarProductoaSuc = new JMenuItem("Asignar producto a Sucursal (tiene)");
        AsignProdProv = new JMenuItem("Asignar productos del proveedor (suministra)");
        AsignarLocalidad = new JMenuItem("Asignar direcion de Sucursal (localidad)");
        mExit = new JMenuItem("Salir");
       
        menuBar.add(admin_T);
        menuBar.add(reportes);        
        admin_T.add(sucursal);
        admin_T.add(proveedor);
        admin_T.add(producto);
        admin_T.add(linea);
        
        reportes.add(productoLinea);
        reportes.add(proveedorProducto);
        reportes.add(sucursalProducto);
        reportes.add(productoSucursal);
        
        sucursal.add(AsignarSucursal);
        proveedor.add(AsignarProveedor);
        producto.add(AsignarProducto);
        linea.add(AsignarLinea);
        
        sucursal.add(AsignarProductoaSuc);
        sucursal.add(AsignarLocalidad);
        proveedor.add(AsignProdProv);
        admin_T.add(mExit);

        productoLinea.addActionListener(this);
        proveedorProducto.addActionListener(this);
        sucursalProducto.addActionListener(this);
        productoSucursal.addActionListener(this);
        
        AsignarSucursal.addActionListener(this);
        AsignarProveedor.addActionListener(this);
        AsignarProducto.addActionListener(this);
        AsignarLinea.addActionListener(this);
        
        AsignarProductoaSuc.addActionListener(this);
        AsignProdProv.addActionListener(this);
        AsignarLocalidad.addActionListener(this);
        mExit.addActionListener(this);
        
        setJMenuBar(menuBar);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public JPanel makePanel(){
        try{
            getContentPane().removeAll();
            getContentPane().remove(panel);
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
        panel = new JPanel();
        panel.setVisible(false);
 
        pack();
        setSize(580, 580);
        
        return panel;
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AsignarSucursal) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de sucursal"));
            panel = sucursalgui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        if (e.getSource() == AsignarProveedor) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de proveedor"));
            panel = proveedorgui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        if (e.getSource() == AsignarProducto) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de producto"));
            panel = productogui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        if (e.getSource() == AsignarLinea) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de linea"));
            panel = lineagui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        if (e.getSource() == AsignarProductoaSuc) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de Productos"));
            panel = asignarproducto.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        //AsignProdProv
        if (e.getSource() == AsignProdProv) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de Productos"));
            panel = asignarproductoproveedor.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        
        if (e.getSource() == AsignarLocalidad) {
            panel = makePanel();
            panel.add(new JLabel("Asignación de Productos"));
            panel = localidadgui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        
        if (e.getSource() == productoLinea) {
            panel = makePanel();
            panel.add(new JLabel("Consultar productos de linea"));
            panel = productolineagui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        
        if (e.getSource() == proveedorProducto) {
            panel = makePanel();
            panel.add(new JLabel("Consultar productos de linea"));
            panel = proveedorproductogui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        
        if (e.getSource() == sucursalProducto) {
            panel = makePanel();
            panel.add(new JLabel("Consultar productos de linea"));
            panel = sucursalproductogui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
                
        if (e.getSource() == productoSucursal) {
            panel = makePanel();
            panel.add(new JLabel("Consultar productos de linea"));
            panel = productosucursalgui.getPanel2();
            
            add(panel);
            setVisible(true);
        }
        if (e.getSource() == mExit) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new CompanyGUI();
    }
}
