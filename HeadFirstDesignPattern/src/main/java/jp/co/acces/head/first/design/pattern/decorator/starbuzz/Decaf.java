package jp.co.acces.head.first.design.pattern.decorator.starbuzz;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

