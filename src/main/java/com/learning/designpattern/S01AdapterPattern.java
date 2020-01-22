package com.learning.designpattern;

/** It works as a bridge between two incompatible interfaces.Object that joins these unrelated interface is called an Adapter.
*   Class Adapter uses Inheritance and extends source class (e.g Socket).
*   Object Adapter uses Aggregation/Composition and contains the source object.
*   Arrays#asList(), InputStreamReader(InputStream) , OutputStreamWriter(OutputStream) uses Adapter pattern.
*/
class Volt {
	private int volts;
	public Volt(int v) { this.volts = v; }
	public int getVolts() {return volts; }
}
class Socket { // source class
	public Volt getVolt() { return new Volt(120); }
}
interface SocketAdapter {
	Volt get120Volt();
	Volt get12Volt();
}
class SocketClassAdapterImpl extends Socket implements SocketAdapter { // 1) Class Adapter
	public Volt get120Volt() { return getVolt(); }
	public Volt get12Volt() {
		Volt v = getVolt();
		return convertVolt(v, 10);
	}
	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}
class SocketObjectAdapterImpl implements SocketAdapter { // 2) Object Adapter
	private Socket sock = new Socket(); // Using Aggregation
	public Volt get120Volt() {
		return sock.getVolt();
	}
	public Volt get12Volt() {
		Volt v = sock.getVolt();
		return convertVolt(v, 10);
	}
	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}
}

public class S01AdapterPattern {
	public static void main(String[] args) {

	}
}
