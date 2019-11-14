package ssh.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;

import ssh.entity.Book;
import ssh.entity.Customer;
import ssh.entity.Employee;
import ssh.entity.Order;
import ssh.entity.Products;
import ssh.entity.Shipping;
import ssh.entity.Detail;
@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrder(Order order) {
		getSession().save(order);
	}
	
	@Override
	public void saveDetail(Detail detail) {
		getSession().save(detail);
	}
	/**
	 * 	���~�C��
	 * */
	@Override
	public List<Products> getProducts() {
		String hql = "FROM product";
		return getSession().createQuery(hql).list();
	}
	/**
	 * 	�q��C��
	 * */
	@Override
	public List<Order> getOrders() {
		String hql="FROM orders";
		return getSession().createQuery(hql).list();
	}
	/**
	 * 	�U�ȦC��
	 * */
	@Override
	public List<Customer> getCustomers() {
		String hql="FROM customer c";
		return getSession().createQuery(hql).list();
	}

	/**
	 * 	�����C��
	 * */
	@Override
	public List<Employee> getEmployees() {
		String hql="FROM employee ";
		return getSession().createQuery(hql).list();
	}

	/**
	 * 	�B�e�ӦC��
	 * */
	@Override
	public List<Shipping> getShippings() {
		String hql="FROM shipping ";
		return getSession().createQuery(hql).list();
	}
	/**
	 * 	�z�L Order.id ���o���� Detail �ƾ�
	 * */
	@Override
	public List<Detail> getDetails(Integer id) {
		String hql="FROM detail d where d.id = ? ";
		return getSession().createQuery(hql).setInteger(0, id).list();
	}
	/**
	 * 	�z�L Order.id ���o Order ���
	 * */
	@Override
	public Order getOrderById(int id) {
		Order order = getSession().get(Order.class, id);
		return order;
	}
	/**
	 * 	�z�L Order.id �R�� Order ���
	 * */
	@Override
	public void deleteOrderById(int id) {	
		String hql = "Delete orders where id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	/**
	 * 	�z�L Order.id ��s Order ���
	 * */
	@Override
	public void update(Order order) {
		String hql="Update orders o SET o.customer.id=?,o.employee.id=?,o.order_name=?,o.order_address=?,o.shipping.id=? WHERE o.id=?";
		
		getSession().createQuery(hql).setEntity(0, order.getCustomer()).setEntity(1, order.getEmployee()).setString(2, order.getOrder_name()).
		setString(3,order.getOrder_address()).setEntity(4, order.getShipping()).setInteger(5, order.getId()).executeUpdate();
		
	}
	/**
	 * 	Order �����C��
	 * */
	public List<Order> getPagelist(int offset,int size){
		List<Order> booklist = null;
		String hql = "FROM orders";
		Query query = getSession().createQuery(hql);
		booklist=query.setFirstResult(offset).setMaxResults(size).list();
		return booklist;
	}
	/**
	 * 	���o Order �`�ƶq
	 * */
	public Long getAllRecord() {
		String hql = "SELECT COUNT(*) FROM orders";
		Query query = getSession().createQuery(hql);
		return Long.parseLong(query.uniqueResult().toString());
	}
	/**
	 * 	��^��������� Order list
	 * */
	public List<Order> getMonth(Integer month){
		String hql = "FROM orders o WHERE YEAR(o.orderTime) = YEAR(?) AND MONTH(o.orderTime) = MONTH(?)";
		Query query = getSession().createQuery(hql).setDate(0,new Date(97,month - 1,1)).setDate(1,new Date(97,month - 1,1));
		return query.list();
	}


	/**
	 * 	�z�L order.id ��^�@�ӥ� product.id �M product.amount �Ҳզ��� List<Map>
	 * */
	@Override
	public List<Map<Integer,Integer>> getDetailMap(Integer id) {
		String hql = "SELECT new map(d.product.id as id , d.amount as amount) FROM detail d WHERE d.order.id in :o_id";
		Query query = getSession().createQuery(hql).setParameterList("o_id", getMonthID(id));
		return query.list();
	}
	/**
	 * 	��^��������� Order.id
	 * */
	@Override
	public List<Integer> getMonthID(Integer month) {
		String hql = "SELECT o.id FROM orders o WHERE YEAR(o.orderTime) = YEAR(?) AND MONTH(o.orderTime) = MONTH(?)";
		Query query = getSession().createQuery(hql).setDate(0,new Date(97,month - 1,1)).setDate(1,new Date(97,month - 1,1));
		return query.list();
	}
	
	/**
	 * 	�z�L order.id ��^�� Order �����B
	 *
	 */
	@Override
	public Integer getDetailSum(Integer id) {
		String hql = "SELECT SUM(d.amount * d.price) FROM detail d WHERE d.order.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
	/**
	 * 	
	 * 	�z�L��J�~�M����oOrder.id
	 * 
	@Override
	public List<Integer> getOrderDate(String year,String month) {
		String hql = "SELECT o.id FROM orders o WHERE o.orderTime LIKE CONCAT(?,'-',?,'%') ";
		return getSession().createQuery(hql).setString(0, year).setString(1, month).list();
	}
	
	*/

}
