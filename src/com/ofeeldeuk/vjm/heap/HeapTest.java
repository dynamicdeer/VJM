package com.ofeeldeuk.vjm.heap;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class HeapTest {

	public static void main(String args[]) throws IOException, InterruptedException {

		HeapJpsSource HJSource = new HeapJpsSource();
		HeapPerSource HPSource = new HeapPerSource();
		PermGenSource PGSource = new PermGenSource();
		SaveHeapInfo SHInfo = new SaveHeapInfo();
		DoublePoint Dpoint = new DoublePoint();
		ReadXmlAdd RXA = new ReadXmlAdd();
		SaveXml SX = new SaveXml();

		Scanner sc = new Scanner(System.in);

		HeapJps HJps = new HeapJps();
		HeapPer HP = new HeapPer();
		PermGen PG = new PermGen();

		String Pname = null;

		HJps.HeapJpsOut();
//		System.out.print("관찰한 프로그램명 입력 : ");
//		Pname = sc.nextLine();
//		HJSource.setPname(Pname);

//		HJSource = HJps.SetPid(Pname);
//		HPSource = HP.HeapPers(HJSource.getPid());
//		PGSource = PG.PermGens(HJSource.getPid());

		while(true){
			
			Thread.sleep(300);
			Pname = "ProjectTest1RunTime";
			
			HJSource = HJps.SetPid(Pname);
			HPSource = HP.HeapPers(HJSource.getPid());
			HPSource.setHper(Dpoint.doublepoints(HPSource.getHper()));
			
			
			System.out.println("Heap Per : " + HPSource.getHper());
			SHInfo.SaveHeapInfos(HPSource.getHper());
//			RXA.xmlAdd(HPSource.getHper());
			SX.xmlAdd(HPSource.getHper());
		}
			
//		if (HJSource.getPid() != null) {
//			System.out.println("Pname : " + HJSource.getPname());
//			System.out.println("Pid : " + HJSource.getPid()); // 구해온 PID 값
//			System.out.println("Heap Per : " + HPSource.getHper());
//			
//			System.out.println("PermGeneration");
//			System.out.println("PermGen Capacity : " + PGSource.getDPcapacity());
//			System.out.println("PermGen Used : " + PGSource.getDPused());
//			System.out.println("PermGen Free : " + PGSource.getDPfree());
//			// System.out.println(HS.getPid()); // 받아온 pid 값 출력
//		}else{
//			System.out.println("입력하신 프로그램이 존재하지 않습니다.");
//		}


	}

}
