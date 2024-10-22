package main.enumerated_types;

public class Test {
	
	public static void main(String[] args) {
		
		Direction.EAST.printAngle();
		System.out.println(Direction.SOUTH.name());
		System.out.println(Direction.SOUTH.toString());
		System.out.println(Direction.WEST.ordinal());
		System.out.println(Direction.WEST.compareTo(Direction.SOUTH));
		System.out.println(Direction.WEST.getDeclaringClass());
		System.out.println(Direction.valueOf("NORTH"));
		
		for(Direction value: Direction.values()) {
			System.out.print(value.name()+" ");
		}
		System.out.println();
		
		Gender.MALE.method();
		Gender.FEMALE.method();
		
		
	}

}

enum Direction{
	
	NORTH(0), EAST(90), SOUTH(180), WEST(270);
	
	private int angle;

	private Direction(int angle) {
		this.angle = angle;
	}
	
	public void printAngle() {
		System.out.println("This direction is at "+angle+" degrees.");
	}
	
}

enum Gender{
	MALE{

		@Override
		public void method() {
			System.out.println("I am a Man!");
		}
		
	}, FEMALE{

		@Override
		public void method() {
			System.out.println("I am a Woman!");
		}
		
	};
	
	public abstract void method();

	@Override
	public String toString() {
		return "Only toString can be overriden of the Object class.";
	}
	
	
}
