package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class CarDaoImp implements CarDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getByCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Car where model=:mod and series =: ser");
        query.setParameter("mod", model);
        query.setParameter("ser", series);
        Car car = (Car) query.getSingleResult();
        Query query2 = sessionFactory.getCurrentSession().createQuery("from User where car=:ca");
        query2.setParameter("ca", car);
        User user = (User) query2.getSingleResult();
        return user;
    }
}
