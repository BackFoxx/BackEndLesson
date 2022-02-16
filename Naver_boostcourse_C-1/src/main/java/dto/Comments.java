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

    private String createDate;
    private String modifyDate;

    private int productId;

    private String reservationDate;
    private String reservationEmail;
    private int reservationInfoId;
    private String reservationName;
    private String reservationTelephone;

    private double score;
}
