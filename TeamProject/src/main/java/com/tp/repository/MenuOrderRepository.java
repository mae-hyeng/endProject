package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tp.entity.MenuOrder;

@Repository
public interface MenuOrderRepository extends JpaRepository<MenuOrder, Long> {

}
