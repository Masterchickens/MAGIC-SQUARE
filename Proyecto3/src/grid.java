import java.util.Scanner;

class grid {
	
	static grid g= new grid();
	static Proyecto3 objeto;
	static int [][] cuadro = new int [3][3];
	static Scanner sc = new Scanner(System.in);
	
	//entrada para las posiciones de la matriz
	public static void entrada(){
		System.out.println("Se ingresaran de fila en fila");
		System.out.println("\n");
		System.out.println("Cuadro: ");
		System.out.println("Usted empieza a llenar en la casilla que esta al lado del asterisco");
		System.out.print("*");
		g.cuadro();
		
		//recorrido por la matriz
		for(int x=0;x<cuadro.length;x++){
			for(int y=0;y<cuadro.length;y++){
				
				System.out.println("Ingrese el numero para esta posicion");
				int dato= sc.nextInt();
				
				//para controlar que el numero solo este del 1 al 9
				while(dato<1 || dato>9){
					System.out.println("ERROR: solo numeros del 1 al 9 ");
					System.out.println("Intenta con otro numero");
					dato=sc.nextInt();
				}
				
				int m=0;
				
				
				do{
					
					//recorrido para verificar que no repitan los numeros de la matriz
					for(int d=0;d<cuadro.length;d++){
						for(int c=0;c<cuadro.length;c++){
							
							//condicional si el dato que ingreso el usuario es igual al que ya esta en la posicion recorrida
							if(dato==cuadro[d][c]){
								
								do{
									
									//si en la posicion actual esta el mismo numero que ingreso el usuario se vuelve a leer otro numero
									System.out.println("CUIDADO: no puedes repetir los numeros");
									System.out.println("Intenta con otro numero");
									dato=sc.nextInt();
									
									//para verificar que el numero que ingrese nuevamente sea solo del 1 al 9
									while(dato<1 || dato>9){
										System.out.println("ERROR: solo numeros del 1 al 9 ");
										System.out.println("Intenta con otro numero");
										dato=sc.nextInt();
									}
									
								}while(dato==cuadro[d][c]); //termina hasta que el usuario ingrese un numero que no se repita
								
							}
							else
								m++; //si el numero no es igual al de la posicion se incrementa para
									//cumplir con el while de las nueve posiciones ya recorridas en la matriz
						}
					}
					
				}while(m==9);//sale del bucle hasta que se recorran las 9 posiciones de la matriz
				
				//cuando se verifique que cumpla todas las condiciones, el dato sera finalmente asignado a la posicion
				cuadro[x][y]=dato;
				
				//le muestra como va el cuadro con los datos
				System.out.println("\n");
				System.out.println("De esta forma va su cuadro");
				g.cuadro();
								
			}
		}
		
		//le muestra como quedo el cuadro finalmente 
		System.out.println("\n");
		System.out.println("Asi quedo el cuadro con sus datos ingresados");
		g.cuadro();
		g.verificar();
	}
	
	//para imprimir el cuadro para que el usuario sepa donde va insertando
	public static void cuadro(){
		
		for(int x=0 ; x<cuadro.length ; x++){
			
			for(int y=0 ; y<cuadro.length ; y++){
				
				//le asigna el valor de 0 incialmente para indicarle al usuario que la posicion esta vacia
				if(cuadro[x][y]<=0){
					cuadro[x][y]=0;	
				}
				System.out.print(cuadro[x][y]+"	");
			}
		System.out.println("");	
		}
		
	}
	
	//verificador para saber si el usuario completo o no el desafio con la matriz que ingreso
	public static void verificar(){
		int sumah0=cuadro[0][0]+cuadro[0][1]+cuadro[0][2];
		int sumah1=cuadro[1][0]+cuadro[1][1]+cuadro[1][2];
		int sumah2=cuadro[2][0]+cuadro[2][1]+cuadro[2][2];
		int sumav0=cuadro[0][0]+cuadro[1][0]+cuadro[2][0];
		int sumav1=cuadro[0][1]+cuadro[1][1]+cuadro[2][1];
		int sumav2=cuadro[0][2]+cuadro[1][2]+cuadro[2][2];
		int sumad1=cuadro[0][0]+cuadro[1][1]+cuadro[2][2];
		int sumad2=cuadro[2][0]+cuadro[1][1]+cuadro[0][2];
		int suma=sumah0+sumah1+sumah2+sumav0+sumav1+sumav2+sumad1+sumad2;
		
		System.out.println("\n");
		
		//mensajes que se imprimen si el usuario completo el desafio
		if( (sumah0==15) && (sumah1==15) && (sumah2==15) && (sumav0==15) && (sumav1==15) && (sumav2==15) && (sumad1==15) && (sumad2==15)){
			System.out.println("FELICIDADES!");
			System.out.println("Usted ha completado exitosamente el desafio");
			System.out.println("Todas las filas, columnas y diagonales suman 15");
			System.out.println("Gracias por jugar!");
		}
		//mensajes que se imprimen si el usuario no completo el desafio y le da la oportunidad para intentarlo nuevamente
		else{
			System.out.println("LO SENTIMOS");
			System.out.println("No ha completado exitosamente el desafio");
			System.out.println("No todas las filas, columnas y diagonales suman 15");
			System.out.println("\n");
			System.out.println("Desea intentarlo nuevamente?");
			System.out.println("Presione 1 para otro intento");
			System.out.println("Presione otro numero para salir");
			int opc= sc.nextInt();
			if(opc==1){
				//reinicia la matriz para el nuevo intento
				for(int x=0 ; x<cuadro.length ; x++){
					for(int y=0 ; y<cuadro.length ; y++){
						cuadro[x][y]=0;	
					}
				}
				//llamado nuevamente al menu para nuevo intento
				objeto.menu();
			}
			else{
				System.out.println("\n");
				System.out.println("Gracias por jugar!");
				System.out.println("Fin del programa");
			}	
		}
		
	}
	
	
}
