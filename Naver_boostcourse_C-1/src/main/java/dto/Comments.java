package dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class Comments {
    private String comment;
    private int commentId;
    private CommentImage commentImage;

    private Date createDate;
    private Date modifyDate;

    private int productId;

    private Date reservationDate;
    private String reservationEmail;
    private int reservationInfoId;
    private String reservationName;
    private String reservationTelephone;

    private double score;
}
