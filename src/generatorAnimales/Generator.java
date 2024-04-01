package generatorAnimales;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import util.Constants;

public class Generator {
	public static String generate(String fileName) throws IOException {
		
		File file = createFile(fileName);
		
		fillFile(new FileWriter(file));
		
		return file.getAbsolutePath();
	}
	
	private static File createFile(String name) throws IOException {
		File file = new File(Constants.generatorFilePath + name + Constants.generatorFileExtension);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		return file;
	}
	
	private static void fillFile(FileWriter writer) throws IOException {
		int petAmpunt = MyRandom.rand.nextInt(Constants.minGeneratedPets, Constants.maxGeneratedPets + 1);

		for (int i = 0; i < petAmpunt; i++) {
			String type = MyRandom.randomPetType();
			writer.write(type+" ");
			
			String[] mascotaVariables = MyRandom.randomMascotaVariables();
			writer.write(mascotaVariables[0]+" "+mascotaVariables[1]+" "+mascotaVariables[2]+" "+mascotaVariables[3]+" ");
			
			String[] variables;
			
			switch (type) {
				case "Perro": {
					 variables = MyRandom.randomPerroVariables();
					writer.write(variables[0]+" "+variables[1]);
					
					break;
				}
				case "Gato": {
					variables = MyRandom.randomGatoVariables();
					writer.write(variables[0]+" "+variables[1]);
	
					break;
				}
				case "Loro": {
					variables = MyRandom.randomLoroVariables();
					writer.write(variables[0]+" "+variables[1]);
					
					break;
				}
				case "Canario": {
					variables = MyRandom.randomCanarioVariables();
					writer.write(variables[0]+" "+variables[1]);
	
					break;
				}
			}
			if (i != petAmpunt - 1) {
				writer.write("\n");
			}
		}
		
		writer.close();
	}
}