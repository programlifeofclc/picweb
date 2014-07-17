package beans;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PageModule implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private Integer moduleId;

    /** nullable persistent field */
    private Integer imgId;

    /** nullable persistent field */
    private Integer flag;

    /** full constructor */
    public PageModule(Integer moduleId, Integer imgId, Integer flag) {
        this.moduleId = moduleId;
        this.imgId = imgId;
        this.flag = flag;
    }

    /** default constructor */
    public PageModule() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getImgId() {
        return this.imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PageModule) ) return false;
        PageModule castOther = (PageModule) other;
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
