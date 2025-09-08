package com.iep.commons.app.domain.repository;

import com.iep.commons.app.domain.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BaseRepository <T extends BaseEntity,U> extends JpaRepository<T,U> {

}
