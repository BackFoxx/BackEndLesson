import dao.RoleDao;
import dto.Role;

import java.util.List;

public class JDBCExam2 {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();

        List<Role> list = dao.getRoles();

        for (Role role : list) {
            System.out.println(role);
        }
    }
}
