package com.hsq.model.page;

/*
 *author:huangshanqi
 *time  :2014-8-3下午7:10:48
 *email :hsqmobile@gmail.com
 */

public class Criteria {
	/*
	 * 页查询标准类,
	 *  最大值：max ,
	 *  最小值：min ,
	 *  当前页：pageNo,
	 */

	private float max = Integer.MAX_VALUE;
	private float min = 0;
	private int pageNo;

	public Criteria() {
		super();
	}

	public Criteria(float max, float min, int pageNo) {
		super();
		this.max = max;
		this.min = min;
		this.pageNo = pageNo;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
