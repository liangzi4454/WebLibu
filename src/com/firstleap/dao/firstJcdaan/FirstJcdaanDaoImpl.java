package com.firstleap.dao.firstJcdaan;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstJcdaan;

/**
 * 
 * @author LHY 2015-2-17 下午7:16:27
 */
@Repository
public class FirstJcdaanDaoImpl extends BaseDaoImpl<FirstJcdaan> implements IFirstJcdaanDao {
	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstJcdaan where id='"+aid+"'";
		hql += " ORDER BY id asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
}
