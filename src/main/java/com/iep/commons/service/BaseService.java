package com.iep.commons.service;

import com.iep.commons.model.BaseRequestDTO;
import com.iep.commons.model.BaseResponseDTO;
import org.springframework.data.domain.Page;

/**
 * Mapeo de operaciones basicas de un servicio
 * @param <T> Modelo de salida
 * @param <U> Modelo de entrada
 * @param <I> Modelo Identificador del Registro
 */
public interface BaseService<T extends BaseResponseDTO,U extends BaseRequestDTO,I> {
    T save (U request);
    T update(I id,U request);
    T findById(I id);
    Page<T> list(U params);
    void deleteById(I id);
}
