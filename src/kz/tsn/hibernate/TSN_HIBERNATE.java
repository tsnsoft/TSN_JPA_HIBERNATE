package kz.tsn.hibernate;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;

public class TSN_HIBERNATE {

    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<UserRole> criteriaUserRole = builder.createQuery(UserRole.class);
        criteriaUserRole.select(criteriaUserRole.from(UserRole.class));
        
        CriteriaQuery<User> criteriaUser = builder.createQuery(User.class);
        criteriaUser.select(criteriaUser.from(User.class));
        
        UserRole userRole1 = new UserRole();
        userRole1.setName("R114");
        userRole1.setAccessCodes("125");
        session.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setName("lsadkjghl");
        userRole2.setAccessCodes("45859,2367658");
        session.save(userRole2);

        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(userRole1);
//        session.delete(userRole2);
        tr.commit();

        User user = new User();
        user.setAvailableDepartments("1,2,3,4");
        user.setDescription("Test12");
        user.setLogin("Test12");
        user.setPassword("1234");
        user.setUserRole(new UserRole("hibernate2", "7,7,7"));
        session.save(user);
        
        user = (User) session.get(User.class, user.getId());
        user.setAvailableDepartments("777");
        session.save(user);
        
        List<User> resultsUser = session.createQuery(criteriaUser).getResultList();
        resultsUser.forEach((item) -> {
            System.out.println(item);
        });

        List<UserRole> resultsUserRole = session.createQuery(criteriaUserRole).getResultList();
        resultsUserRole.forEach((item) -> {
            System.out.println(item);
        });
        
        session.close();

        System.exit(0);
    }
    
}
