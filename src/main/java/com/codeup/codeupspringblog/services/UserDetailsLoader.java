package com.codeup.codeupspringblog.services;

import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.model.UserWithRoles;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private  final UserRepository userDao;

        public UserDetailsLoader(UserRepository userDao) {
            this.userDao = userDao;
        }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + userName);
        }

        return new UserWithRoles(user);
    }

}
