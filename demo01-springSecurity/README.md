# 工程简介
学会使用spring Security

# 技术栈
springboot
redis
springSecurity 

#场景一(只要能登录就好了)
1、只要实现一个登录就好，没有数据库存储我们的用户信息，这里我们使用内存来存储用户信息
2、放行基本的请求，不放行/hello请求来实现用户登录之后可以访
3、实现方式是重写WebSecurityConfigurerAdapter里面的三个方法
