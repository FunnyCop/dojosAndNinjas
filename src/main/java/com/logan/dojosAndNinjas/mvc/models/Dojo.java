package com.logan.dojosAndNinjas.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "dojos" )
public class Dojo {

	// Columns/Fields

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id; // dojo.id

	@Column( unique = true )
	@NotNull
	@Size( min = 5, max = 255 )
	private String name; // dojo.name

	@Column( updatable = false )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date createdAt; // dojo.createdAt

    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date updatedAt; // dojo.updatedAt

    @OneToMany( mappedBy = "dojo", fetch = FetchType.LAZY )
    private List< Ninja > ninjas; // dojo.ninjas

    // created_at generator

    @PrePersist
 	protected void onCreate()
    	{ this.createdAt = new Date(); } // dojo.createdAt

    // updated_at generator

 	@PreUpdate
 	protected void onUpdate()
 		{ this.updatedAt = new Date(); } // dojo.updatedAt

 	// Getters

 	public Long getId()
 		{ return this.id; } // dojo.id

 	public String getName()
 		{ return this.name; } // dojo.name

 	public Date getCreatedAt()
 		{ return this.createdAt; } // dojo.createdAt

 	public Date getUpdatedAt()
 		{ return this.updatedAt; } // dojo.updatedAt

 	public List< Ninja > getNinjas()
 		{ return this.ninjas; } // dojo.ninjas

 	// Setters

 	public void setId( Long id )
 		{ this.id = id; } // dojo.id

 	public void setName( String name )
 		{ this.name = name; } // dojo.name

 	// Constructors

 	public Dojo() {}

 	public Dojo( String name )
 		{ this.name = name; }

}
