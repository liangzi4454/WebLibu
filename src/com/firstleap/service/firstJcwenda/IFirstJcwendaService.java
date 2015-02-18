package com.firstleap.service.firstJcwenda;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstJcwenda;

/**
 * @author LHY
 */
public interface IFirstJcwendaService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	public FirstJcwenda getByid(String id);
	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstJcwenda firstJcwenda);

	public Pagination findAllOrQueryi(int pageNo, FirstJcwenda firstJcwenda);

	public List<FirstJcwenda> list(String hosid);
	
	public String list(int size);
}