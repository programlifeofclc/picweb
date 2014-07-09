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
    private String imgUploader;

    /** nullable persistent field */
    private String httpUrl;

    /** nullable persistent field */
    private String keyWord;

    private String basePath;
    /** full constructor */
    public TotoImgs(String imgName, String imgContext, String imgUrl, Date createTime, String imgUploader, String httpUrl, String keyWord) {
        this.imgName = imgName;
        this.imgContext = imgContext;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.imgUploader = imgUploader;
        this.httpUrl = httpUrl;
        this.keyWord = keyWord;
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

    public String getImgUploader() {
        return this.imgUploader;
    }

    public void setImgUploader(String imgUploader) {
        this.imgUploader = imgUploader;
    }

    public String getHttpUrl() {
        return this.httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public String getKeyWord() {
        return this.keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
    

    public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
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
