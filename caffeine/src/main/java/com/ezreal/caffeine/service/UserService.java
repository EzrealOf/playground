package com.ezreal.caffeine.service;


import com.ezreal.caffeine.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ezreal
 */
@Service
public interface UserService {

    /**
     * @return
     */
    List<User> list();

    /**
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * @param id
     * @return
     */
    User findInfoById(Long id);

    /**
     * @param user
     */
    void update(User user);

    /**
     * @param id ID
     */
    void remove(Long id);

}
