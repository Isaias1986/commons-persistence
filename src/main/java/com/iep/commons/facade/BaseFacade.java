package com.iep.commons.facade;


import com.iep.commons.domain.entity.BaseEntity;
import com.iep.commons.domain.repository.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
public class BaseFacade <T extends BaseEntity>{

    protected final BaseRepository<T,Long> repository;

    protected BaseFacade(BaseRepository<T,Long> repository){
        this.repository = repository;
    }

    public List<T> findAll(){
        return this.repository.findAll();
    }

    public Optional<T> findById(Long id){
        return  this.repository.findById(id);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    public T save(T entity){
        return this.repository.save(entity);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    public T update(T entity){
        return this.repository.save(entity);
    }

    @Transactional(rollbackForClassName = {"Exception"})
    public void delete (Long id){
        this.repository.deleteById(id);
    }


}
