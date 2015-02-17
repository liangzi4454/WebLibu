package com.firstleap.service.firsttype;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstType;

/**
 * @author zsc
 * 
 */
public interface IFirstTypeService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstType getByid(String id);

	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstType firstType);
	public Pagination findAllOrQueryi(int pageNo, FirstType firstType);
	public List<FirstType> listFirstBumen(String hosid);
	/**
	 * 查询顶部菜单
	 * @author LHY 2015-2-15 上午11:44:24
	 * @return
	 * @throws Exception
	 */
	public String findIndexMenu() throws Exception;
}