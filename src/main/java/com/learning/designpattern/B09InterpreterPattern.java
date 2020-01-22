package com.learning.designpattern;

class InterpreterContext {
	public String getBinaryFormat(int i) {
		return Integer.toBinaryString(i);
	}

	public String getHexadecimalFormat(int i) {
		return Integer.toHexString(i);
	}
}

interface Expression {
	String interpret(InterpreterContext ic);
}

class IntToBinaryExpression implements Expression {
	private int i;

	public IntToBinaryExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}
}

class IntToHexExpression implements Expression {
	private int i;

	public IntToHexExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexadecimalFormat(i);
	}
}

class InterpreterClient {
	public InterpreterContext ic;

	public InterpreterClient(InterpreterContext i) {
		this.ic = i;
	}

	public String interpret(String str) {
		Expression exp = null;
		// create rules for expressions
		if (str.contains("Hexadecimal")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else
			return str;
		return exp.interpret(ic);
	}
}

public class B09InterpreterPattern {
	public static void main(String[] args) {

	}
}
