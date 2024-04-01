package main;

import java.io.File;
import java.io.IOException;

import generatorAnimales.Generator;
import util.Constants;

public class Main {
	public static void main(String[] args) throws IOException {
		
		String name = validarNombre("mascotas");
		
		Generator.generate(name);
		
	}
	
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