package com.firstleap.vo;

import java.util.ArrayList;
import java.util.List;


/**
 * @author LHY
 *
 */
public class FirstPregnantTypeVO {
	private String id;
	private String name;
	private String parentId;
	private String type;
	
	private List<FirstPregnantTypeVO> list = new ArrayList<FirstPregnantTypeVO>();
	
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
	public List<FirstPregnantTypeVO> getList() {
		return list;
	}
	public void setList(List<FirstPregnantTypeVO> list) {
		this.list = list;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}