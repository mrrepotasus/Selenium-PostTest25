package com.ujianmingguan.pageobject.driver.strategy;

import com.ujianmingguan.pageobject.utils.Constans;

public class DriverStrategyImplementer {
	
	public static DriverStrategy choosesStrategy(String strategy) {
		switch(strategy) {
		case Constans.CHROME:
			return new Chrome();
		case Constans.FIREFOX:
			return new Firefox();
		default:
			return null;
			
		}
	}

}
