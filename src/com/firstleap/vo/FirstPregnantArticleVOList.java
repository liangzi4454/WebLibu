package com.firstleap.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author LHY 2015-2-10 下午9:44:29
 */
public class FirstPregnantArticleVOList {
	private Map<String, String> map = new HashMap<String, String>();
	private List<FirstPregnantArticleVO> list = new ArrayList<FirstPregnantArticleVO>();
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<FirstPregnantArticleVO> getList() {
		return list;
	}
	public void setList(List<FirstPregnantArticleVO> list) {
		this.list = list;
	}
}