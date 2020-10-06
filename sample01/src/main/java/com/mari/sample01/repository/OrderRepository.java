package com.mari.sample01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mari.sample01.data.dao.Order;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderCustomRepository {

}
