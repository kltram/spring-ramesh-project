package com.seekerscapital.sp.model;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ramesh
 * @since 1.0
 * @version Revision History
 * 
 *<pre>
 * --------------------------------------------------------
 * Version |By            |Date          |Modification
 * -------------------------------------------------------- 
 * 1.0     |Ramesh       |2018-04-08    |Create
 * </pre>
 */

/**
 * Price 
 * 
 * @author Ramesh
 */
public class Price {
	private  List<Integer> listPrice = new ArrayList<Integer>();
	private  int averagePrice;
	private int lastPrice;
	
	
	public Price() {
	}


	@Override
	public String toString() {
		return "Price [listPrice=" + listPrice + ", averagePrice=" + averagePrice + ", lastPrice=" + lastPrice + "]";
	}


	public List<Integer> getListPrice() {
		return listPrice;
	}


	public void setListPrice(int listPrice) {
		this.listPrice.add(listPrice);
	}


	public int getAveragePrice() {
		return averagePrice;
	}


	public void setAveragePrice(int averagePrice) {
		this.averagePrice = averagePrice;
	}


	public int getLastPrice() {
		return lastPrice;
	}


	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}
	
	
	
}
