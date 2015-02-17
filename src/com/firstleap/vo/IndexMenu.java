package com.firstleap.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类用于加载顶部菜单
 * @author LHY 2015-2-15 上午11:52:29
 */
@SuppressWarnings("all")
public class IndexMenu implements Serializable {
	private String id;
	private String name;
	private String type;
	private List<IndexMenu> list = new ArrayList<IndexMenu>();
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<IndexMenu> getList() {
		return list;
	}
	public void setList(List<IndexMenu> list) {
		this.list = list;
	}
}