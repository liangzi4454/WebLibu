package com.firstleap.vo;

/**
 * 
 * @author LHY 2015-2-10 下午11:18:34
 */
public class FirstPregnantArticleVO {

	/** 二级类型id **/
	private String id;
	/** 二级类型标题 **/
	private String title;
	/** 二级类型概要 **/
	private String summary;
	/** 图片地址**/
	private String picUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
