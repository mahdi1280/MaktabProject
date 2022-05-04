package ir.maktab.repository;

import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface UserRepository extends BaseRepository<User> {


    default List<User> findALlExpert(){
        Session instance = MySession.getInstance();
        return instance.createQuery("select u from User u where u.role=:role",User.class)
                .setParameter("role", Role.EXPERT).getResultList();
    }

    default List<User> findAllUser(){
        Session instance = MySession.getInstance();
        return instance.createQuery("select u from User u where u.role=:role",User.class)
                .setParameter("role", Role.CUSTOMER).getResultList();
    }
}
