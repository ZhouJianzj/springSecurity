//package com.plushuang.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        //在这里定制请求的授权规则
//
//        //首页所有可以访问,其他页面的定制请求与授权
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll()
//        .antMatchers("/level1/**").hasRole("vip1")
//        .antMatchers("/level2/**").hasRole("vip2")
//        .antMatchers("/level3/**").hasRole("vip3");
//
//
//        httpSecurity.formLogin().loginPage("/toLoginForm").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");
//        httpSecurity.csrf().disable();
//        httpSecurity.logout().logoutSuccessUrl("/");
//        //定制记住我的参数！
//        httpSecurity.rememberMe().rememberMeParameter("remember");
//        // .logoutSuccessUrl("/"); 注销成功来到首页
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //自定义认证规则
//        /**
//         * 1.数据可以在内存中顶定义，也可以去JDBC中获取
//         */
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("plushuang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
//                .and()
//                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
//    }
//}
