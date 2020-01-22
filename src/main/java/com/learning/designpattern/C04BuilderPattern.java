package com.learning.designpattern;

class Student {
	private int studId; // mandatory
	private String name; // Optional

	private Student(StudentBuilder studentBiuilder) {
		this.studId = studentBiuilder.studId;
		this.name = studentBiuilder.name;
	}

	public static class StudentBuilder {
		private int studId; // mandatory
		private String name; // Optional

		public StudentBuilder(int studId) {
			this.studId = studId;
		}

		public StudentBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}
}

public class C04BuilderPattern {
	public static void main(String[] args) {
		Student student = new Student.StudentBuilder(1).setName("Stud1").build();

	}
}
