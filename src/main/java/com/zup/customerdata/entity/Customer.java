package com.zup.customerdata.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class that represents the customer table.
 * @author asignorette.
 *
 */
@Entity
public class Customer {

	@Id	
	@Column
	private Long id;
	/** Represents name from customer. **/
	@Column
	private String name;
	/** Represents business number from customer.**/
	@Column
	private String businessNumber;
	/** Represents birthday from customer. **/
	@Column
	private Calendar birthday;
	/** Represents many address from customer. **/
	@OneToMany(cascade= {CascadeType.ALL})
	private List<Address> address;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the businessNumber
	 */
	public String getBusinessNumber() {
		return businessNumber;
	}

	/**
	 * @param businessNumber the businessNumber to set
	 */
	public void setBusinessNumber(String businessNumber) {
		this.businessNumber = businessNumber;
	}

	/**
	 * @return the birthday
	 */
	public Calendar getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	/**
	 * @param address the address to add
	 */
	public void addAddress(Address address) {
		if(this.address == null) {
			this.address = new ArrayList<Address>();
		}
		this.address.add(address);
	}
	
	
	

}
