package com.jacaranda.calculator.model;

import java.util.Objects;

public class Calculator {
	private int number1;
	private int number2;
	private char ope;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public char getOpe() {
		return ope;
	}

	public void setOpe(char ope) {
		this.ope = ope;
	}
	
	public double getResult() throws Exception {
		double result = 0;
		
			if(this.ope=='+') {
				result=this.number1+this.number2;
			}else if(this.ope=='-') {
				result=this.number1-this.number2;
			}else if(this.ope=='*') {
				result=this.number1*this.number2;
			}else {
				throw new Exception("Operation not valid");
			}
		
		
		return result;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(number1, number2, ope);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return number1 == other.number1 && number2 == other.number2 && ope == other.ope;
	}
	
	
}
