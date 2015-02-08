package com.firstleap.service.firsttype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firsttype.IFirstTypeDao;
import com.firstleap.entity.po.FirstType;

@Transactional
@Service("FirstTypeServiceImpl")
public class FirstTypeServiceImpl extends BaseServiceImpl implements
		IFirstTypeService {

	@Autowired
	private IFirstTypeDao firstTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstType firstType;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstType getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstType = firstTypeDao.get(id);
		}
		return firstType;
	}

	/*
	 * (non-Javadoc) ɾ��
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java
	 * .lang.String)
	 */

	public String deleteFirstType(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if (!(null == id || "".equals(id))) {
			try {
				flag = firstTypeDao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			message = "sccg";
		}
		return message;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo, FirstType firstType) {
		String hql = "from FirstType l where l.libuTypeType = 1 ";
		return firstTypeDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);

	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQueryi(int pageNo, FirstType firstType) {
		String hql = "from FirstType l where l.libuTypeType = 2 ";
		return firstTypeDao.findByHql(hql, pageNo,
				PaginationConstants.PAGE_DEFAULT, null);

	}

	public List<FirstType> listFirstBumen(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstType where libuTypeType = ? ";
		return firstTypeDao.findByListHql(hql, hosid);

	}

	/************************** 封装get set ***************************/
	public IFirstTypeDao getFirstTypeDao() {
		return firstTypeDao;
	}

	public void setFirstTypeDao(IFirstTypeDao firstTypeDao) {
		this.firstTypeDao = firstTypeDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}
}