package com.ra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String fullName;
	private String username;
	private String password;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private Boolean isActive = true;
}
