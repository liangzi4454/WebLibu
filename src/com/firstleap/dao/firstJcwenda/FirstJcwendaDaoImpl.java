package com.firstleap.dao.firstJcwenda;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstJcwenda;

/**
 * @author LHY
 * @param <T>
 */
@Repository("FirstJcwendaDaoImpl")
public class FirstJcwendaDaoImpl extends BaseDaoImpl<FirstJcwenda> implements IFirstJcwendaDao  {

	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstJcwenda where id='"+aid+"'";
		hql += " ORDER BY id asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
	
}
