package com.iep.commons.domain.repository;

import com.iep.commons.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseRepository <T extends BaseEntity,U> extends JpaRepository<T,U> {

}
