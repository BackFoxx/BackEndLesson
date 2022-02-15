package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DisplayInfoImage {
    private String contentType;
    private Date createDate;
    private boolean deleteFlag;

    private int displayInfoId;
    private int displayInfoImageId;
    private int fileId;

    private int fileName;
    private Date modifyDate;
    private String saveFileName;
}
