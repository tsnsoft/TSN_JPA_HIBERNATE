package kz.tsn.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TSN_HIBERNATE_OLD {

    public static void main(String[] args) {
        // Открытие сессии Hibernate
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            // Начало транзакции
            Transaction transaction = session.beginTransaction();

            // Создание и сохранение UserRole
            UserRole userRole1 = new UserRole();
            userRole1.setName("Boss12");
            userRole1.setAccessCodes("736");
            session.save(userRole1);

            UserRole userRole2 = new UserRole();
            userRole2.setName("TSN");
            userRole2.setAccessCodes("112144,736");
            session.save(userRole2);

            // Удаление ранее созданного UserRole (userRole1)
            session.delete(userRole1);

            // Фиксация транзакции
            transaction.commit();

            // Выборка всех UserRole
            List<UserRole> list = session.createCriteria(UserRole.class).list();
            // Альтернативные способы выборки:
            // List<UserRole> list = session.createSQLQuery("select * from UserRole").addEntity(UserRole.class).list();
            // List<UserRole> list = session.createQuery("from UserRole where id in (7,10,48)").list();
            
            // Печать всех UserRole
            for (UserRole role : list) {
                System.out.println(role);
            }

            // Начало новой транзакции для операций с User
            transaction = session.beginTransaction();

            // Создание и сохранение User
            User user = new User();
            user.setAvailableDepartments("1,2,3,4");
            user.setDescription("Test12");
            user.setLogin("Test12");
            user.setPassword("1234");
            user.setUserRole(new UserRole("hibernate2", "7,7,7"));
            session.save(user);

            // Получение и обновление User
            user = (User) session.get(User.class, user.getId());
            user.setAvailableDepartments("777");
            session.save(user);

            // Фиксация транзакции
            transaction.commit();

            // Выборка всех User
            List<User> list2 = session.createCriteria(User.class).list();
            // Альтернативные способы выборки с сортировкой и фильтрацией:
            // List<User> list2 = session.createCriteria(User.class).addOrder(Order.asc("login")).createCriteria("userRole").add(Expression.like("name", "%")).addOrder(Order.asc("name")).list();

            // Печать всех User
            list2.forEach((item) -> {
                System.out.println(item);
            });

        } catch (Exception e) {
            // Обработка исключений при работе с базой данных
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }

        // Завершение работы приложения
        System.exit(0);
    }
}