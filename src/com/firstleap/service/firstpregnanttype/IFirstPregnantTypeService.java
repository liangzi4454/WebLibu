package com.firstleap.service.firstpregnanttype;

import java.util.List;
import java.util.Map;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstPregnantType;

/**
 * @author zsc
 */
public interface IFirstPregnantTypeService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstPregnantType getByid(String id);

	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantType firstPregnantType);

	public Pagination findAllOrQueryi(int pageNo, FirstPregnantType firstPregnantType);

	List<FirstPregnantType> listFirstPregnantType(String hosid);
	/**
	 * 查询孕妇健康类别,递归调用一级二级分类
	 * @author LHY 2015-2-8 下午4:12:09
	 * @return Json
	 */
	public String findCategory();
}