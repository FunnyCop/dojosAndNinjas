package com.logan.dojosAndNinjas.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "ninjas" )
public class Ninja {

	// Columns/Fields

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id; // ninja.id

	@NotNull
	@Size( min = 1, max = 255 )
	private String firstName; // ninja.firstName

	@NotNull
	@Size( min = 1, max = 255 )
	private String lastName; // ninja.lastName

	@NotNull
	private int age; // ninja.age

	@Column( updatable = false )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdAt; // ninja.createdAt

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date updatedAt; // ninja.updatedAt

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "dojo_id" )
    private Dojo dojo; // ninja.dojo

    // created_at generator

    @PrePersist
 	protected void onCreate()
    	{ this.createdAt = new Date(); } // ninja.createdAt

    // updated_at generator

 	@PreUpdate
 	protected void onUpdate()
 		{ this.updatedAt = new Date(); } // ninja.updatedAt

 	// Getters

 	public Long getId()
 		{ return this.id; } // ninja.id

 	public String getFirstName()
 		{ return this.firstName; } // ninja.firstName

 	public String getLastName()
 		{ return this.lastName; } // ninja.lastName

 	public int getAge()
 		{ return this.age; } // ninja.age

 	public Date getCreatedAt()
 		{ return this.createdAt; } // ninja.createdAt

 	public Date getUpdatedAt()
 		{ return this.updatedAt; } // ninja.updatedAt

 	public Dojo getDojo()
 		{ return this.dojo; } // ninja.dojo

 	// Setters

 	public void setId( Long id )
 		{ this.id = id; } // ninja.id

 	public void setFirstName( String firstName ) // ninja.firstName
 		{ this.firstName = firstName; }

 	public void setLastName( String lastName )
 		{ this.lastName = lastName; } // ninja.lastName

 	public void setAge( int age )
 		{ this.age = age; } // ninja.age

 	public void setDojo( Dojo dojo )
 		{ this.dojo = dojo; } // ninja.dojo

 	// Constructors

 	public Ninja() {}

 	public Ninja(

 		String firstName,
 		String lastName,
 		int age,
 		Dojo dojo

 	) {

 		this.firstName = firstName;
 		this.lastName = lastName;
 		this.age = age;
 		this.dojo = dojo;

 	}

}










