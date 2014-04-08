package code;

public class Tupla<E1,E2> {
	E1 e1;
	E2 e2;
	
	//Constructor
	public Tupla(E1 e1, E2 e2)
	{
		this.e1=e1;
		this.e2=e2;
	}	
	
	public E1 getE1() {
		return e1;
	}
	public void setE1(E1 e1) {
		
		this.e1 = e1;
	}
	public E2 getE2() {
		return e2;
	}
	public void setE2(E2 e2) {
		this.e2 = e2;
	}
	
	@Override
	public String toString()
	{
		return "<"+e1.toString() +","+ e2.toString()+">";
	}
}
	
