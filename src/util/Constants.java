package util;

/**
 * Clase encargada de contener las constantes usadas en el programa
 * @since 1.0
 * @see Constants
 * @see <a href="../constant-values.html">Valores de las constantes</a>
 */
public class Constants {
	/**
	 * Constructor privado ya que la clase esta pensada para ser usada de manera estatica
	 */
	private Constants() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Contiene los tipos de mascota
	 * "Perro","Gato","Loro","Canario"
	 */
	public static final String[] petType = {"Perro","Gato","Loro","Canario"};
	
	/**
	 * Contiene los estados en los que se puede encontrar la mascota
	 * "Vivo","Enfermo","Muerto"
	 */
	public static final String[] petState = {"Vivo","Enfermo","Muerto"};
	
	/**
	 * Contiene los colores que puede tener la mascota
	 * "Marrón","Negro","Naranja","Blanco"
	 */
	public static final String[] petColor = {"Marrón","Negro","Naranja","Blanco"};

	/**
	 * Contiene todas las razas de perros
	 * "Corgi","Dachshund","Golden retriever","Pit bull","Husky"
	 */
	public static final String[] dogBreed = {"Corgi","Dachshund","Golden retriever","Pit bull","Husky"};
	
	/**
	 * Contiene los origenes que puede tener un loro
	 * "Cuba","España","El patio de mi casa","Italia","Portugal"
	 */
	public static final String[] parrotOrigin = {"Cuba","España","El patio de mi casa","Italia","Portugal"};
	
	
	/**
	 * Contiene la ruta donde se almacenara el archivo tras su generacion
	 */
	public static final String generatorFilePath = "src\\generados\\";

	/**
	 * Contiene la extension que recivira el archivo para su generacion
	 */
	public static final String generatorFileExtension = ".txt";
	
	
	/**
	 * Contiene el numero maximo de mascotas que se escribiran en el archivo
	 */
	public static final int maxGeneratedPets = 100;
	
	/**
	 * Contiene el numero minimo de mascotas que se escribiran en el archivo
	 */
	public static final int minGeneratedPets = 1;
}