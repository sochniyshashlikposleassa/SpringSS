package hiber.service;

import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    void add(User user);

    void update(User user);

    void delete(long id);

    List<User> findAll();

    void insertDataWithHQL();

    User findById(long id);
}
