package ssh.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "employee")
@Table(name = "employee")
public class Employee {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="����ID")
	private Integer id;
	
	@Column(name = "�W�r")
	private String name;
	
	@Column(name = "���q�a�}")
	private String address;
	
	@Column(name = "���q�q��")
	private String phone;
	
	@Column(name = "����")
	private String extension;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}



}
