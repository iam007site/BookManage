package com.hsq.model.page;

/*
 *author:huangshanqi
 *time  :2014-8-3下午7:10:48
 *email :hsqmobile@gmail.com
 */

public class Criteria {
	/*
	 * 页查询标准类,
	 *  最大值：maxPrice ,
	 *  最小值：minPrice ,
	 *  当前页：pageNo,
	 */

	private float maxPrice = Integer.MAX_VALUE;
	private float minPrice = 0;
	private int pageNo;

	public Criteria() {
		super();
	}

	public Criteria(float maxPrice, float minPrice, int pageNo) {
		super();
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.pageNo = pageNo;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Criteria[minPrice="+minPrice+",maxPrice="+maxPrice+",pageNo="+pageNo+"]";
	}
	
	

}
