package dto;

import java.util.Date;

public class Product {
    private int id;
    private int category_id;
    private String description;
    private String content;
    private String event;
    private Date createDate;
    private Date modifyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", event='" + event + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
