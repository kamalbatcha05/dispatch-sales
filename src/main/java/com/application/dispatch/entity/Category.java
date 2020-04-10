package com.application.dispatch.entity;

import com.application.dispatch.utils.JsonObjectSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

	private static final String NOT_BLANK_MESSAGE = "The value may not be empty!";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;

	@NotBlank(message = NOT_BLANK_MESSAGE)
	@Column(name = "category_name")
	@Size(max = 25)
	private String categoryName;

	@Column(name = "status")
	@Size(max = 25)
	private String status;

	@Column(name = "description")
	private String description;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonSerialize(using = JsonObjectSerializer.class)
	private Set<Product> products = new HashSet<Product>();

	@CreationTimestamp
	@Column(name = "created_date")
    private Date createdDateTime;

	@UpdateTimestamp
	@Column(name = "updated_date")
    private Date updatedDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
 
    public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
