package com.firstleap.service.firstchildinfotype;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoType;

/**
 * @author zsc
 * 
 */
public interface IFirstChildinfoTypeService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstChildinfoType getByid(String id);
	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoType childinfoType);
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoType childinfoType);
	List<FirstChildinfoType> list(String hosid);
	/**
	 * 查询婴幼儿健康类别,递归调用一级二级分类
	 * @author LHY 2015-2-12 下午4:41:39
	 * @return Json
	 */
	public String findCategory();
}