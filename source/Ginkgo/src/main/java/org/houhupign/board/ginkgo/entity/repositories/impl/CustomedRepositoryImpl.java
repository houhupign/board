package org.houhupign.board.ginkgo.entity.repositories.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.houhupign.board.ginkgo.entity.repositories.CustomedRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomedRepository<T, ID> {
	public CustomedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}
}
