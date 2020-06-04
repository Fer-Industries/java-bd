import java.util.Scanner;

public class Principal{
	public static void main(String [] args){
		Dao crud = new Dao();
		int opcion = 1;
		do{
			System.out.println("\nNuestro primer proyecto de Java con Base de Datos");
			System.out.println("1.- Cliente con mas compras por año");
			System.out.println("2.-Producto mas vendido por year ");
			System.out.println("3.-Producto(s) menos vendido por año ");
			System.out.println("4.- Fabian");
			System.out.println("6.-Empleado que menos ha vendido por a\u00f1o ");
			System.out.println("7.- Agregar producto");
			System.out.println("8.-Repartidores que mas envios ha hecho y menos envios ha hecho");
			System.out.println("9.- Insertar empleado");
			System.out.println("0.- Salir del programa");
			System.out.println("Brinde una opcion por favor ");
			Scanner sc = new Scanner(System.in);


			opcion = sc.nextInt();

			switch(opcion){
				case 1:

				System.out.println("Introduzaca el año que desea obtener");	
				crud.ShowClientes(sc.nextInt());


				break;
				case 2:
				System.out.println("Dame el anio que deseas buscar sus ventas: ");
				crud.productoMasVendidoXYear(sc.nextInt());


				break;

                case 3: 
                    System.out.println("Ingrese el anio a buscar"); 
                    crud.showProductoMenosVendido(sc.nextInt());
                    System.out.println("------------------------------");

                break;

				case 6:
					System.out.println("\nDe que a\u00f1o quiere saber el empleado que ha vendio menos");
					crud.menorVendedor(sc.nextInt());
				break;
				case 7:
					Scanner scann = new Scanner(System.in);
					Producto productoNuevo = new Producto();
					System.out.println("Dame el nombre del producto: ");
					productoNuevo.setProduct_Name(scann.nextLine());
					System.out.println("Dame el ID proveedor: ");
					productoNuevo.setSupplier_ID(scann.nextInt());
					System.out.println("Dame la ID categoria: ");
					productoNuevo.setCategory_ID(scann.nextInt());
					System.out.println("Dame la tipo de cantidad: ");
					scann  = new Scanner(System.in);
					productoNuevo.setQuantityper_Unit(scann.nextLine());
					System.out.println("Dame el precio por unidad: ");
					productoNuevo.setUnit_Price(scann.nextDouble());
					System.out.println("Dame las unidades en stock: ");
					productoNuevo.setUnits_In_Stock(scann.nextShort());
					short temporal = 0;
					productoNuevo.setUnits_On_Order(temporal);
					productoNuevo.setReorder_Level(temporal);
					byte f = 0;
					f = 0xa;
					productoNuevo.setNew_Discontinued(f);
					crud.nuevoProducto(productoNuevo);

				break;
				case 8:
					System.out.println("El repartidor com mas entregas es:");
					crud.showMaxShipper();
					System.out.println("El repartidor con menos entregas es:");
					crud.showMinShipper();
				break;
				case 9:
					Scanner scan = new Scanner(System.in);
					crud.showTerritories();

					Empleado empleadoCrear = new Empleado();
					System.out.println("Dame el apellido del empleado");
					empleadoCrear.setLastName(scan.nextLine());
					System.out.println("Dame el nombre del empleado");
					empleadoCrear.setFirstName(scan.nextLine());
					System.out.println("Dame el territorio del empleado");
					empleadoCrear.setTerritoryId(scan.nextLine());
					
					crud.insertarEmpleado(empleadoCrear);
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
