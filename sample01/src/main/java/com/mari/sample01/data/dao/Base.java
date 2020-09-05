package com.mari.sample01.data.dao;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Embeddable
@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Base {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@CreatedDate
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Column @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime modDate;
}
