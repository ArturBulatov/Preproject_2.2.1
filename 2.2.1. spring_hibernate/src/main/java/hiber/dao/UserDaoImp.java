package hiber.dao;

import com.sun.istack.NotNull;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   public User getById(Long id) {
      User user = sessionFactory.getCurrentSession().get(User.class, id);
      return user;
   }

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

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}
