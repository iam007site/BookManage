package com.hsq.model.page;

import java.util.List;

/*
 *author:huangshanqi
 *time  :2014-8-3涓嬪崍6:48:23
 *email :hsqmobile@gmail.com
 */

public class Page<T> {
	/*
	 * 姣忎竴椤电被锛�
	 * 褰撳墠椤电爜锛歱ageNo
	 * 鍐呭鍒楄〃锛歭ists
	 * 椤甸潰鍐呭鏁扮洰:pageSize
	 * 鎬荤殑鍐呭鏁�totalItemNumber
	 */
	private int pageNo;
	private List<T> lists;
	private int pageSize;
	private int totalItemNumber;

	public Page() {
		super();
	}

	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}

	public Page(int pageNo, List<T> lists, int pageSize, int totalItemNumber) {
		super();
		this.pageNo = pageNo;
		this.lists = lists;
		this.pageSize = pageSize;
		this.totalItemNumber = totalItemNumber;
	}

	public int getPageNo() {
		if (pageNo <= 0)
			pageNo = 1;

		if (pageNo > getTotalpageNumber())
			pageNo = getTotalpageNumber();
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(int totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public boolean isHasNext() {
		if (getPageNo() == getTotalpageNumber())
			return false;
		return true;
	}

	public int getNext() {
		if (isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}

	public boolean isHasPrev() {
		if (getPageNo() == 1)
			return false;
		return true;
	}

	public int getPrev() {
		if (isHasPrev())
			return getPageNo() - 1;
		return getPageNo();
	}

	/*
	 * 鑾峰彇鎬荤殑椤垫暟
	 */
	public int getTotalpageNumber() {
		System.out.println("totalItemNumber="+totalItemNumber);
		int total = totalItemNumber / pageSize;
		if (totalItemNumber % pageSize != 0)
			total++;
		return total;
	}

}
