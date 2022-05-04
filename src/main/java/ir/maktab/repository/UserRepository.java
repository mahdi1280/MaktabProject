package ir.maktab.repository;

import ir.maktab.dto.request.UserSearchRequest;
import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    default List<User> search(UserSearchRequest userSearchRequest) {
        Session instance = MySession.getInstance();
        CriteriaBuilder criteriaBuilder = instance.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        List<Predicate> predicates=new ArrayList<>();
        if (Objects.nonNull(userSearchRequest.getEmail())) {
            predicates.add(criteriaBuilder.like(from.get("email"), "%" + userSearchRequest.getEmail() + "%"));
        }
        if (Objects.nonNull(userSearchRequest.getFirstname())) {
            predicates.add(criteriaBuilder.like(from.get("firstname"), "%" + userSearchRequest.getFirstname() + "%"));
        }
        if (Objects.nonNull(userSearchRequest.getLastname())) {
            predicates.add(criteriaBuilder.like(from.get("lastname"), "%" + userSearchRequest.getLastname() + "%"));
        }
        if (Objects.nonNull(userSearchRequest.getRole())) {
            predicates.add(criteriaBuilder.equal(from.get("role"), userSearchRequest.getRole()));
        }
        if (Objects.nonNull(userSearchRequest.getUnderService())) {
            predicates.add(criteriaBuilder.equal(from.get("services"), userSearchRequest.getUnderService()));
        }
        CriteriaQuery<User> where = query.select(from).where(predicates.toArray(new Predicate[0]));

        return instance.createQuery(where).getResultList();
    }
}
