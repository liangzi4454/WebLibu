package com.firstleap.entity.po;

import java.util.Date;

/**
 * 孕妇健康类别
 * @author 张世超
 * @param <T>
 */
@SuppressWarnings("serial")
public class FirstPregnantType implements java.io.Serializable {

	private String id; // 主键ID
	private String name; // 菜单名称
	private String parentId; // 上级ID
	private String libuPregnantType; // 类型--> 1：备孕、2：孕早、3：孕中、4：孕晚、5：分娩、6：月子。
	@Deprecated
	private FirstType firstType; // 分类表ID
	private String typeId;
	private String isDelete; // 是否删除
	private Date createdDate; // 增加时间
	private Date updatedDate; // 修改时间
	private long paixu; // 排序

	public long getPaixu() {
		return paixu;
	}

	public void setPaixu(long paixu) {
		this.paixu = paixu;
	}

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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getLibuPregnantType() {
		return libuPregnantType;
	}
	public void setLibuPregnantType(String libuPregnantType) {
		this.libuPregnantType = libuPregnantType;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
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
	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
}