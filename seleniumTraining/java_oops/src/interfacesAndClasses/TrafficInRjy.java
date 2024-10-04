package interfacesAndClasses;

public class TrafficInRjy implements Traffic,TraffficInAndhra {

	@Override
	public void greenSignal() {
		// TODO Auto-generated method stub
		System.out.print("greenSignal");
		
	}

	@Override
	public void redSignal() {
		// TODO Auto-generated method stub
		System.out.print("redSignal");
	}

	@Override
	public void yellowSignal() {
		// TODO Auto-generated method stub
		System.out.print("yellowSignal");
	}

	@Override
	public void noGreenSignal() {
		// TODO Auto-generated method stub
		System.out.print("noGreenSignal");

	}

	@Override
	public void noRedSignal() {
		// TODO Auto-generated method stub
		System.out.print("noRedSignal");

		
	}

	@Override
	public void noYellowSignal() {
		// TODO Auto-generated method stub
		System.out.print("noYellowSignal");

		
	}

	public static void main(String[] args) {
		
		TrafficInRjy tRjy = new TrafficInRjy();
		tRjy.greenSignal();
		tRjy.greenSignal();

		
		
	}
	
	
	
	
	
	
	
}
