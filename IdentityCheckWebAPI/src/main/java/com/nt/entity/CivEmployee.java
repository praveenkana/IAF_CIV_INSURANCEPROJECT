package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CivEmployee {
	
	@Id
    private String serviceNumber;
    private String name;
    private String designation;

}
