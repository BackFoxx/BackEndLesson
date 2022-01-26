package dao;

import dto.TodoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

class TodoDaoTest {

    TodoDao dao = new TodoDao();

    @Test
    public void Todo삽입_조회() {
        TodoDto dto = new TodoDto();
        dto.setName("김수현");
        dto.setTitle("밥 만들기");
        dto.setSequence(1);

        TodoDto dto2 = new TodoDto();
        dto2.setName("햇반");
        dto2.setTitle("설거지 하기");
        dto2.setSequence(2);

        dao.addTodo(dto);
        dao.addTodo(dto2);

        List<TodoDto> list = dao.getTodo();
        for (TodoDto dtos : list) {
            System.out.println(dtos.toString());
        }

    }

    @Test
    public void Todo하나찾기() {
        Long id = 7L;
        TodoDto one = dao.findOne(id);
        System.out.println("one.getTitle() = " + one.getTitle());
        System.out.println("one.getType() = " + one.getType());
    }

    @Test
    public void Todo업데이트() {
        Long id = 6L;
        TodoDto one = dao.findOne(id);

        System.out.println("one.getTitle() = " + one.getTitle());
        System.out.println("one.getType() = " + one.getType());

        dao.updateTodo(one);

        TodoDto two = dao.findOne(id);
        System.out.println("two.getTitle() = " + two.getTitle());
        System.out.println("two.getType() = " + two.getType());

    }

}