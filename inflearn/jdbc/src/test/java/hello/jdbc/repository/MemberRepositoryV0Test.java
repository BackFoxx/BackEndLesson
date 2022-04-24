package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {
        Member memberv0 = new Member("memberv6", 10000);
        repository.save(memberv0);

        Member findMember = repository.findById(memberv0.getMemberId());
        log.info("findMemeber = {}", findMember);
        assertThat(findMember).isEqualTo(memberv0);

        repository.update(memberv0.getMemberId(), 20000);
        Member updatedMember = repository.findById(memberv0.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        repository.delete(memberv0.getMemberId());
        assertThatThrownBy(() -> repository.findById(memberv0.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }
}