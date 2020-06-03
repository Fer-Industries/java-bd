import java.util.Scanner;

public class Principal{
	public static void main(String [] args){
		int opcion = 1;
		do{
			System.out.println("Nuestro primer proyecto de Java con Base de Datos");
			System.out.println("1.- ");
			System.out.println("2.- ");
			System.out.println("3.- ");
			System.out.println("4.- ");
			System.out.println("5.- ");
			System.out.println("6.- ");
			System.out.println("7.- ");
			System.out.println("8.- ");
			System.out.println("9.- ");
			System.out.println("0.- Salir del programa");
			Scanner sc = new Scanner(System.in);
		
			
			opcion = sc.nextInt();

			switch(opcion){
				case 1:

				break;


				case 0:
					System.out.println("Que tenga un buen dia le desea Northwind");
				break;
				
				default:
					System.out.println("Por favor introduza una opción valida");
			}
		}while(opcion != 0);
	}
}