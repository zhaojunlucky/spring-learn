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

@Data
@Entity(name = "user_authorities")
public class UserAuthority {
    @EmbeddedId
    private UserAuthorityId userAuthorityId;

    @Column(name="grant_date", columnDefinition="TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT null")
    private LocalDateTime grantDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("authority_id")
    private Authority authority;

    @Override
    public boolean equals(Object other) {
        return ObjectUtil.objEquals(this, other, o-> {
           return this.userAuthorityId.equals(o.userAuthorityId)
                   && this.user.getUsername().equals(o.getUser().getUsername())
                   && this.authority.getId() == o.authority.getId();
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userAuthorityId, this.user.getUsername(), this.authority.getId());
    }
}