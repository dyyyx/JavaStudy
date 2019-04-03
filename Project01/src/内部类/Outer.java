package ÄÚ²¿Àà;

public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		Face.Nose n = f.new Nose();
		n.breath();
		Face.Ear e = new Face.Ear();
		e.listen();
	}
	
}

class Face{
	int type;
	
	class Nose{
		String type;
		
		void breath() {
			System.out.println("ºôÎü£¡");
		}
	}
	static class Ear{
		void listen() {
			System.out.println("Ìý");
			
		}
	}
}
