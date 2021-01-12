package com.clientes;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.clases.Clientes;
import com.clases.Producto;


public class Main {
	
	
    public static void main(String[] args) {
    	
    	int indice = -1;
    	boolean encontrado = false;
        String menu =
                        "         * 1 Agregar cliente\n" +
                        "         * 2 Editar cliente\n" +
                        "         * 3 Eliminar cliente\n" +
                        "         * 4 Agregar productos\n" +
                        "         * 5 Consultar clientes con documento y nombre \n" +
                        "         * 0 salir de la aplicacion";
        Scanner in = new Scanner(System.in);
        
        ArrayList<Clientes> vectorClientes = new ArrayList<Clientes>();
        ArrayList<Producto> productoAseo = new ArrayList<Producto>();
        ArrayList<Producto> productoMercado = new ArrayList<Producto>();
        ArrayList<Producto> productoverdura = new ArrayList<Producto>();


        //Uso clico do while() para iniciar menu
        @Deprecated(since = "1.2", forRemoval = true)
        Integer opMenu = new Integer(0);
        /**
         * Segun el concepto de polimorfismo un objeto puede tener multiples formas
         * con la estructura de clase que se entrega por favor implementar el concepto de poliformismo
         */


        do {

            System.out.println(menu);
            opMenu = in.nextInt();
            switch (opMenu.toString()) {
                case "1":
                	
                	Clientes cliente = setClientes(productoAseo, productoMercado, productoverdura );
    				vectorClientes.add(cliente);	
    				
                    break;
                case "2":
                	System.out.println("Ingrese cedula del cliete a Editar: ");
                	String cedBusc = in.next();
                
					
					for (int i = 0; i < vectorClientes.size(); i++) {
						
						Clientes auxCliente = vectorClientes.get(i);
						
						if (cedBusc.equalsIgnoreCase(auxCliente.getCedula())) {
							System.out.println("Cliente a editar encontrado :");
							System.out.println("Nombre: " + auxCliente.getNombre());
							System.out.println("Cedula: " + auxCliente.getCedula());			
							encontrado = true;
							indice = i; 
							
						}
							
					}
					
					if (encontrado == true) {
                		System.out.println("Ingrese los datos del cliente a editar");
						Clientes clienteEdit = setClientes(productoAseo, productoMercado, productoverdura );
                	    vectorClientes.set(indice, clienteEdit);
                		System.out.println("Cliente actualizado correctamente");
					}
                	else {
                		System.out.println("Cliente No encontrado");
                	}

                    break;
                case "3":
                	
                	System.out.println("Ingrese cedula del cliente que desea eliminar: ");
                	String cedEli = in.next();
                	
					
					for (int i = 0; i < vectorClientes.size(); i++) {
						
						Clientes auxCliente = vectorClientes.get(i);
						
						if (cedEli.equalsIgnoreCase(auxCliente.getCedula())) {
							System.out.println("Cliente a Eliminar es :");
							System.out.println("Nombre: " + auxCliente.getNombre());
							System.out.println("Cedula: " + auxCliente.getCedula());			
							encontrado = true;
							indice = i; 
							
						}
							
					}
					
					if (encontrado == true) {
                	    vectorClientes.remove(indice);
                		System.out.println("Cliente Eliminado correctamente");
					}
                	else {
                		System.out.println("Cliente a eliminar no encontrado");
                	}

                    break;
                case "4":
                	String clasProd =
                    "         * 1. Si desea agregar producto aseo\n" +
                    "         * 2. Si desea agregar producto de mercado\n" +
                    "         * 3. Si desea agregar producto de verduras ";
                	
                	
                	System.out.println(clasProd);
                	int prod = Integer.parseInt(in.next());
                	
                	if (prod == 1) {
                		
                		Producto prodAseo = SetProductos();
                		productoAseo.add(prodAseo);
                	  		
                	}
                	else if(prod == 2) {
                		
                		Producto prodMerc = SetProductos();
                		productoMercado.add(prodMerc);
                	}
                	else if(prod == 3)
                	{
                		Producto prodVer = SetProductos();
                		productoverdura.add(prodVer);
                		
                	}
                	else {
                		System.out.println("Opción Invalida");
                	}
                	
                    break;
                case "5":
                	System.out.println("Ingrese cedula de cliente a buscar: ");
                	String cedConsu = in.next();
                	System.out.println("Ingrese nombre de cliente a buscar: ");
                	String nombreCons = in.next();
                	encontrado = false;
					
					for (int i = 0; i < vectorClientes.size(); i++) {
						
						Clientes auxCliente = vectorClientes.get(i);
						
						if (cedConsu.equalsIgnoreCase(auxCliente.getCedula()) || nombreCons.equalsIgnoreCase(auxCliente.getNombre())) {
	                		System.out.println("Cliente encontrado sus datos son:");
	                		System.out.println("Cedula: " + auxCliente.getCedula());
							System.out.println("Nombre: " + auxCliente.getNombre());
							System.out.println("Celular: " + auxCliente.getCelular());
							System.out.println("Telefono: " + auxCliente.getTelefono());
							System.out.println("Dirección: " + auxCliente.getDireccion());
							System.out.println("Los productos del cliente son: \n ");
							
							for (int j = 0; j < auxCliente.getProductos().size(); j++) {
								
								Producto auxProducto = auxCliente.getProductos().get(j);
								System.out.println("Id producto " +auxProducto.getIdProducto());
								System.out.println("Nombre producto " +auxProducto.getNombre());
								System.out.println("Carateristicas producto " +auxProducto.getCarateristicas());
								System.out.println("Condiciones Producto " +auxProducto.getCondiciones());
							}
							
							encontrado = true;
							indice = i; 
							
						}
					}
					

					if (!encontrado) {
						System.out.println("Cliente No encontrado");
					}
                	
                    break;
                case "0":
                    System.out.println("Muchas gracias por usar nuestra app, hasta luego");
                    break;
                default:
                    System.out.println("El valor ingresado no es una opcion de menu");
                    break;
            }
        } while (!opMenu.toString().equals("0"));
        in.close();

    }
    
    
    public static Producto SetProductos(){
        
        Scanner in = new Scanner(System.in);
        Producto productos = new Producto();
        
    	System.out.println("Ingrese id producto: ");
		String idProducto = in.next();
		productos.setIdProducto(idProducto);
		
    	System.out.println("Ingrese nombre del producto: ");
		String nombreProducto = in.next();
		productos.setNombre(nombreProducto);
		
    	System.out.println("Ingrese caracteristica del producto: ");
		String carateristicas = in.next();
		productos.setCarateristicas(carateristicas);
		
    	System.out.println("Ingrese condiciones del producto: ");
		String condiciones = in.next();
		productos.setCondiciones(condiciones);
		
    	System.out.println("Ingrese documento de la empresa del producto: ");
		String documEmpre = in.next();
		productos.setDocumento(documEmpre);
		
    	System.out.println("Ingrese tipo de documento empresa del producto: ");
		String tipDoc = in.next();
		productos.setTipDoc(tipDoc);
		
    	System.out.println("Ingrese representante empresa del producto: ");
		String representante = in.next();
		productos.setRepresentante(representante);
	
		return(productos);
    }
    
