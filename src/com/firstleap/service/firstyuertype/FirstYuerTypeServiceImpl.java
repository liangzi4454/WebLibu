package com.firstleap.service.firstyuertype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firstyuertype.IFirstYuerTypeDao;
import com.firstleap.entity.po.FirstYuerType;

@Transactional
@Service("FirstYuerTypeServiceImpl")
public class FirstYuerTypeServiceImpl extends BaseServiceImpl implements
		IFirstYuerTypeService {

	@Autowired
	private IFirstYuerTypeDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstYuerType yuerType;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstYuerType getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			yuerType = dao.get(id);
		}
		return yuerType;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo, FirstYuerType firstYuerType) {
		String hql = "from FirstYuerType l where l.libuChildinfoType = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT,
				null);

	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQueryi(int pageNo, FirstYuerType firstYuerType) {
		String hql = "from FirstYuerType l where l.libuChildinfoType = 2 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT,
				null);

	}

	public List<FirstYuerType> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstYuerType l where l.libuChildinfoType = ? ";
		return dao.findByListHql(hql, hosid);

	}

	public IFirstYuerTypeDao getDao() {
		return dao;
	}

	public void setDao(IFirstYuerTypeDao dao) {
		this.dao = dao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstYuerType getYuerType() {
		return yuerType;
	}

	public void setYuerType(FirstYuerType yuerType) {
		this.yuerType = yuerType;
	}
}