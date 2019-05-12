package com.magicworldz.springlearn.security.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class UserAuthorityId implements Serializable {
    @Column(name = "user_id")
    private long userId;

    @Column(name = "authority_id")
    private long authorityId;
}