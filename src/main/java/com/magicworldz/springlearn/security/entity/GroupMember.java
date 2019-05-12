package com.magicworldz.springlearn.security.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.magicworldz.springlearn.utils.ObjectUtil;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@Entity(name = "group_members")
public class GroupMember {
    @EmbeddedId
    private GroupMemberId groupMemberId;

    @Column(name="grant_date", columnDefinition="TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT null",
            insertable = false, updatable = false)
    private LocalDateTime grantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("group_id")
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("user_id")
    private User user;

    @Override
    public boolean equals(Object other) {
        return ObjectUtil.objEquals(this, other, o->{
           return this.groupMemberId.equals(o.groupMemberId)
            && this.group.getId() == o.group.getId()
            && this.user.getId() == o.user.getId();
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.groupMemberId);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", this.groupMemberId.toString())
                .append("group", this.group.getGroupName())
                .append("user", this.user.getUsername()).toString();
    }
}