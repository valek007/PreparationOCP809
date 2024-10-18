package main.overriding_hashcode_equals_tostring;

public class MyClassHashCode {

	public int num;

	public MyClassHashCode(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	@Override
	public String toString() {
		return "My Number is: "+num;
	}
	
	
	
//	@Override
//	public long hashCode() {
//		return num; //Do not override correctly
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		return num == obj.num; //Compilation
//	}
}
