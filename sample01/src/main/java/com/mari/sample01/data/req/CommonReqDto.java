package com.mari.sample01.data.req;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//필요시 추가하도록 한다
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonReqDto {
	
	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private int page;
	private int size;
	private Sort sort;
	
	@Builder
	public CommonReqDto(Long id, LocalDate startDate, LocalDate endDate, int page, int size, List<String> sortList) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.page = page;
		this.size = size;
		List<Order> orderList = new ArrayList<Order>();
		for(String sort : sortList) {
			orderList.add(new Order(Sort.Direction.DESC, sort));	//내림차순으로 고정
		}
		this.sort = Sort.by(orderList);
	}
	
	
}
