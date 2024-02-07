package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="room")
@Getter
@Setter
@NoArgsConstructor
public class Room extends BaseEntity{
     
	
}
