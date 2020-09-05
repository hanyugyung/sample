package com.mari.sample01.data.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Embeddable
@MappedSuperclass
public class Base {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private LocalDateTime regDate;
	
	@Column
	private LocalDateTime modDate;
}
