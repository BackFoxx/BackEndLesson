package me.whiteship.inflearnthejavatest.study;
import me.whiteship.inflearnthejavatest.domain.Member;
import me.whiteship.inflearnthejavatest.domain.Study;
import me.whiteship.inflearnthejavatest.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // @Mock 을 이용해서 목 객체를 만들 수 있음
class StudyServiceTest {

//    @Mock MemberService memberService;
//    @Mock StudyRepository studyRepository;

    @Test
    @DisplayName("객체 생성에 필요한 의존관계를 Mock을 이용해 대신 주입")
    void createStudyService(@Mock MemberService memberService,
                            @Mock StudyRepository studyRepository)  {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    @DisplayName("when을 이용해 특정 동작 실행시 리턴되는 값 정하기")
    void createStudyService2(@Mock MemberService memberService)  {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(2L))
                .thenReturn(Optional.of(member));

        Optional<Member> findMember = memberService.findById(2L);
        assertEquals(member.getEmail(), findMember.get().getEmail());

        Optional<Member> findMember2 = memberService.findById(1L);
        assertTrue(findMember2.isEmpty());
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition}")
    @DisplayName("any()를 이용해 파라미터 범위를 조정하기")
    void createStudyService3(@Mock MemberService memberService, RepetitionInfo repetitionInfo) {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member));

        assertEquals(member, memberService.findById(Long.valueOf(repetitionInfo.getCurrentRepetition())).get());
    }

    @Test
    @DisplayName("특정 동작 수행시 예외 반환(리턴값 있는 경우)")
    void createStudyService4(@Mock MemberService memberService)  {
        when(memberService.findById(1L)).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> memberService.findById(1L));
    }

    @Test
    @DisplayName("특정 동작 수행시 예외 반환(리턴값 없는 경우)")
    void createStudyService5(@Mock MemberService memberService)  {

        doThrow(new IllegalArgumentException())
                .when(memberService).validate(1L);
        assertThrows(IllegalArgumentException.class,
                () -> memberService.validate(1L));

        doThrow(new IllegalArgumentException())
                .when(memberService).findById(1L); // 리턴값 있는 동작도 가능
        assertThrows(IllegalArgumentException.class,
                () -> memberService.findById(1L));

//        doThrow(new IllegalArgumentException())
//                .when(memberService.findById(1L));
//        assertThrows(IllegalArgumentException.class,
//                () -> memberService.findById(1L)); //불가능
    }

    @Test
    @DisplayName("같은 메서드를 여러 번 호출했을 때 다르게 반응하도록")
    void createStudyService6(@Mock MemberService memberService)  {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        assertEquals(Optional.of(member), memberService.findById(1L));
        assertThrows(RuntimeException.class, () -> memberService.findById(1L));
        assertTrue(memberService.findById(1L).isEmpty());
    }

    @Test
    @DisplayName("verify 이용하여 메서드가 호출 되었는지 확인하기")
    void createStudyService7(@Mock StudyRepository studyRepository,
                          @Mock MemberService memberService) {
        StudyService studyService = new StudyService(memberService, studyRepository);

        Study study = new Study(10, "테스트");

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

        when(memberService.findById(1L))
                .thenReturn(Optional.of(member));
        when(studyRepository.save(study))
                .thenReturn(study);

        studyService.createNewStudy(1L, study);

        verify(memberService, times(1)).notify(any()); // 호출 n번
        verifyNoMoreInteractions(memberService); // 이 이후 어떤 메서드 호출도 일어나서는 안된다
        verify(memberService, never()).validate(any()); // 호출 X

        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).nofify(member);
        // 메서드 호출 순서
    }

    @Test
    @DisplayName("BDD")
    void createStudyService8(@Mock StudyRepository studyRepository,
                          @Mock MemberService memberService) {
        // Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        Study study = new Study(10, "테스트");

        Member member = new Member();
        member.setId(1L);
        member.setEmail("keesun@gmail.com");

//        when(memberService.findById(1L))
//                .thenReturn(Optional.of(member));
//        when(studyRepository.save(study))
//                .thenReturn(study);
//      ->
        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        // When
        studyService.createNewStudy(1L, study);

        // Then
//        verify(memberService, times(1)).notify(any()); // 호출 n번
//        ->
        then(memberService).should(times(1)).notify(any());

//        verifyNoMoreInteractions(memberService); // 이 이후 어떤 메서드 호출도 일어나서는 안된다
//        ->
//        then(memberService).shouldHaveNoMoreInteractions();

//        verify(memberService, never()).validate(any()); // 호출 X
//        ->
        then(memberService).should(never()).validate(any());

        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).nofify(member); // 메서드 호출 순서
    }

}