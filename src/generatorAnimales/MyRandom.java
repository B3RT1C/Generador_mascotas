package generatorAnimales;

import java.time.LocalDate;
import java.util.Random;

import util.AgeCalculator;
import util.Constants;

/**
 * Contiene metodos utiles que generan informacion aleatoria sobre las mascotas o la seleccionan aleatoriamente de {@link Constants}<br>
 * Clase usada primariamente por {@link Generator}
 * @since 1.0
 * @see Constants
 * @see <a href="../constant-values.html">Valores de las constantes</a>
 */
public class MyRandom {
	/**
	 * Objeto Random usado en las clases {@link Generator} y {@link MyRandom}
	 */
	protected static Random rand = new Random();

	/**
	 * Constructor privado ya que la clase esta pensada para ser usada de manera estatica
	 */
	private MyRandom() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Genera un nombre aleatorio
	 * @return String de longitud 10 usando [A-Z]
	 */
	public static String randomName() {
		String name = ""+(char)MyRandom.rand.nextInt(65, 90 + 1);
		
		for (int i = 0; i < 9; i++) {
			name += (char)MyRandom.rand.nextInt(65, 90 + 1);
		}
		
		return name;
	}
	
	/**
	 * Genera una fecha de nacimineto para la mascota 1900 - now()
	 * @return String con la fecha en el formato [year-month-day] en numeros
	 */
	public static String randomStringDate() {
		int year = MyRandom.rand.nextInt(1900, LocalDate.now().getYear());
		
		int m = MyRandom.rand.nextInt(1, 12 + 1);
		String month = m < 10? 0+""+m : String.valueOf(m);
		
		int d = MyRandom.rand.nextInt(1, 28 + 1);
		String day = d < 10? 0+""+d : String.valueOf(d);
		
		
		return year + "-" + month + "-" + day;
	}
	
	/**
	 * Selecciona un tipo de mascota aleatorio
	 * @return String con un tipo de mascota de {@link Constants#petType}
	 * @see Constants#petType
	 */
	public static String randomPetType() {
		return Constants.petType[MyRandom.rand.nextInt(0, Constants.petType.length)];
	}
	
	/**
	 * Selecciona un color aleatorio para la mascota
	 * @return String con un color de {@link Constants#petColor}
	 * @see Constants#petColor
	 */
	public static String randomPetColor() {
		return Constants.petColor[MyRandom.rand.nextInt(0, Constants.petColor.length)];
	}
	
	/**
	 * Selecciona un estado aleatorio para la mascota<br>
	 * Contiene una variable showMuerto(True) la cual permite o no modificar el programa para que se escriban datos de animales con este estado en el archivo
	 * @return String con un estado de  {@link Constants#petState}
	 * @see Constants#petState
	 */
	public static String randomPetState() {
		String state;
		Boolean showMuerto = true;
		
		if (!showMuerto) {
			do {
				state = Constants.petState[MyRandom.rand.nextInt(0, Constants.petState.length)];
			} while(!state.equals("Muerto"));
		
		} else {
			state = Constants.petState[MyRandom.rand.nextInt(0, Constants.petState.length)];
		}
		
		return state;
	}
	
	/**
	 * Selecciona una raza de perro aleatoria para la mascota de tipo perro
	 * @return String con una raza de perro de {@link Constants#dogBreed}
	 * @see Constants#dogBreed
	 */
	public static String randomDogBreed() {
		return Constants.dogBreed[MyRandom.rand.nextInt(0, Constants.dogBreed.length)];
	}
	
	/**
	 * Selecciona un origen aleatorio para la mascota de tipo loro
	 * @return String con un origen de {@link Constants#parrotOrigin}
	 * @see Constants#parrotOrigin
	 */
	public static String randomParrotOrigin() {
		return Constants.parrotOrigin[MyRandom.rand.nextInt(0, Constants.parrotOrigin.length)];
	}
	
	/**
	 * Genera un array con todos los datos comunes a todas las mascotas
	 * @return Array de String con [nombre] [Edad] [Estado] [Fecha de Nacimiento]
	 * @see AgeCalculator#calculate(String)
	 */
	public static String[] randomMascotaVariables() {
		String name = randomName();
		String age;
		String state = randomPetState();
		String birthDate = randomStringDate();
		
		age = AgeCalculator.calculate(birthDate);
		
		return new String[]{name,age,state,birthDate};
	}
	
	/**
	 * Genera un array con todos los datos comunes a todos los perros
	 * @return Array de String con [raza] [pulgas?]
	 */
	public static String[] randomPerroVariables() {
		String breed = randomDogBreed();
		String fleas = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{breed,fleas};
	}
	
	/**
	 * Genera un array con todos los datos comunes a los gatos
	 * @return Array de String con [color] [peloLargo?]
	 */
	public static String[] randomGatoVariables() {
		String color = randomPetColor();
		String longHair = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{color,longHair};
	}
	
	/**
	 * Genera un array con todos los datos comunes a las aves
	 * @return Array de String con [pico?] [vuela?]
	 */
	public static String[] randomBirdVariables() {
		String beak = String.valueOf(MyRandom.rand.nextBoolean());
		String flies = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{beak,flies};
	}
	
	/**
	 * Genera un array con todos los datos comunes a los loros
	 * @return Array de String con [origen] [habla?]
	 */
	public static String[] randomLoroVariables() {
		String origin = randomParrotOrigin();
		String talks = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{origin,talks};
	}
	
	/**
	 * Genera un array con todos los datos comunes a los canarios
	 * @return Array de String con [color] [canta?]
	 */
	public static String[] randomCanarioVariables() {
		String color = randomPetColor();
		String sings = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{color,sings};
	}

}