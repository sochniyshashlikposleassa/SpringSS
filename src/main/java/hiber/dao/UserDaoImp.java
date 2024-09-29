package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   public void add(User user) {
      entityManager.persist(user);
   }

   public void update(User user) {
      User findedUser = findById(user.getId());
      if (findedUser == null) {
         throw new EntityNotFoundException("Пользователь для обновления не найден");
      }
      findedUser.setFirstName(user.getFirstName());
      findedUser.setLastName(user.getLastName());
      findedUser.setEmail(user.getEmail());
      entityManager.merge(user);
   }

   public void delete(long id) {
      User user = entityManager.find(User.class, id);
      if (user != null) {
         entityManager.remove(user);
      }
   }

   public List<User> listUsers() {
      Query query = entityManager.createQuery("SELECT u FROM User u", User.class);
      return query.getResultList();
   }

   public void insertDataWithHQL() {
      User user1 = new User("John", "30", "ee@mail.ru");
      User user2 = new User("Mike", "35", "ee123@mail.ru");

      entityManager.persist(user1);
      entityManager.persist(user2);
   }

   @Override
   public User findById(long id) {
      return entityManager.find(User.class, id);
   }
}

