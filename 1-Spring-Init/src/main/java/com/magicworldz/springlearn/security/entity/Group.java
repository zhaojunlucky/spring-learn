package com.magicworldz.springlearn.security.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.magicworldz.springlearn.utils.ObjectUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;

@Data
@Entity(name = "groups")
public class Group extends AbstractPersistable<Long> {
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(
        mappedBy = "group",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<GroupAuthority> groupAuthorities;

    @Override
    public boolean equals(Object other) {
        return ObjectUtil.objEquals(this,other, o->{
            return this.groupName.equals(o.groupName) && this.getId() == o.getId();
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getGroupName(), this.getId());
    }

    @Override
    public String toString() {
        var authorities = this.groupAuthorities.stream().map(GroupAuthority::getAuthority)
                .map(Authority::getAuthority).reduce((l, r)->String.format("%s, %s", l, r)).toString();
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", this.getId())
                .append("groupName", this.groupName)
                .append("authorities", authorities).toString();
    }
}