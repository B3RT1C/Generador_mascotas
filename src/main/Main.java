package main;

import java.io.File;
import java.io.IOException;

import generatorAnimales.Generator;
import util.Constants;

/**
 * <a href="https://github.com/B3RT1C/Generador_mascotas/tree/main">Proyecto Github</a><br>
 * Genera un archivo con un numero aleatorio de "Mascotas"<br>
 * Escribira una linea por mascota<br>
 * Cada linea tiene la siguiente estructura dependiendo del tipo de mascota:<br>
 * -Perro [Nombre] [Edad] [Estado] [FechaNacimiento] [Raza] [Pulgas?]<br>
 * -Gato [Nombre] [Edad] [Estado] [FechaNacimiento] [Color] [PeloLargo?]<br>
 * -Loro [Nombre] [Edad] [Estado] [FechaNacimiento] [Pico?] [Vuela?] [Origen] [Habla?]<br>
 * -Canario [Nombre] [Edad] [Estado] [FechaNacimiento] [Pico?] [Vuela?] [Color] [Habla?]<br>
 * @author b3rt1c
 * @version 1.0
 */
public class Main {
	/**
	 * Bucle principal del programa, contiene la variable name con el nombre candidato para el archivo a crear y llama al metodo {@link Generator#generate(String)}
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String name = "Mascotas";
		
		Generator.generate(name);
		
	}
	
	/**
	 * @deprecated Movido a la clase {@link Generator}
	 * @see Generator
	 * @param fileName Nombre a verificar para su uso en la creación del nuevo archivo
	 * @return String with an unused file name
	 */
	@SuppressWarnings("unused")
	private static String validarNombre(String fileName) {
		int i = 0;
		for (File file : new File(Constants.generatorFilePath).listFiles()) {
			String aux = file.getName().substring(0, file.getName().length() - 4);
			
			if (fileName.equals(aux)) {
				i++;
				if (i == 1) {
					fileName = fileName + i;					
				} else {
					fileName = fileName.substring(0, fileName.length() - String.valueOf(i).length()) + i;					
				}
			}
		}
		
		return fileName;
	}
}