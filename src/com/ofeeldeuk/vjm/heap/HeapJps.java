package com.ofeeldeuk.vjm.heap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

 public class HeapJps  {
	public Runtime rt = Runtime.getRuntime();
	public Process p;
	String line;
	ArrayList<String> list = new ArrayList<String>();
	
	public HeapJpsSource HJSource = new HeapJpsSource();
	

	HeapJpsSource SetPid(String Pname) throws IOException {
		HJSource.setPname(Pname);
		
		p = rt.exec("cmd /c chcp 437 &" + "jps");
		InputStream in = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		for (int i = 0; i < list.size(); i++) {
			String txt = list.get(i);
			String[] arr = txt.split(" ");
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals(Pname)) {
					HJSource.setPid((arr[j -1]));
				}
			}
		}
		list.clear();
		return HJSource;
	}
	
	void HeapJpsOut() throws IOException{
		System.out.println("JPS 출력 물");
		
		p = rt.exec("cmd /c chcp 437 &" + "jps");
		InputStream in = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		for(int i = 0; i< list.size(); i++){
			System.out.println(list.get(i));
		}
		list.clear();
	}
}
