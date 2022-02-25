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
    private String createDate;
    private boolean deleteFlag;

    private int displayInfoId;
    private int displayInfoImageId;
    private int fileId;

    private String fileName;
    private String modifyDate;
    private String saveFileName;
}
