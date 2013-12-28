package com.ofeeldeuk.vjm.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Size: 12,582,912 B ( 12 MB )

Used: 2,142,264 B ( 2.038055 MB )

Max: 67,108,864 B ( 64 MB )

 */
public class PermGen {
	Runtime rt = Runtime.getRuntime();
	PermGenSource PGSource = new PermGenSource();
	Process p;
	String line;
	ArrayList<String> list = new ArrayList<String>();
	

	PermGenSource 	PermGens(String pid) throws IOException {
		int count = 0;
		PGSource.setPid(pid);

		p = rt.exec("cmd /c chcp 437 & " + "jmap -heap " + PGSource.getPid());
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

					// Perm Generation 사용량
					if (count == 27) {
						PGSource.setSPcapacity(arr[j + 1]);
						PGSource.setDPcapacity(Double.parseDouble(PGSource.getSPcapacity()));
						PGSource.setDPcapacity(PGSource.getDPcapacity() / 1048576);
					}
					if (count == 28) {
						PGSource.setSPused(arr[j + 1]);
						PGSource.setDPused(Double.parseDouble(PGSource.getSPused()));
						PGSource.setDPused(PGSource.getDPused() / 1048576);
					}
					if (count == 29) {
						PGSource.setSPfree(arr[j + 1]);
						PGSource.setDPfree(Double.parseDouble(PGSource.getSPfree()));
						PGSource.setDPfree(PGSource.getDPfree() / 1048576);
					}
				} else {
				}
			}
		}
		
		list.clear();
		return PGSource;
	}

}
