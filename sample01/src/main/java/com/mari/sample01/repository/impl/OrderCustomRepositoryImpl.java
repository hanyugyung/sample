package com.mari.sample01.repository.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Sort;

import com.mari.sample01.data.dao.Order;
import com.mari.sample01.data.dao.QOrder;
import com.mari.sample01.data.req.CommonReqDto;
import com.mari.sample01.repository.OrderCustomRepository;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.PathBuilder;


public class OrderCustomRepositoryImpl implements OrderCustomRepository {
	
	private @PersistenceContext EntityManager entityManager;
	
	@SuppressWarnings("rawtypes")
	private OrderSpecifier[] convertListToArray(List<OrderSpecifier> lst) {
		OrderSpecifier[] arr = new OrderSpecifier[lst.size()];
		for(int i = 0 ; i < lst.size() ; i++) {
			arr[i] = lst.get(i);
		}
		return arr;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Order> getOrderList(CommonReqDto common) {
		
		QOrder order = QOrder.order;
		JPAQuery query = new JPAQuery(entityManager);
		
		BooleanBuilder builder = new BooleanBuilder();
		if(common.getId() != null) builder.and(order.userId.eq(common.getId()));
		
		List<OrderSpecifier> orderBy = new LinkedList<>();
		PathBuilder<Order> entityPath = new PathBuilder<>(Order.class, "order1");
		for(Sort.Order o : common.getSort()) {
			orderBy.add(new OrderSpecifier(com.mysema.query.types.Order.DESC, entityPath.get(o.getProperty())));
		}
		
		if(orderBy.size() == 0) {
			Sort.Order o = new Sort.Order(Sort.Direction.DESC, "id");
			orderBy.add(new OrderSpecifier(com.mysema.query.types.Order.valueOf(o.getDirection().name()), entityPath.get(o.getProperty())));
		}
		
		List<Order> orders = 
				query.from(order)
					.where(builder)
					.orderBy(convertListToArray(orderBy))
					.offset((common.getPage()-1)*common.getSize())
					.limit(common.getSize())
					.list(order);
				
		return orders;
	}
	
	

}
