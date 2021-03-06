package com.ofeeldeuk.vjm.heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SaveHeapInfo {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy : MM : dd");
	SimpleDateFormat formatter2 = new SimpleDateFormat("HH : mm : ss");

	
	int count = 0;
	
	void SaveHeapInfos(double heapPer) throws IOException {
		try {
			Calendar rightNow = Calendar.getInstance();
			String currentDate = formatter.format(rightNow.getTime());
			String currentDate2 = formatter2.format(rightNow.getTime());
			
			// if(fileIsLive(makeFile))
			// makeFile 은 String 형태
			//C:\Users\bit\git\VJM\WebContent\info
			//String name = "C:\\Users\\bit\\git\\VJM\\WebContent\\info\\HeapInfo.txt";
			//String name = "C:\\Users\\bit\\Desktop\\project\\Project\\HeapInfo.txt";
			String name = "HeapInfo.txt";
			boolean isDir = (new File(name)).isDirectory();
			if (isDir == false) {
				String str = "<" + currentDate2 + "> HeapPer = " + heapPer+ System.getProperty("line.separator");
				
				if(count == 0){
					str = currentDate + System.getProperty("line.separator") + "<" + currentDate2 + "> HeapPer = "+ heapPer+ System.getProperty("line.separator");
					count++;
				}
				
				byte[] arr = str.getBytes();
				RandomAccessFile raf = new RandomAccessFile(name, "rw");
				raf.seek(raf.length());
				raf.write(arr);
				raf.close();

			} else {
				System.out.println("파일 존재하지 않습니다.");
				// File heapInfoFile = new File(
				// "C:\\Users\bit\\Desktop\\project\\Project\\HeapInfo.txt");
				OutputStream out = new FileOutputStream("HeapInfo.txt");
				String str = "HeapPer = " + heapPer;
				byte[] arr = str.getBytes();
				out.write(arr);
				out.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean fileIsLive(String isLivefile) {

		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
		// TODO Auto-generated method stub
	}

}
