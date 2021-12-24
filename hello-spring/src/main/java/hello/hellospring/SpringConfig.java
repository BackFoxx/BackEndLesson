package hello.hellospring;

import hello.hellospring.Repository.JDBC_TemplateMemberRepository;
import hello.hellospring.Repository.JDBCmemberRepository;
import hello.hellospring.Repository.JPA_MemberRepository;
import hello.hellospring.Repository.MemberRepository;
import hello.hellospring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private EntityManager em;

    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JPA_MemberRepository(em);
    }

}
