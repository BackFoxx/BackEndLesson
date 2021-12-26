package jpabook.start;

import java.util.Date;
import javax.persistence.*;  //**

@Entity(name="Member")
@TableGenerator (
		name = "BOARD_SEQ_GENERATOR",
		table = "BOARD_SEQ",
		initialValue = 1, allocationSize = 1
)

public class Member {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", nullable = false, length = 10)
    private String username;

    @Column(name = "AGE")
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @Lob
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public enum RoleType {
    	ADMIN, USER
    }
    
}


