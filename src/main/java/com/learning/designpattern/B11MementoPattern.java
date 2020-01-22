package com.learning.designpattern;

class FileWriterUtil { // Originator
	private String fileName;
	private StringBuilder content;

	public FileWriterUtil(String file) {
		this.fileName = file;
		this.content = new StringBuilder();
	}

	public void write(String str) {
		content.append(str);
	}

	public Memento save() {
		return new Memento(this.fileName, this.content);
	}

	public void undoToLastSave(Object obj) {
		Memento memento = (Memento) obj;
		this.fileName = memento.fileName;
		this.content = memento.content;
	}

	private class Memento {
		private String fileName;
		private StringBuilder content;

		public Memento(String file, StringBuilder content) {
			this.fileName = file;
			this.content = new StringBuilder(content);
		}
	}

	@Override
	public String toString() {
		return this.content.toString();
	}
}

class FileWriterCaretaker {
	private Object obj;

	public void save(FileWriterUtil fileWriter) {
		this.obj = fileWriter.save();
	}

	public void undo(FileWriterUtil fileWriter) {
		fileWriter.undoToLastSave(obj);
	}
}

public class B11MementoPattern {

	public static void main(String[] args) {
		FileWriterCaretaker caretaker = new FileWriterCaretaker();

		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First Set of Data\n");
		System.out.println(fileWriter + "\n\n");

		// lets save the file
		caretaker.save(fileWriter);
		// now write something else
		fileWriter.write("Second Set of Data\n");

		// checking file contents
		System.out.println(fileWriter + "\n\n");

		// lets undo to last save
		caretaker.undo(fileWriter);

		// checking file content again
		System.out.println(fileWriter + "\n\n");
	}

}
