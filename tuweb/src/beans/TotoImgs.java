package beans;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TotoImgs implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String imgName;

    /** nullable persistent field */
    private String imgContext;

    /** nullable persistent field */
    private String imgUrl;

    /** persistent field */
    private Date createTime;

    /** nullable persistent field */
    private Integer imgWidth;

    /** nullable persistent field */
    private Integer imgHeight;

    /** nullable persistent field */
    private String imgUploader;

    /** full constructor */
    public TotoImgs(String imgName, String imgContext, String imgUrl, Date createTime, Integer imgWidth, Integer imgHeight, String imgUploader) {
        this.imgName = imgName;
        this.imgContext = imgContext;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        this.imgUploader = imgUploader;
    }

    /** default constructor */
    public TotoImgs() {
    }

    /** minimal constructor */
    public TotoImgs(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgName() {
        return this.imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgContext() {
        return this.imgContext;
    }

    public void setImgContext(String imgContext) {
        this.imgContext = imgContext;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getImgWidth() {
        return this.imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return this.imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public String getImgUploader() {
        return this.imgUploader;
    }

    public void setImgUploader(String imgUploader) {
        this.imgUploader = imgUploader;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TotoImgs) ) return false;
        TotoImgs castOther = (TotoImgs) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
