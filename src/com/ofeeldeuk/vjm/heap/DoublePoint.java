package com.ofeeldeuk.vjm.heap;

import java.text.DecimalFormat;

public class DoublePoint {
	DecimalFormat format = new DecimalFormat(".##");
	
	public double doublepoints(Double doub){
		double Hresult;
		String str = format.format(doub);
		Hresult = Double.parseDouble(str);
		
		return Hresult;
	}

}
