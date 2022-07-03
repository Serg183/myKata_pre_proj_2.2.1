package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(Object o) {
      sessionFactory.getCurrentSession().save(o);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> getUsersCar(String model, int series) {
         String hql = "from User user where user.car.model = :model_name and user.car.series = :series_name";
         TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
         query.setParameter("model_name", model);
         query.setParameter("series_name", series);
         return (List<User>) query.getResultList();
      }

}
