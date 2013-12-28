package com.ofeeldeuk.vjm.heap;

import java.util.ArrayList;

public class HeapCommon {
	Runtime rt = Runtime.getRuntime();
	Process p;
	String line;
	ArrayList<String> list = new ArrayList<String>();
	
	public Runtime getRt() {
		return rt;
	}
	public void setRt(Runtime rt) {
		this.rt = rt;
	}
	public Process getP() {
		return p;
	}
	public void setP(Process p) {
		this.p = p;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public ArrayList<String> getList() {
		return list;
	}
	public void setList(ArrayList<String> list) {
		this.list = list;
	}

}