    public static Clientes setClientes(ArrayList<Producto> aseo, ArrayList<Producto>  mercado, ArrayList<Producto>  verdura){
        
        Scanner in = new Scanner(System.in);
        Clientes cliente = new Clientes();
        
        System.out.println("Ingrese Cedula del cliente ");
		String cedula = in.next();
		cliente.setCedula(cedula);
		
    	System.out.println("Ingrese nombre del cliente ");
		String nombre = in.next();
		cliente.setNombre(nombre);
		
    	System.out.println("Ingrese celular del cliente ");
		String celular = in.next();
		cliente.setCelular(celular);
		
    	System.out.println("Ingrese dirección del cliente ");
		String direccion = in.next();
		cliente.setDireccion(direccion);

    	System.out.println("Ingrese telefono del cliente ");
		String telefono = in.next();
		cliente.setTelefono(telefono);
		
    	String clasProdCli =
                "         * 1. Si Desea agregar producto aseo\n" +
                "         * 2. Si desea agregar producto de mercado\n" +
                "         * 3. Si desea agregar producto de verduras ";
            	
           
        System.out.println(clasProdCli);
        int prodCli = Integer.parseInt(in.next());
        
        if (prodCli == 1) {
        	
    		cliente.setProductos(aseo);
    	  		
    	}
    	else if(prodCli == 2) {
    		
    		cliente.setProductos(mercado);
    	}
    	else if(prodCli == 3)
    	{
    		cliente.setProductos(verdura);
    		
    	}
    	else {
    		System.out.println("Opción Invalida");
    	}
        
        return(cliente);
    }
    	
            	
   }
    
