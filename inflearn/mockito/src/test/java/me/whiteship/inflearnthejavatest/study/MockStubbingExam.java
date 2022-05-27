package me.whiteship.inflearnthejavatest.study;

import me.whiteship.inflearnthejavatest.domain.Member;
import me.whiteship.inflearnthejavatest.domain.Study;
import me.whiteship.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockStubbingExam {
    @Test
    void MockStubbingTest(@Mock StudyRepository studyRepository,
                          @Mock MemberService memberService) {
        StudyService studyService = new StudyService(memberService, studyRepository);

        Study study = new Study(10, "테스트");
        System.out.println("study = " + study);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(1L))
                .thenReturn(Optional.of(member));
        when(studyRepository.save(study))
                .thenReturn(study);

        studyService.createNewStudy(1L, study);
        System.out.println("study = " + study);

        assertNotNull(study.getOwner());
        assertEquals(member, study.getOwner());
    }

    @Test
    @DisplayName("다른 사용자가 볼 수 있도록 스터디를 공개한다.")
    void openStudy(@Mock MemberService memberService,
                   @Mock StudyRepository studyRepository) {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "더 자바, 테스트");

        given(studyRepository.save(study))
                .willReturn(study);

        // When
        studyService.openStudy(study);

        // Then
        assertAll(
                () -> assertNotEquals(StudyStatus.OPENED, study.getStatus()),
                () -> assertNull(study.getOpenedDateTime()),
                () -> then(memberService).should().notify(study)
        );
    }
}
