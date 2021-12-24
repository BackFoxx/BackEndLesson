//리포지토리 관련 인터페이스
package hello.hellospring.Repository;


import hello.hellospring.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
