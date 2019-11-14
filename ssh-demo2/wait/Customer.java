package ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name="�Ȥ�ID")
	private String id; 
	
	@Column(name="���q�W��")
	private String name;
	
	@Column(name="�pô�H�m�W")
	private String contacter;
	
	@Column(name="�a�}")
	private String address;
	
	@Column(name="�q��")
	private String phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contacter=" + contacter + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	
}
