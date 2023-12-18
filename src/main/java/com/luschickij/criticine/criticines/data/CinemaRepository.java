package com.luschickij.criticine.criticines.data;

import com.luschickij.criticine.criticines.model.Cinema;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CinemaRepository {

    private SessionFactory sessionFactory;

    public Cinema findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cinema.class, id);
        }
    }

    public List<Cinema> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Cinema", Cinema.class).list();
        }
    }

    public void save(Cinema cinema) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(cinema);
            session.getTransaction().commit();
        }
    }

    public void delete(Cinema cinema) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(cinema);
            session.getTransaction().commit();
        }
    }

    public List<Cinema> findByOrder(String orderByField, int page) {
        page = page < 1 ? 0 : page - 1;
        if (orderByField == null) {
            orderByField = "name";
        }
        try (Session session = sessionFactory.openSession()) {

            String query = "FROM com.poluectov.criticine.criticines.model.Cinema ORDER BY " + orderByField;
            return session.createQuery(query, Cinema.class)
                    .setFirstResult(page * 20)
                    .setMaxResults(20)
                    .list();
        }
    }
}
