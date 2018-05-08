import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyADjdbc {
    //SucursalDP sucursalDP;
    ProveedorDP proveedorDP;
    LineaDP lineaDP;
    ProductoDP productoDP = new ProductoDP();
    TieneDP tieneDP;
    SuministraDP suministraDP;
    LocalidadDP localidadDP;
    
    Connection conexion;
    Statement statement;
    public CompanyADjdbc()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultora?user=root");
			System.out.println("Conexion exitosa...");
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println("Error 1: "+cnfe);// if No driver
		}
		catch(InstantiationException ie)
		{
			System.out.println("Error 2: "+ie); // for newInstance
		}
		catch(IllegalAccessException iae)
		{
			System.out.println("Error 3: "+iae); // for newInstance
		}
		catch(SQLException sqle)
		{
			System.out.println("Error 4: "+sqle); // for newInstance

		}
	}
    /*String AltaSucursal(String datos) 
    {
		String resultado = "";
		String insert="";

		sucursalDP = new SucursalDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO sucursal VALUES("+sucursalDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de sucursal ya existe, (Ingresa otro)";	
		}
		return resultado;	
	}

    String consultarSucursales() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM sucursal";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        sucursalDP=new SucursalDP();
                        while(sr.next())
                        {

                        sucursalDP.setnumSucursal(sr.getInt(1));	
                        sucursalDP.setNombre(sr.getString(2));	
                        sucursalDP.setDireccion(sr.getString(3));	
                        sucursalDP.setTelefono(sr.getInt(4));	

                        datos=datos+sucursalDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }*/
    String AltaProveedor(String datos) 
    {
		String resultado = "";
		String insert="";

		proveedorDP = new ProveedorDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO proveedor VALUES("+proveedorDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de proveedor ya existe, (Ingresa otro)";	
		}
		return resultado;	
	}
        
        String consultarProveedor() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM proveedor";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        proveedorDP=new ProveedorDP();
                        while(sr.next())
                        {

                        proveedorDP.setclaveProveedor(sr.getInt(1));	
                        proveedorDP.setNombre(sr.getString(2));	
                        proveedorDP.setDireccion(sr.getString(3));	
                        proveedorDP.setTelefono(sr.getInt(4));	

                        datos=datos+proveedorDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
    String AltaLinea(String datos) 
    {
		String resultado = "";
		String insert="";

		lineaDP = new LineaDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO linea VALUES("+lineaDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de linea ya existe, (Ingresa otro)";	
		}
		return resultado;	
	}
    String consultarLinea() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM linea";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        lineaDP=new LineaDP();
                        while(sr.next())
                        {

                        lineaDP.setclaveLinea(sr.getInt(1));	
                        lineaDP.setNombre(sr.getString(2));	
                        lineaDP.setDescripcion(sr.getString(3));		

                        datos=datos+lineaDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
    
    String AltaProductos(String datos) 
    {
		String resultado = "";
		String insert="";

		productoDP = new ProductoDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Producto VALUES("+productoDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "Este numero de producto o numero de linea no existe, (Ingresa otro)";	
		}
		return resultado;	
	}
    
    String consultarProducto() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM producto";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        productoDP=new ProductoDP();
                        while(sr.next())
                        {

                        productoDP.setclaveProducto(sr.getInt(1));	
                        productoDP.setNombre(sr.getString(2));	
                        productoDP.setMarca(sr.getString(3));
                        productoDP.setcantidadExistente(sr.getInt(4));
                        productoDP.setprecioUnitario(sr.getInt(5));
                        productoDP.setclaveLinea(sr.getInt(6));

                        datos=datos+productoDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
    
    String AltaTiene(String datos) 
    {
		String resultado = "";
		String insert="";

		tieneDP = new TieneDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Tiene VALUES("+tieneDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    
    String consultarTiene() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM tiene";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        tieneDP=new TieneDP();
                        while(sr.next())
                        {

                        tieneDP.setNumeroSucursal(sr.getInt(1));	
                        tieneDP.setClaveProducto(sr.getInt(2));	
                      

                        datos=datos+tieneDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
    
    String altaSuministra(String datos) 
    {
		String resultado = "";
		String insert="";
                String insert2;

		suministraDP = new SuministraDP(datos);
                //productoDP = new ProductoDP();
                int newCantidad = suministraDP.getCantidad() + productoDP.getcantidadExistente();
                int clave = suministraDP.getClaveProducto();
                //int clave = newCantidad;
                //System.out.println("Cantidad anterior: "+ (newCantidad - suministraDP.getCantidad()) + "\n Nueva Cantidad: "+newCantidad);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO Suministra VALUES("+suministraDP.toStringSql()+")";
                insert2="UPDATE producto SET cantidad = "+newCantidad+" WHERE claveProducto = "+ clave ;
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
                        statement.executeUpdate(insert2);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    String consultarSuminstra() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM suministra";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        suministraDP=new SuministraDP();
                        while(sr.next())
                        {

                        suministraDP.setClaveProducto(sr.getInt(1));
                        suministraDP.setClaveProveedor(sr.getInt(2));
                        suministraDP.setfecha(sr.getString(3));
                        suministraDP.setCantidad(sr.getInt(4));	
                      

                        datos=datos+suministraDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
    
    String altaLocalidad(String datos) 
    {
		String resultado = "";
		String insert="";

		localidadDP = new LocalidadDP(datos);
		//insert="INSERT INTO Cliente VALUES("+clienteDP.toStringSql()+")";
                insert="INSERT INTO localidad VALUES("+localidadDP.toStringSql()+")";
		try{
			// 1. Abrir archivo de datos(abrir la base de datos para manipular cualquier tabla de la base datos )
				 
			statement=conexion.createStatement();
		
			// 2. Abrir o almacenar los datos en archivo	
			
			statement.executeUpdate(insert);
		
			// 3. Cerrar archivo		
                        statement.close();

			// 4. Enviar recibo de 
			resultado = "Captura correcta";	
			System.out.println(insert); 	
			
		}catch(SQLException sqle){	
			System.out.println("Incorrecta: "+sqle); 
			resultado = "(Ingresa otro)";	
		}
		return resultado;	
	}
    
    String consultarLocalidad() {
		String datos = "";
		String query   = "";
	
		ResultSet sr=null;
		
		query="SELECT *FROM localidad";

		try{
			// 1. Abrir archivo de datos
			statement=conexion.createStatement();
			// 2. Procesar datos
			sr=statement.executeQuery(query);	
                        //archivoIn.close();
                        localidadDP=new LocalidadDP();
                        while(sr.next())
                        {
                        localidadDP.setEstado(sr.getString(1));
                        localidadDP.setColonia(sr.getString(2));
                        localidadDP.setCalle(sr.getString(3));
                        localidadDP.setNumero(sr.getInt(4));	
                        localidadDP.setCp(sr.getInt(5));
                        localidadDP.setTelefono(sr.getInt(6));
                        localidadDP.setClaveSucursal(sr.getInt(7));

                        datos=datos+localidadDP.toString()+"\n";
                        }
        	statement.close();
        	System.out.println(query); 
		}
	
		catch(SQLException sqle){
			System.out.println("Error: "+sqle); 
			datos = "ERROR en la consulta "+ sqle;	
		}
		return datos;	  
    }
/* Consulta los productos de una linea */
    String consultarLineaProd(int clave) {
		String datos = "";
		String respuesta = "";
              
        ResultSet tr;
        
        String query = "SELECT Linea.nombre, Producto.claveProducto FROM Producto JOIN Linea ON Producto.claveLin = Linea.claveLinea WHERE claveLinea = "+clave;
        System.out.println(query);
        
        try{
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            
            while(tr.next()){
				datos = tr.getString(1);
				String iString = "" +tr.getInt(2);

				datos = datos+"_"+iString+"\n";
				respuesta = respuesta + datos;

                // System.out.println(respuesta);
            } 
            statement.close();
            //System.out.println("\nAD: "+datos);
        }catch(SQLException sqle){
            respuesta = "Error consultar la linea"+sqle;
            //resultado = "no existe, (Ingresa otro)";	
        }
        return respuesta;
	}
/* Productos de un proveedor */
    String consultarProveedorProducto(int clv) {
		String datos = "";
		String respuesta = "";
        ResultSet tr;
        
		String query = "SELECT Proveedor.nombre, telefono, Proveedor.direccion, Producto.claveProducto, Producto.nombre FROM Suministra JOIN Proveedor ON Proveedor.claveProveedor = Suministra.claveProveedo JOIN Producto ON Producto.claveProducto = Suministra.claveProduct WHERE claveProveedor = "+clv;
		
		System.out.println(query);
        
        try{
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            
            while(tr.next()){
				String nombre = tr.getString(1);
				String telefono = "" +tr.getInt(2);
				String direccion = tr.getString(3);
				String clave = "" +tr.getInt(4);
				String nombre2 = tr.getString(5);
				
				datos = nombre+"_"+telefono+"_"+direccion+"_"+clave+"_"+nombre2+"\n";
				respuesta = respuesta + datos;
                // System.out.println(respuesta);
            } 
            statement.close();
            //System.out.println("\nAD: "+datos);
        }catch(SQLException sqle){
            respuesta = "Error consultar los productos del proveedor "+sqle;
        }
        return respuesta;
	}
/* Productos de una sucursal */
    String consultarProductoSucursal(int sucursal) {
		String datos = "";
		String respuesta = "";
        ResultSet tr;
        
		String query = "SELECT Sucursal.claveSucursal, Sucursal.nombre, Sucursal.direccion, Producto.claveProducto, Producto.nombre FROM Tiene JOIN Producto ON Tiene.numeroProducto = Producto.claveProducto JOIN Sucursal ON Tiene.numeroSucursal = Sucursal.claveSucursal WHERE numeroSucursal = "+sucursal;

		System.out.println(query);
        
        try{
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            
            while(tr.next()){
				String v1 = "" +tr.getInt(1);
				String v2 = tr.getString(2);
				String v3 = tr.getString(3);
				String v4 = "" +tr.getInt(4);
				String v5 = tr.getString(5);
				
				datos = v1+"_"+v2+"_"+v3+"_"+v4+"_"+v5+"\n";
				respuesta = respuesta + datos;
                // System.out.println(respuesta);
            } 
            statement.close();
            //System.out.println("\nAD: "+datos);
        }catch(SQLException sqle){
            respuesta = "Error consultar los productos de una sucursal "+sqle;
        }
        return respuesta;
    }
/* Productos en una sucursal */
    String consultarSucursalProducto(int producto) {
		String datos = "";
		String respuesta = "";
        ResultSet tr;
        
		String query = "SELECT Tiene.numeroSucursal, Tiene.numeroProducto, Producto.nombre, Producto.marca, Producto.cantidad, Producto.precio FROM Tiene JOIN Producto ON Tiene.numeroProducto = Producto.claveProducto JOIN Sucursal ON Tiene.numeroSucursal = Sucursal.claveSucursal JOIN Localidad ON Sucursal.claveSucursal = Localidad.claveSucursa WHERE claveProducto = "+ producto;
		System.out.println(query);
        
        try{
            statement = conexion.createStatement();
            tr = statement.executeQuery(query);
            
            while(tr.next()){
				String v1 = "" +tr.getInt(1);
				String v2 = "" +tr.getInt(2);
				String v3 = tr.getString(3);
				String v4 = tr.getString(4);
				String v5 = "" +tr.getInt(5);
				String v6 = "" +tr.getInt(5);

				
				datos = v1+"_"+v2+"_"+v3+"_"+v4+"_"+v5+"_"+v6+"\n";
				respuesta = respuesta + datos;
                // System.out.println(respuesta);
            } 
            statement.close();
            //System.out.println("\nAD: "+datos);
        }catch(SQLException sqle){
            respuesta = "Error consultar los productos de una sucursal "+sqle;
        }
        return respuesta;
    }
}
