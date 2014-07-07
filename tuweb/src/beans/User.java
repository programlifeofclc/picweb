package beans;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class User implements Serializable {

    /** identifier field */
    private Long id;

    /** persistent field */
    private String loginName;

    /** nullable persistent field */
    private String loginPws;

    /** full constructor */
    public User(String loginName, String loginPws) {
        this.loginName = loginName;
        this.loginPws = loginPws;
    }

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(String loginName) {
        this.loginName = loginName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPws() {
        return this.loginPws;
    }

    public void setLoginPws(String loginPws) {
        this.loginPws = loginPws;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof User) ) return false;
        User castOther = (User) other;
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
