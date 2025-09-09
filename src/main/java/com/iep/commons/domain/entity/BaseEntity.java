package com.iep.commons.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected Instant createAt;

    @UpdateTimestamp
    @Column(nullable = false)
    protected Instant updateAt;
}
