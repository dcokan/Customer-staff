package pwr.itApp.customerStaff.webapp.utils;

import java.util.LinkedList;
import java.util.List;

import pwr.itApp.customerStaff.webapp.utils.lists.FilterCondition;

public class Lists {

	private Lists(){
		throw new IllegalStateException("Prohibitted");
	};
	
	public static <T> List<T> filter(List<T> elements, FilterCondition<T> condition) {
		List<T> filtered = new LinkedList<T>();
		for (T item: elements) {
			if (condition.apply(item)) {
				filtered.add(item);
			}
		}
		return filtered;
	}
}
