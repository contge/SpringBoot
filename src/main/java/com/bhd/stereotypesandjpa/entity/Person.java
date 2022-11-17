package com.bhd.stereotypesandjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Person {
	
	@Id
	@Column(name = "document_number", length = 11)
	private String documentNumber;
	
	@Column(name = "full_name", length = 30, nullable = false)
	private String fullName;
	
	@Column(name = "telephone_number", length = 10)
	private String telephoneNumber;
	
	@Column(length = 50)
	private String address;
}
