package com.magicworldz.springlearn.security.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magicworldz.springlearn.utils.ObjectUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

@Data
@Entity(name = "group_authorities")
public class GroupAuthority {
    @EmbeddedId
    private GroupAuthorityId groupAuthorityId;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("group_id")
    @JsonIgnore
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @MapsId("authority_id")
    private Authority authority;

    @Override
    public boolean equals(Object other) {
        return ObjectUtil.objEquals(this, other, o->{
            return this.groupAuthorityId.equals(o.groupAuthorityId)
                    && this.group.getId() == o.group.getId()
                    && this.authority.getId() == o.authority.getId();
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupAuthorityId, group.hashCode(), authority.hashCode());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", this.groupAuthorityId.toString())
                .append("group", this.group.toString())
                .append("authority", this.authority.toString()).toString();
    }
}