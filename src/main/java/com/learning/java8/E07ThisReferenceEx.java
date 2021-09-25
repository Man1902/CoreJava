package com.learning.java8;

public class E07ThisReferenceEx {
	public static void main(String[] args) {
		E07ThisReferenceEx obj = new E07ThisReferenceEx();

		// Case 1 : using anonymous IMPL
		obj.doProcess(10, new Process() {
			@Override
			public void process(int i) {
				System.out.println("i : " + i);
				System.out.println(this);
			}

			@Override
			public String toString() {
				return "Anonymous class Instance";
			}
		});

		// Case 2 using Lamda expression
		obj.execute();
	}

	private void doProcess(int i, Process p) {
		p.process(i);
	}

	public void execute() {
		doProcess(10, i -> {
			System.out.println("i : " + i);
			System.out.println(this);
		});
	}

	@Override
	public String toString() {
		return "E07ThisReferenceEx class Instance";
	}
}
