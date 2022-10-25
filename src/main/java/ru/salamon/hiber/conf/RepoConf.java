package ru.salamon.hiber.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
@EnableJpaRepositories("ru.salamon.hiber.repo")
public class RepoConf {

//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        return new LocalSessionFactoryBean();
//    }

}
