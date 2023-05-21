package com.noname.webapimock.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noname.webapimock.domain.model.entity.Mock;

@Repository
public interface MockRepository extends JpaRepository<Mock, String> {
}
