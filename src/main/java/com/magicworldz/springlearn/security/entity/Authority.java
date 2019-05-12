package com.magicworldz.springlearn.security.entity;

import javax.persistence.Entity;

import com.magicworldz.springlearn.utils.ObjectUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;


@Data
@Entity(name = "authorities")
public class Authority extends AbstractPersistable<Long> implements GrantedAuthority {
    private String authority;

    @Override
    public boolean equals(Object o) {
        return ObjectUtil.objEquals(this, o, (Authority other)->{
            return this.getId() == other.getId() && this.authority.equals(other.authority);
        });
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.authority);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", this.getId())
                .append("authority", authority).toString();
    }
}