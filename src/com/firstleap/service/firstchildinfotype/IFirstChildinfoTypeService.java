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
	public Pagination findAllOrQuery(int pageNo,
			FirstChildinfoType childinfoType);

	public Pagination findAllOrQueryi(int pageNo,
			FirstChildinfoType childinfoType);

	List<FirstChildinfoType> list(String hosid);

}
