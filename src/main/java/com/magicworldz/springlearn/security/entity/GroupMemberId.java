package com.magicworldz.springlearn.security.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode(exclude = {"grantDate"})
public class GroupMemberId implements Serializable {
    private static final long serialVersionUID = 3098482283110436201L;

    @Column(name = "group_id")
    private long groupId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "grant_date", columnDefinition="TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT null")
    private LocalDateTime grantDate;
}