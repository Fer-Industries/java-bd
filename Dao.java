
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
	

}