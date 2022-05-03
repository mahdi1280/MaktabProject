package ir.maktab.repository;

import ir.maktab.session.MySession;
import org.hibernate.Session;

public interface BaseRepository<T> {

    default void save(T t){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.save(t);
        instance.getTransaction().commit();
    }

    default void delete(T t){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.delete(t);
        instance.getTransaction().commit();
    }

    default void update(T t){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.update(t);
        instance.getTransaction().commit();
    }

    default T findById(Class<T> clazz,long id){
        Session instance = MySession.getInstance();
        return instance.get(clazz,id);
    }
}
