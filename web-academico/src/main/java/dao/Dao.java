package dao;

import java.util.List;

public interface Dao<T> {
	
	T get(int id);//primary key
	
	List<T> getAll();
	
	void save(T objeto);
	
	void update(T objeto);
	
	void delete(T objeto);
	
}
