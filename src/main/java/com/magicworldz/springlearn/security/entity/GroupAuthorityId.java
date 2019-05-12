package com.magicworldz.springlearn.security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode
public class GroupAuthorityId implements Serializable {
    private static final long serialVersionUID = -7974569166679565270L;

    @Column(name = "group_id")
    private long groupId;

    @Column(name = "authority_id")
    private long authorityId;
}