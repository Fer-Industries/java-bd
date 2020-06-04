
import java.sql.*;
/*
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/
class Dao{

	Connection mysqlc;

	public Dao(){
		ConexionBD  conexionBD = new ConexionBD();
		mysqlc = conexionBD.getConnection();
	}


	public void  menorVendedor(int fecha){

		String ejecutar = ("{call empMenosVentas1_0(?)}");
		try{
			int b=0;
			CallableStatement cstmt = mysqlc.prepareCall(ejecutar);
			cstmt.setInt(1,fecha);
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()){
				System.out.println("\nEl empleado que menos vendio en la fecha de "+fecha+
								   "\nFue: "+rs.getString("nombre")+
								   "\ncon la cantidad de: "+rs.getInt("ventas")+" ventas");
				b++;
			}
			if(b==0) System.out.println("No se encontro nada relacionado a su busqueda") ;
		}
		catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle);
		}
	}

	public void showMaxShipper(){
		String proc = "{ call getMaxShipper() }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("ShipVia") + " " + rs.getString("CompanyName") +" "   + rs.getInt("Entregas"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());
		}
	}

	public void showMinShipper(){
		String proc = "{ call getMinShipper() }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("ShipVia") + " " +rs.getString("CompanyName") +" "  + rs.getInt("Entregas"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());
		}
	}

	public void productoMasVendidoXYear(int anio_solicitado){
		String proc = "{ call masVendido(?) }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ctmt.setInt(1,anio_solicitado);
			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println("El producto mas vendido es " + "'"+rs.getString("ProductName")+"'" + " con un total de ventas de: " + rs.getString("cantidad"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());
		}
	}


    public void showProductoMenosVendido(int anio){
		String proc = "{ call showProductoMenosVendido(?) }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ctmt.setInt(1,anio); // como asignas valores al proc.


			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println("ID: " + rs.getString("ProductID"));
				System.out.println("Nombre: " + rs.getString("ProductName"));
				System.out.println("Unidades vendidas: " + rs.getString("NUM"));
				
			}

		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());	
		}
	}	


	public void ShowClientes(int year){
		String proc = "{ call obteberCliente(?) }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ctmt.setInt(1,year); // como asignas valores al proc.


			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println("El cliente con mas compras es:  " + rs.getString("CustomerID"));


			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());	
		}
	}


	public void showTerritories(){
		String sqlSelect = "select TerritoryID, territoryDescription from territories order by TerritoryID desc;";
		
		try{
			Statement stmt = mysqlc.createStatement(); 			
			ResultSet rs = stmt.executeQuery(sqlSelect); 
			while(rs.next()){			
				System.out.println("ID territorio " + rs.getString("TerritoryID" ));
				System.out.println("Nombre Territorio " + rs.getString("territoryDescription"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL "+ sqle.getMessage());
		}
	}

	public void insertarEmpleado(Empleado empleado){
		String proc = "{ call agregarEmpleado(?,?,?) }";
		try{
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ctmt.setString(1,empleado.getLastName());
			ctmt.setString(2,empleado.getFirstName());
			ctmt.setString(3,empleado.getTerritoryId());
			ResultSet rs = ctmt.executeQuery();
			while(rs.next()){
				System.out.println("Se ha creado el empleado " + rs.getString("FirstName"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL " + sqle.getMessage());	
		}
	}

	public void nuevoProducto(Producto productoNuevo){
	String proc ="{ call addProduct(?,?,?,?,?,?,?,?,?) }";
		try {
			CallableStatement ctmt = mysqlc.prepareCall(proc);
			ctmt.setString(1,productoNuevo.getProduct_Name() );
			ctmt.setInt(2,productoNuevo.getSupplier_ID());
			ctmt.setInt(3,productoNuevo.getCategory_ID());
			ctmt.setString(4,productoNuevo.getQuantityper_Unit());
			ctmt.setDouble(5,productoNuevo.getUnit_Price());
			ctmt.setShort(6,productoNuevo.getUnits_In_Stock());
			ctmt.setShort(7,productoNuevo.getUnits_On_Order());
			ctmt.setShort(8,productoNuevo.getReorder_Level() );
			ctmt.setByte(9,productoNuevo.getNew_Discontinued());

			ResultSet rs = ctmt.executeQuery();
			while (rs.next()){
				System.out.println("El producto agregado es: "+rs.getString("ProductName")+ " su categoria es: "+
					rs.getInt("CategoryID")+" y su proveedor es: "+ rs.getInt("SupplierID"));
			}
		}catch(SQLException sqle){
			System.out.println("Error de SQL "+ sqle.getMessage());
		}

	}

}


