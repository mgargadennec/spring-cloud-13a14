package com.cardiweb.cloud.user.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cardiweb.cloud.user.model.GENDER;
import com.cardiweb.cloud.user.model.User;

@RepositoryRestResource(path="/users", itemResourceRel="user", collectionResourceRel="users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	@RestResource
	public Page<User> findByGender(@Param("gender") GENDER genre, Pageable pageable);

	@RestResource
	public Page<User> findByBirthdateBefore(@Param("beforeDate") Date birthdate, Pageable pageable);

	@RestResource
	public Page<User> findByBirthdateAfter(@Param("afterDate") Date birthdate, Pageable pageable);

}
