package com.app.customsorting;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomSorting implements Comparator<Customer> {
	@Override
	public int compare(Customer o1, Customer o2) {
		int ret = o1.getDobDate().compareTo(o2.getDobDate());

		if (ret == 0) {
			return o1.getLastname().compareTo(o2.getLastname());
		}
		return ret;
	}

}
