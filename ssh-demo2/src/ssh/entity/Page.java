package ssh.entity;

import java.util.List;

public class Page<E> {
	//�e�{�������������M��
	private List<E> list;
	//�ƾ��`��
	private int totalRecord;
	//�ثe������No
	private int pageNo;
	//�C�@���n�e�{�h�ּƾ�
	private int pageSize;
	
	/**
	 * 	�������`������
	 * */
	public int getTotalPage() {
		int total = (totalRecord + pageSize - 1 )/pageSize;
		return total;
	}
	
	/**
	 * 	��e�� offset,����n��JHibernate setFirstResult ��
	 * */
	public int countOffset(int currentPage,int pageSize) {
		int offset = pageSize*(currentPage-1);
		return offset;
	}
	
	/**
	 * 	����
	 * */
	public int getTopPageNo() {
		return 1;
	}
	
	/**
	 * 	����
	 * */
	public int getLastPageNo() {
		return getTotalPage();
	}
	/**
	 * 	�W�@��
	 * 
	 * */
	public int getPreviousPageNo() {
		if(pageNo<=1) {
			return 1;
		}
		return pageNo-1;
	}
	
	/**
	 * 	 �U�@��
	 * */
	public int getNextPageNo() {
		if(pageNo>=getLastPageNo()) {
			return getLastPageNo();
		}
		return pageNo+1;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
