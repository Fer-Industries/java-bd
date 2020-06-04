import java.util.Scanner;

public class Principal{
	public static void main(String [] args){
		Dao crud = new Dao();
		int opcion = 1;
		do{
			System.out.println("\nNuestro primer proyecto de Java con Base de Datos");
			System.out.println("1.- ");
			System.out.println("2.- ");
			System.out.println("3.- ");
			System.out.println("4.- ");
			System.out.println("5.- ");
			System.out.println("6.-Empleado que menos ha vendido por a\u00f1o ");
			System.out.println("7.- ");
			System.out.println("8.-Repartidores que mas envios ha hecho y menos envios ha hecho");
			System.out.println("9.- ");
			System.out.println("0.- Salir del programa");
			System.out.println("Brinde una opcion por favor ");
			Scanner sc = new Scanner(System.in);
		
			
			opcion = sc.nextInt();

			switch(opcion){
				case 1:

				break;

				case 6:
					System.out.println("\nDe que a\u00f1o quiere saber el empleado que ha vendio menos");
					crud.menorVendedor(sc.nextInt());
				break;
				case 8:
					System.out.println("El repartidor com mas entregas es:");
					crud.showMaxShipper();
					System.out.println("El repartidor con menos entregas es:");
					crud.showMinShipper();
				break;
				case 0:
					System.out.println("Que tenga un buen dia le desea Northwind");
					crud.menorVendedor(sc.nextInt());
				break;
				
				default:
					System.out.println("Por favor introduza una opción valida");
			}
		}while(opcion != 0);
	}
}