package com.ra.repository;

import com.ra.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {
	/**
	 * mặc định nó viết kiểu hql
	 * còn viết kiểu native Query thì sẽ thêm nativeQuery=true
	 * */
	@Query(value = "select u from Users u where u.fullName like concat('%',:keyword,'%')")
	List<Users> searchUsersByNameCustom(@Param("keyword") String keyword);
}
