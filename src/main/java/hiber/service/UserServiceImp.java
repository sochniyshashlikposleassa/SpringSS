package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;


   @Override
   @Transactional
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   @Transactional
   public void update(User user) {
      userDao.update(user);
   }

   @Override
   @Transactional
   public void delete(long id) {
      userDao.delete(id);
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> findAll() {
      return userDao.listUsers();
   }

   @Override
   @Transactional
   public void insertDataWithHQL() {
      userDao.insertDataWithHQL();
   }

   @Override
   public User findById(long id) {
      return userDao.findById(id);
   }
}

