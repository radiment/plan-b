package com.epam.planb.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@RestController
@RequestMapping("/users")
public class UserService {

    @GetMapping("/currentId")
    public Long getCurrentUserId() {
        return 1L;
    }
}
