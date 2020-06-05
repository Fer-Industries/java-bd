import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexionBD{

	Connection conexion;

	ConexionBD(){

		System.out.println("Empezando la conexion");
		try{

			Class.forName("com.mysql.cj.jdbc.Driver");//Obtiene el driver
			//recuerden que aqui tienen que poner su usuario y contraseña al final de la liga
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/northwind?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false&" +"user=root&password=shield");

			if(conexion != null)
				System.out.println("Success Conecction");
				else
					System.out.println("Failed Conecction");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("El error es "+ cnfe.getMessage());
		}
		catch(SQLException sqle){
			System.out.println("El error es " +sqle.getMessage() );
		}
	}

	Connection getConnection(){
		return conexion;
	}

}
