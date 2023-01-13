 
public class Proyecto3 {
	
	static Proyecto3 objeto = new Proyecto3();
	static grid g;
	
	public static void menu(){
		//impresion de las indicaciones del desafio
		System.out.println("\n");
		System.out.println("DESAFIO:");
		System.out.println("Usted tendra una cuadricula de 3x3 posiciones debe ingresar los datos de manera tal que la suma horizontal,");
		System.out.println("vertical y diagonalmente resulten 15, solo puede ingresar numeros del 1 al 9 y no se deben repetir");
		System.out.println("Se le imprimira el cuadro para que pueda observar la posicion donde ira colocando los numeros");
		System.out.println("RECOMENDACION: coloque el 5 en el centro");
		g.entrada();
	}
    
    public static void main(String[] args) {
    	objeto.menu();
    }
}
