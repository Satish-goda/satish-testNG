package oops.abstraction;

public class ChildEmirates extends Airlines {

	@Override
	public void colour() {
		// TODO Auto-generated method stub
		System.out.println("colour");


	}

	public static void main(String[] args) {
		ChildEmirates ce = new ChildEmirates();
		//Airlines al = new Airlines();  cant be instatiate a parent class.
		
		ce.engine();
		ce.colour();
		ce.safetyGuidelines();
	}

}
