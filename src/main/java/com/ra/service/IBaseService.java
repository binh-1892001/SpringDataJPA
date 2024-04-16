package com.ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T, ID> {
	Page<T> findAll(Pageable pageable);
	
	T findById(ID id);
	
	T save(T t);
	
	void delete(ID id);
}
