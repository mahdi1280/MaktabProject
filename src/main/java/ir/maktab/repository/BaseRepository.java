package ir.maktab.repository;

import ir.maktab.model.User;
import ir.maktab.session.MySession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public interface BaseRepository<T> {

    default void save(T t){
        Session instance = MySession.getInstance();
        Transaction transaction = instance.getTransaction();
        transaction.begin();
        instance.save(t);
        transaction.commit();
        instance.close();
    }

    default void delete(T t){
        Session instance = MySession.getInstance();
        Transaction transaction = instance.getTransaction();
        transaction.begin();
        instance.delete(t);
        transaction.commit();
        instance.close();
    }

    default void update(T t){
        Session instance = MySession.getInstance();
        Transaction transaction = instance.getTransaction();
        transaction.begin();
        instance.saveOrUpdate(t);
        transaction.commit();
        instance.close();
    }

    default T findById(Class<T> clazz,long id){
        Session instance = MySession.getInstance();
        return instance.get(clazz,id);
    }

    default List<T> findAll(Class<T> clazz){
        Session instance = MySession.getInstance();
        return instance.createQuery("from "+clazz.getName(),clazz).list();
    }


}
