package pwr.itApp.customerStaff.service.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Dawid Cokan
 * @date 2015 M04 9
 *
 * @param <T> - Domain class
 * @param <E> - DTO Class
 */
public abstract class AbstractFactoryDTO<T,E> {

	public abstract E getDTO(T entity);
	public abstract T getEntity(E dto);
	
	public List<E> getDTOList(Collection<T> entities) {
		List<E> dtos = null;
		if (entities != null) {
			dtos = new ArrayList<E>();
			for (T entity: entities) {
				dtos.add(getDTO(entity));
			}
		}
		
		return dtos;
	}
	
	
	public List<T> getEntitiesList(Collection<E> dtos) {
		List<T> entities = null;
		if (dtos != null) {
			entities = new ArrayList<T>();
			for (E dto: dtos) {
				entities.add(getEntity(dto));
			}
		}
		return entities;
	}
}
