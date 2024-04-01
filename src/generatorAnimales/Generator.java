package generatorAnimales;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import util.Constants;

/**
 * Contiene todos los metodos para crear un archivo y escribir en el los datos generados por {@link MyRandom}
 * @since 1.0
 * @see MyRandom
 */
public class Generator {
	/**
	 * Constructor privado ya que la clase esta pensada para ser usada de manera estatica
	 * @see Generator#generate(String)
	 */
	private Generator() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Llama a los metodos {@link #validateFileName(String)}, {@link #createFile(String)} y {@link #fillFile(FileWriter)}
	 * @param fileName Nombre del archivo a crear
	 * @return String con la ruta absoluta donde se ha creado el archivo
	 * @throws IOException
	 */
	public static String generate(String fileName) throws IOException {
		
		fileName = validateFileName(fileName);
		
		File file = createFile(fileName);
		
		fillFile(new FileWriter(file));
		
		return file.getAbsolutePath();
	}
	
	/**
	 * Crea un archivo con la ruta de {@link Constants#generatorFilePath} el fileName recibido en {@link #generate(String)} y la extension del archivo de {@link Constants#generatorFileExtension}
	 * @param name
	 * @return
	 * @throws IOException
	 * @see Constants
	 * @see <a href="../constant-values.html">Valores de las constantes</a>
	 */
	private static File createFile(String name) throws IOException {
		File file = new File(Constants.generatorFilePath + name + Constants.generatorFileExtension);
		
		if (!file.exists()) {
			file.createNewFile();
		}
		
		return file;
	}
	
	/**
	 * Escribe de {@link Constants#minGeneratedPets} a {@link Constants#maxGeneratedPets} lineas<br>
	 * Cada linea tendra una cantidad diferente de datos depentiendo del tipo de mascota recogido en {@link Constants#petType}
	 * @param writer
	 * @throws IOException
	 * @see Constants
	 * @see <a href="../constant-values.html">Valores de las constantes</a>
	 */
	private static void fillFile(FileWriter writer) throws IOException {
		int petAmpunt = MyRandom.rand.nextInt(Constants.minGeneratedPets, Constants.maxGeneratedPets + 1);

		for (int i = 0; i < petAmpunt; i++) {
			String type = MyRandom.randomPetType();
			writer.write(type+" ");
			
			String[] mascotaVariables = MyRandom.randomMascotaVariables();
			writer.write(mascotaVariables[0]+" "+mascotaVariables[1]+" "+mascotaVariables[2]+" "+mascotaVariables[3]+" ");
			
			String[] variables;
			String[] variablesBird;
			
			switch (type) {
				case "Perro": {
					 variables = MyRandom.randomPerroVariables();
					writer.write(variables[0]+" "+variables[1]);
					
					break;
				}
				case "Gato": {
					variablesBird = MyRandom.randomBirdVariables();
					variables = MyRandom.randomGatoVariables();
					writer.write(variablesBird[0]+" "+variablesBird[1]+" "+variables[0]+" "+variables[1]);
	
					break;
				}
				case "Loro": {
					variablesBird = MyRandom.randomBirdVariables();
					variables = MyRandom.randomLoroVariables();
					writer.write(variablesBird[0]+" "+variablesBird[1]+" "+variables[0]+" "+variables[1]);
					
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
	
	/**
	 * Revisa que el nombre del archivo a generar no este en uso<br>
	 * En el caso de que lo este se añadira un 1 al final de su nombre, si este ya esta en uso tambien, se pondra un 2 y asi sucesivamente 
	 * @param fileName Nombre el arhivo a verificar
	 * @return Nombre valido para el archivo a crear
	 */
	private static String validateFileName(String fileName) {
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