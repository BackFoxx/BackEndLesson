package dao;

import dto.TodoDto;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbUser = "connectuser";
    private static String dbpasswd = "connect123!@#";

    public List<TodoDto> getTodo() {
        List<TodoDto> list = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement("select id, title, name, sequence, type, regdate from todo order by regdate"))
        {
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String title = rs.getString("title");

                    int sequence = rs.getInt("sequence");
                    String type = rs.getString("type");
                    String regdate = format.format(rs.getDate("regdate"));

                    TodoDto dto = new TodoDto(id, name, title, sequence, type, regdate);
                    list.add(dto);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int addTodo(TodoDto dto) {

        int updateCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement("insert into todo(name, title, sequence) values (?, ?, ?)")) {
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getTitle());
            ps.setInt(3, dto.getSequence());

            updateCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateCount;
    }

    public int updateTodo(TodoDto dto) {

        int updateCount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
            PreparedStatement ps = conn.prepareStatement("update todo set type = ? where id = ?")) {

            String type = dto.getType();

            if (type.equals("TODO")) {
                ps.setString(1, "DOING");
                ps.setLong(2, dto.getId());
            } else if (type.equals("DOING")) {
                ps.setString(1, "DONE");
                ps.setLong(2, dto.getId());
            }

            updateCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateCount;
    }

}
