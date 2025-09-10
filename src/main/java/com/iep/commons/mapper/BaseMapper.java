package com.iep.commons.mapper;

import com.iep.commons.model.BaseRequestDTO;
import com.iep.commons.model.BaseResponseDTO;

/**
 *
 * @param <T> Modelo de Respuesta
 * @param <R> Modelo de entrada
 * @param <E> Entidad.
 */
public interface BaseMapper <T,R,E> {
    T toResponse(E entity);
    E toEntity(R request);
}
