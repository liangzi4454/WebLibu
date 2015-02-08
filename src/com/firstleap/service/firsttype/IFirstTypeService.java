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

	List<FirstType> listFirstBumen(String hosid);
}