package com.ofeeldeuk.vjm.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Format;
import java.util.ArrayList;

public class HeapPer {
	Runtime rt = Runtime.getRuntime();
	Process p;
	String line;
	ArrayList<String> list = new ArrayList<String>();
	
	HeapPerSource HPSource = new HeapPerSource();

	HeapPerSource HeapPers(String pid) throws IOException {
		HPSource.setPid(pid);
		int count = 0;
		p = rt.exec("cmd /c chcp 437 & " + "jmap -heap " + HPSource.getPid());
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
				if (arr[j].equals("=")) {
					count++;
					// System.out.println("count : " + count);
					// System.out.println("arr["+ count + "]의 값 : " + arr[j+1]);
					if (count == 15) {
						HPSource.setSEcapacity(arr[j + 1]);
						HPSource.setDEcapacity(Double.parseDouble(HPSource
								.getSEcapacity()));
						HPSource.setDEcapacity(HPSource.getDEcapacity() / 1048576);
					}
					if (count == 16) {
						HPSource.setSEused(arr[j + 1]);
						HPSource.setDEused(Double.parseDouble(HPSource
								.getSEused()));
						HPSource.setDEused(HPSource.getDEused() / 1048576);
					}

					if (count == 18) {
						HPSource.setSFcapacity(arr[j + 1]);
						HPSource.setDFcapacity(Double.parseDouble(HPSource
								.getSFcapacity()));
						HPSource.setDFcapacity(HPSource.getDFcapacity() / 1048576);
					}
					if (count == 19) {
						HPSource.setSFused(arr[j + 1]);
						HPSource.setDFused(Double.parseDouble(HPSource
								.getSFused()));
						HPSource.setDFused(HPSource.getDFused() / 1048576);
					}

					if (count == 21) {
						HPSource.setSTcapacity(arr[j + 1]);
						HPSource.setDTcapacity(Double.parseDouble(HPSource
								.getSTcapacity()));
						HPSource.setDTcapacity(HPSource.getDTcapacity() / 1048576);
					}
					if (count == 22) {
						HPSource.setSTused(arr[j + 1]);
						HPSource.setDTused(Double.parseDouble(HPSource
								.getSTused()));
						HPSource.setDTused(HPSource.getDTused() / 1048576);

					}

					if (count == 24) {
						HPSource.setSOcapacity(arr[j + 1]);
						HPSource.setDOcapacity(Double.parseDouble(HPSource
								.getSOcapacity()));
						HPSource.setDOcapacity(HPSource.getDOcapacity() / 1048576);
					}
					if (count == 25) {
						HPSource.setSOused(arr[j + 1]);
						HPSource.setDOused(Double.parseDouble(HPSource
								.getSOused()));
						HPSource.setDOused(HPSource.getDOused() / 1048576);
					}
				} else {
				}
			}
		}

		HPSource.setHcapacity(HPSource.getDEcapacity()
				+ HPSource.getDFcapacity() + HPSource.getDTcapacity()
				+ HPSource.getDOcapacity());
		HPSource.setHused(HPSource.getDEused() + HPSource.getDFused()
				+ HPSource.getDTused() + HPSource.getDOused());
		HPSource.setHper(HPSource.getHused() * 100 / HPSource.getHcapacity());

		list.clear();
		return HPSource;

	}

}
