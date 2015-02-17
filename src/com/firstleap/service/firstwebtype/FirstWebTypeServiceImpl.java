package com.firstleap.service.firstwebtype;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.common.util.EntityTool;
import com.firstleap.common.util.Tools;
import com.firstleap.dao.firstwebtype.IFirstWebTypeDao;
import com.firstleap.entity.po.FirstWebType;

@Transactional
@Service("FirstWebTypeServiceImpl")
public class FirstWebTypeServiceImpl extends BaseServiceImpl implements
		IFirstWebTypeService {

	@Autowired
	private IFirstWebTypeDao firstWebTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstWebType firstWebType;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstWebType getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstWebType = firstWebTypeDao.get(id);
		}
		return firstWebType;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo, FirstWebType firstWebType) {
		String hql = "from FirstWebType l where l.libuWebType = 1 ";
		return firstWebTypeDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);

	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQueryi(int pageNo, FirstWebType firstWebType) {
		String hql = "from FirstWebType l where l.libuWebType = 2 ";
		return firstWebTypeDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);

	}

	public List<FirstWebType> listFirstWebType(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstWebType l where l.libuWebType = ? ";
		return firstWebTypeDao.findByListHql(hql, hosid);

	}
	/************************** 封装get set ***************************/
	public IFirstWebTypeDao getFirstWebTypeDao() {
		return firstWebTypeDao;
	}

	public void setFirstWebTypeDao(IFirstWebTypeDao firstWebTypeDao) {
		this.firstWebTypeDao = firstWebTypeDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstWebType getFirstWebType() {
		return firstWebType;
	}

	public void setFirstWebType(FirstWebType firstWebType) {
		this.firstWebType = firstWebType;
	}
}