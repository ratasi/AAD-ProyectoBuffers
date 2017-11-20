package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GestionDatos {

	public GestionDatos() {

	}
	
	//TODO: Implementa una función para abrir ficheros	
	//TODO: Implementa una función para cerrar ficheros
	public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
	      String cadena;
	      FileReader f = new FileReader(archivo);
	      BufferedReader b = new BufferedReader(f);
	      while((cadena = b.readLine())!=null) {
	          System.out.println(cadena);
	      }
	      b.close();
	}
	
	public boolean compararContenido(String fichero1, String fichero2){
		if (fichero1.equals(fichero2)) {
			System.out.println("Iguales");
			return true;
		}else {
			System.out.println("No son iguales");
			return false;
		}	

	}
	//Hay que hacer dos casos uno este y si es false(en la funcion buscarPalabra de GestionEventos)
	//hay que hacer otro tipo de while para leer la ultima palabra
	public int buscarPalabra(String fichero1, String palabra, boolean primera_aparicion)
			throws FileNotFoundException, IOException {
		// TODO: Implementa la función

		FileReader fr = new FileReader(fichero1);

		
		BufferedReader b = new BufferedReader(fr);
		String palabraLeida;
		int contador = 0;
		int ultima_encontrada=0;
		while ((palabraLeida = b.readLine()) != null) {

			contador++;
			if (palabraLeida.compareTo(palabra) == 0) {
				System.out.println("Son iguales, en la linea" + contador);
				//Esto actualiza la ultima linea encontrada
				ultima_encontrada=contador;

				if (primera_aparicion == true) {
					return contador;
				}

			}

		}

		b.close();

		//nos pasa la ultima linea encontrada
		return ultima_encontrada;
	}	

}
