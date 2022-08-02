package programming.dao;

public interface Dao<T> {

    T save(T t);

    T findById(Integer id);

    void update(T t);

    void delete(T t);

}
