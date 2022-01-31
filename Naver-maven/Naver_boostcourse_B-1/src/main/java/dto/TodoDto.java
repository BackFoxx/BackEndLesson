package dto;

public class TodoDto{
    private Long id;
    private String name;
    private String title;

    private int sequence;
    private String type;
    private String regDate;

    public TodoDto() {
    }

    public TodoDto(Long id, String name, String title, int sequence, String type, String regDate) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.sequence = sequence;
        this.type = type;
        this.regDate = regDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", navigation_title='" + title + '\'' +
                ", sequence=" + sequence +
                ", type='" + type + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(TodoDto o) {
//        if (o.getSequence() < sequence) {
//            return 1;
//        } else if (o.getSequence() > sequence) {
//            return -1;
//        }
//        return 0;
//    }
}
