package pwr.itApp.customerStaff.webapp.utils.lists;

public interface FilterCondition<T> {

	public boolean apply(T item);
}
