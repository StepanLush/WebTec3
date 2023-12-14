package com.poluectov.criticine.criticines.data;

import com.poluectov.criticine.criticines.model.User;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepository {

    SessionFactory sessionFactory;
    public User findByName(String name){
        try (Session session = sessionFactory.openSession()) {
            String query = "FROM User WHERE name = :name";
            return session.createQuery(query, User.class)
                    .setParameter("name", name).uniqueResult();
        }
    }

    public void save(User user) throws EntityExistsException, Exception{
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                session.persist(user);
                session.getTransaction().commit();
            } catch (EntityExistsException ex) {
                // Handle the case where the user already exists
                session.getTransaction().rollback(); // Rollback the transaction if needed
                // Your custom logic, e.g., logging, returning an error message, etc.
                throw ex;
            } catch (Exception ex) {
                // Handle other exceptions
                session.getTransaction().rollback(); // Rollback the transaction if needed
                ex.printStackTrace();
                throw ex;
            }
        }
    }
}
