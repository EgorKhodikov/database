package programming.dao;

import programming.bean.Student;

public interface Dao<T> {

    T save(T t);

    T findById(Integer id);

    void update(T t);

    void delete(T t);

}
