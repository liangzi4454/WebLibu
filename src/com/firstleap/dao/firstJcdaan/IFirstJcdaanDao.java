package com.firstleap.dao.firstJcdaan;

import com.firstleap.common.hibernate.BaseDao;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstJcdaan;

/**
 * 
 * @author LHY 2015-2-17 下午7:16:06
 */
public interface IFirstJcdaanDao extends BaseDao<FirstJcdaan> {
	Pagination queryByPagination(int pageNo, int pageSize, String aid);
}
