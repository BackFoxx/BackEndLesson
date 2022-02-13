package dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class CommentImage {
    private String contentType;
    private Date createDate;
    private boolean deleteFlag;
    private int fileId;
    private String fileName;
    private int imageId;
    private Date modifyDate;
    private int reservationInfoId;
    private int reservationUserCommentId;
    private String saveFileName;
}
