package ar.com.umpaz.generic;

import java.util.List;

public interface GenericCrud  <T>{

	T save(T Obj);
	List<T> listAllById(T Obj);
	T update(T Obj);
	void delete(T Objt);
	T getById(T Obj);
	
	
	
}
