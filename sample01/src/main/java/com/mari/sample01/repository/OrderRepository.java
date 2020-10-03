package com.mari.sample01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.repository.custom.OrderCustomRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, OrderCustomRepository {

}
