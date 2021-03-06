package com.firstleap.dao.firstuserregister;

import org.springframework.stereotype.Repository;

import com.firstleap.common.hibernate.BaseDaoImpl;
import com.firstleap.common.hibernate.Finder;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.entity.po.FirstUserRegister;

/**
 *
 * 
 *
 * 
 * @author 
 * 
 * @param <T>
 */
@Repository("FirstUserRegisterDaoImpl")
public class FirstUserRegisterDaoImpl extends BaseDaoImpl<FirstUserRegister> implements IFirstUserRegisterDao  {

	/* (non-Javadoc)
	 * @see net.bjstd.entity.system.commdatadict.dao.ICommdataDictDao#queryByPagination(int, int, java.lang.String)
	 * 
	 */
	public Pagination queryByPagination(int pageNo, int pageSize, String aid) {
		String hql = "from FirstHospital where hospitalId='"+aid+"'";
		hql += " ORDER BY hospitalId asc";
		Finder finder = Finder.create(hql);
		return find(finder, pageNo, pageSize);
	}
	
}
