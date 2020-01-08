package com.advantech.model;
// Generated 2017/5/25 上午 10:45:32 by Hibernate Tools 4.3.1

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * LsTagNameComparisonId generated by hbm2java
 */
@Embeddable
public class LineUserReferenceId implements java.io.Serializable {

    private Line line;
    private User user;

    public LineUserReferenceId() {
    }

    public LineUserReferenceId(Line line, User user) {
        this.line = line;
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof LineUserReferenceId)) {
            return false;
        }
        LineUserReferenceId castOther = (LineUserReferenceId) other;

        return ((this.getLine() == null ? castOther.getLine() == null : this.getLine().equals(castOther.getLine())) || (this.getLine() != null && castOther.getLine() != null && this.getLine().equals(castOther.getLine())))
                && ((this.getUser() == null ? castOther.getUser() == null : this.getUser().equals(castOther.getUser())) || (this.getUser() != null && castOther.getUser() != null && this.getUser().equals(castOther.getUser())));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result + (getLine() == null ? 0 : this.getLine().hashCode());
        result = 37 * result + (getUser() == null ? 0 : this.getUser().hashCode());
        return result;
    }

}
