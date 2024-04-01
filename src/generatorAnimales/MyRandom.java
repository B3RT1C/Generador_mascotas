package generatorAnimales;

import java.time.LocalDate;
import java.util.Random;

import util.AgeCalculator;
import util.Constants;

public class MyRandom {
	public static Random rand = new Random();

	public static String randomName() {
		String name = ""+(char)MyRandom.rand.nextInt(65, 90 + 1);
		
		for (int i = 0; i < 9; i++) {
			name += (char)MyRandom.rand.nextInt(65, 90 + 1);
		}
		
		return name;
	}
	
	public static String randomStringDate() {
		int year = MyRandom.rand.nextInt(1900, LocalDate.now().getYear());
		
		int m = MyRandom.rand.nextInt(1, 12 + 1);
		String month = m < 10? 0+""+m : String.valueOf(m);
		
		int d = MyRandom.rand.nextInt(1, 28 + 1);
		String day = d < 10? 0+""+d : String.valueOf(d);
		
		
		return year + "-" + month + "-" + day;
	}
	
	public static String randomPetType() {
		return Constants.petType[MyRandom.rand.nextInt(0, Constants.petType.length)];
	}
	
	public static String randomPetColor() {
		return Constants.petColor[MyRandom.rand.nextInt(0, Constants.petColor.length)];
	}
	
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
	
	public static String randomDogBreed() {
		return Constants.dogBreed[MyRandom.rand.nextInt(0, Constants.dogBreed.length)];
	}
	
	public static String randomParrotOrigin() {
		return Constants.parrotOrigin[MyRandom.rand.nextInt(0, Constants.parrotOrigin.length)];
	}
	
	public static String[] randomMascotaVariables() {
		String name = randomName();
		String age;
		String state = randomPetState();
		String birthDate = randomStringDate();
		
		age = AgeCalculator.calculate(birthDate);
		
		return new String[]{name,age,state,birthDate};
	}
	
	public static String[] randomPerroVariables() {
		String breed = randomDogBreed();
		String fleas = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{breed,fleas};
	}
	
	public static String[] randomGatoVariables() {
		String color = randomPetColor();
		String longHair = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{color,longHair};
	}
	
	public static String[] randomBirdVariables() {
		String beak = String.valueOf(MyRandom.rand.nextBoolean());
		String flies = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{beak,flies};
	}
	
	public static String[] randomLoroVariables() {
		String origin = randomParrotOrigin();
		String talks = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{origin,talks};
	}
	
	public static String[] randomCanarioVariables() {
		String color = randomPetColor();
		String sings = String.valueOf(MyRandom.rand.nextBoolean());
		
		return new String[]{color,sings};
	}

}
