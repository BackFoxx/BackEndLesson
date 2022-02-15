package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductImages {
    private String contentType;
    private Date createDate;
    private boolean deleteFlag;

    private int fileInfoId;
    private String fileName;
    private String modifyDate;

    private int productId;
    private int productImageId;
    private String saveFileName;

    private Type type;
}
