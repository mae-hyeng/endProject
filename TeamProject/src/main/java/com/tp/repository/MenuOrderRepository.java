package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp.entity.MenuOrder;
import com.tp.entity.UserEntity;

@Repository
public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {

<<<<<<< HEAD
	List<MenuOrder> findByUsernameOrderByOrderDateDesc(String username);
	
	List<MenuOrder> findAllByOrderByOrderDateDesc();
=======
	List<MenuOrder> findByUsername(String username);

>>>>>>> 661b732cca02a9ebce25734e3a001316e238d5c1
}
