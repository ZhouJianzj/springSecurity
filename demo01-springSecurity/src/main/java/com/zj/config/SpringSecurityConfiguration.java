package com.zj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhoujian
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 配置认证的用户信息的，这里的需求就是没有使用数据库存储用户信息的登录需求
     * 在内存中存储一个用户信息来满足需要认证的请求登录
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        用户1
        auth.inMemoryAuthentication()
                //新版本中对密码需要指定编码
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhoujian")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("admin");
//         用户2
        auth.inMemoryAuthentication()
                //新版本中对密码需要指定编码
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zj")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("user");
    }

    /**
     * 忽略指定请求的
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll() //项目主路径允许访问
                .anyRequest().authenticated() //其它请求都需要认证
                .and()
                .logout().permitAll()//退出登录也允许访问
                .and()
                .formLogin().permitAll();//表单登录也是允许访问的
        //关闭csrf认证
        http.csrf().disable();
    }

    /**
     * 忽略静态资源的
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");

    }


}
