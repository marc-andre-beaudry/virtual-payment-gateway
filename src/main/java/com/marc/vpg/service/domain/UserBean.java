package com.marc.vpg.service.domain;

import com.marc.vpg.repository.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBean {

    private String email;
    private String uuid;

    public static UserBean fromUser(User user) {
        UserBean bean = new UserBean();
        bean.setEmail(user.getEmail());
        bean.setUuid(user.getUuid());
        return bean;
    }
}
