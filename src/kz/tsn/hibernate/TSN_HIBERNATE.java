package kz.tsn.hibernate;

import java.util.List;
import org.hibernate.Session;

public class TSN_HIBERNATE {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        UserRole userRole1 = new UserRole();
        userRole1.setName("Boss12");
        userRole1.setAccessCodes("736");
        session.save(userRole1);

        UserRole userRole = new UserRole();
        userRole.setName("TSN");
        userRole.setAccessCodes("112144,736");
        session.save(userRole);

        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(userRole1);
        tr.commit();

        List<UserRole> list = (List<UserRole>) session.createCriteria(UserRole.class).list();
//	    List<UserRole> list=(List<UserRole>)session.createSQLQuery("select * from UserRole").addEntity(UserRole.class).list();
//        List<UserRole> list = (List<UserRole>) session.createQuery("from UserRole where id in (7,10,48)").list();
        for (UserRole role : list) {
            System.out.println(role);
        }

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
        
        List<User> list2 = (List<User>) session
                .createCriteria(User.class)
                //  .addOrder(Order.asc("login"))
                // .createCriteria("userRole")
                //.add(Expression.like("name", "%"))
                //.addOrder(Order.asc("name"))
                .list();
        list2.forEach((item) -> {
            System.out.println(item);
        });
        
        session.close();

        System.exit(0);
    }
}
