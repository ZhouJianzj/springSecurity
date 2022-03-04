package com.zj.server.imp;

import com.zj.data.User;
import com.zj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.Collection;


@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userByName = userMapper.findUserByName(s);
        if (userByName == null){
            new AccountNotFoundException("账户不存在");
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userByName.getRole());
        grantedAuthorities.add(simpleGrantedAuthority);

        return new org.springframework.security.core.userdetails.User(s,
                userByName.getPassword(), grantedAuthorities);
    }
}
