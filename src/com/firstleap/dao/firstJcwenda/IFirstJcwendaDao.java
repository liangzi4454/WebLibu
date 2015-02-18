package com.firstleap.dao.firstJcwenda;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstJcwenda;
/**
 * 
 * @author LHY 2015-2-17 下午4:12:33
 */
public interface IFirstJcwendaDao extends BaseDao<FirstJcwenda> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
}
