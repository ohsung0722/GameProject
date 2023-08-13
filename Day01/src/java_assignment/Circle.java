package java_assignment;

public class Circle {
	int radius;
	String name;
	Circle(int r, String n) 
	{
		radius = r;
		name = n;
	}
	Circle(int r)
	{
		radius = r;
	}
	Circle()
	{
		System.out.println("Welcome to the Circle Worle!");
	}
	void display() 
	{
		System.out.println(radius + " " + name);
	}
	public static void main(String[] args){
		Circle c1 = new Circle(1, "pizza");
		Circle c2 = new Circle(10);
		Circle c3 = new Circle();
		c1.display();
		c2.display();
	}
}
