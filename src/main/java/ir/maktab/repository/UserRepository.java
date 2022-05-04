package ir.maktab.repository;

import ir.maktab.dto.request.UserSearchRequest;
import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.session.MySession;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

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

    default void changePassword(long id,String password){
        Session instance = MySession.getInstance();
        User user1 = instance.get(User.class, id);
        user1.setPassword(password);
        instance.beginTransaction();
        instance.save(user1);
        instance.getTransaction().commit();
    }

    default List<User> search(UserSearchRequest userSearchRequest){
        Session instance = MySession.getInstance();
        return instance.createCriteria(User.class)
                .add(Restrictions.eq("email","m@gmail.com"))
                .list();
    }
}
