package com.magicworldz.springlearn.security.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

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
@Entity(name = "users")
public class User extends AbstractPersistable<Long> {
    private String username;
    @JsonIgnore
    private String password;
    private boolean enabled;

    @Column(name="created_at", columnDefinition="TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL")
    private LocalDateTime createdAt;

    @Column(name="last_login", columnDefinition="TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastLogin;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    Set<UserAuthority> userAuthorities;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    Set<GroupMember> groupMembers;

    @Override
    public boolean equals(Object other) {
        return ObjectUtil.objEquals(this, other, o-> {
           return this.username.equals(o.username);
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }

    @Override
    public String toString() {
        var groups = this.groupMembers.stream().map(GroupMember::getGroup).map(Group::getGroupName)
                .reduce((l, r) -> String.format("%s, %s", l, r)).toString();
        var authorities = this.userAuthorities.stream().map(UserAuthority::getAuthority).map(Authority::getAuthority)
                .reduce((l, r) -> String.format("%s, %s", l, r)).toString();

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("username", this.username)
                .append("enabled", this.enabled)
                .append("createdAt", this.createdAt)
                .append("lastLogin", this.lastLogin)
                .append("groups", groups)
                .append("authorities", authorities).toString();
    }
}