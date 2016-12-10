package com.marc.vpg.service;

import com.marc.vpg.repository.UserRepository;
import com.marc.vpg.repository.entity.User;
import com.marc.vpg.service.domain.UserBean;
import com.marc.vpg.service.internal.UniqueIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UniqueIdService uniqueIdService;

    @Override
    @Transactional
    public UserBean createUser(UserBean userBean) {
        User user = new User();
        user.setUuid(uniqueIdService.getUuid());
        user.setEmail(userBean.getEmail());
        User newUser = userRepository.save(user);
        return UserBean.fromUser(newUser);
    }
}
