package com.datingtrench.mvc.base;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by elvis on 2/6/14.
 */
public interface AbstractRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
