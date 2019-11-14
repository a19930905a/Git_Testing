package ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="shipping")
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "�B�f��ID")
	private Integer id;
	
	@Column(name = "���q�W��")
	private String name;
	
	@Column(name = "�q��")
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
