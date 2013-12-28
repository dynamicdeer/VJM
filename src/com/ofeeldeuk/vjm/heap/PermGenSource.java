package com.ofeeldeuk.vjm.heap;

public class PermGenSource {
	private String Pid = null;
	private String SPcapacity = null, SPused = null, SPfree = null;
	private double DPcapacity = 0, DPused = 0, DPfree =0; 
	
	
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public String getSPcapacity() {
		return SPcapacity;
	}
	public void setSPcapacity(String sPcapacity) {
		SPcapacity = sPcapacity;
	}
	public String getSPused() {
		return SPused;
	}
	public void setSPused(String sPused) {
		SPused = sPused;
	}
	public String getSPfree() {
		return SPfree;
	}
	public void setSPfree(String sPfree) {
		SPfree = sPfree;
	}
	public double getDPcapacity() {
		return DPcapacity;
	}
	public void setDPcapacity(double dPcapacity) {
		DPcapacity = dPcapacity;
	}
	public double getDPused() {
		return DPused;
	}
	public void setDPused(double dPused) {
		DPused = dPused;
	}
	public double getDPfree() {
		return DPfree;
	}
	public void setDPfree(double dPfree) {
		DPfree = dPfree;
	}


}
