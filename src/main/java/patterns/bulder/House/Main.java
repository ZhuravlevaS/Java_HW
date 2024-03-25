package patterns.bulder.House;

public class Main {
	public static void main(String[] args) {
		 House house = House.builder()
				 .isFinished(true)
				 .levelCount(3)
				 .build();

		System.out.println(house.getLevelCount());
	}
}
