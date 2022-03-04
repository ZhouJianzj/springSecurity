package com.plushuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhoujian
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/","/index").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll().logoutSuccessUrl("/").clearAuthentication(true).deleteCookies().invalidateHttpSession(true)
                .and()
//                其它请求都需要身份认证
                .authorizeRequests().anyRequest().authenticated();
        

//        关闭跨站攻击
        http.csrf().disable();

    }

    /**
     * 构造内存用户需要指定密码加密规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication( )
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(new BCryptPasswordEncoder().encode("123")).roles("vip1")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("vip2", "vip1", "vip3");
    }


}
