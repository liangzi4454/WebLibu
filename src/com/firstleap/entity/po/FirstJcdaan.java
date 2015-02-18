package com.firstleap.entity.po;

import java.util.Date;

/**
 * javabean。
 * 
 * 医院表
 * 
 * @author 张世超
 * 
 * @param <T>
 */
@SuppressWarnings("serial")
public class FirstJcdaan implements java.io.Serializable {

	private String id; // 主键ID
	private String name; // 问答答案
	private String wendaId;
	@Deprecated
	private FirstJcwenda firstJcwenda; // 答案对应问题
	private Date createdDate; // 增加时间
	private Date updatedDate; // 修改时间
	private long paixu; // 排序
	private String libuType;

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

	public FirstJcwenda getFirstJcwenda() {
		return firstJcwenda;
	}

	public void setFirstJcwenda(FirstJcwenda firstJcwenda) {
		this.firstJcwenda = firstJcwenda;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getPaixu() {
		return paixu;
	}

	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}
	
	public String getLibuType() {
		return libuType;
	}

	public void setLibuType(String libuType) {
		this.libuType = libuType;
	}

	public String getWendaId() {
		return wendaId;
	}

	public void setWendaId(String wendaId) {
		this.wendaId = wendaId;
	}
}