package util;

import java.time.LocalDate;

/**
 * Clase usada para calcular la diferencia entre dos fechas dadas en String con el formato [year-month-day] en numeros
 * @since 1.0
 * @see Constants
 * @see <a href="../constant-values.html">Valores de las constantes</a>
 */
public class AgeCalculator {
	/**
	 * Constructor privado ya que la clase esta pensada para ser usada de manera estatica
	 */
	private AgeCalculator() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Calcula la diferencia entre dos fechas<br>
	 * Este metodo es usado principalmente para calcular la edad de las mascotas<br>
	 * @param birthDate Fecha de nacimiento de la mascota en formato [year-month-day] en numeros
	 * @return Edad de la mascota contenida en una variable de tipo String
	 */
	public static String calculate(String birthDate) {
		LocalDate date = LocalDate.parse(birthDate);
		
		int birthdayDayOfYear = date.getDayOfYear();
		int birthdayYear = date.getYear();
		
		date = LocalDate.now();
		
		int todayDayOfYear = date.getDayOfYear();
		int todayYear = date.getYear();
		
		int age = todayDayOfYear <= birthdayDayOfYear? todayYear - birthdayYear : todayYear - birthdayYear - 1;
		
		return String.valueOf(age);
	}
}