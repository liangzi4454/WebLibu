package com.firstleap.service.firstyuerarticle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firstyuerarticle.IFirstYuerArticleDao;
import com.firstleap.entity.po.FirstYuerArticle;

@Transactional
@Service("FirstYuerArticleServiceImpl")
public class FirstYuerArticleServiceImpl extends BaseServiceImpl implements
		IFirstYuerArticleService {

	@Autowired
	private IFirstYuerArticleDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstYuerArticle yuerArticle;

	/*
	 * (non-Javadoc) 根据ID查询
	 * 
	 * @see
	 * net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.
	 * String)
	 */

	public FirstYuerArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			yuerArticle = dao.get(id);
		}
		return yuerArticle;
	}

	/*
	 * (non-Javadoc) 分页
	 * 
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo,
			FirstYuerArticle firstYuerArticle) {
		String hql = "from FirstYuerArticle l where 1 = 1 ";
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

	public Pagination findAllOrQueryi(int pageNo,
			FirstYuerArticle firstYuerArticle) {
		String hql = "from FirstYuerArticle l where l = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT,
				null);
	}

	public List<FirstYuerArticle> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstYuerArticle l where 1 = 1 ";
		return dao.findByListHql(hql, hosid);
	}

	public IFirstYuerArticleDao getDao() {
		return dao;
	}

	public void setDao(IFirstYuerArticleDao dao) {
		this.dao = dao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstYuerArticle getYuerArticle() {
		return yuerArticle;
	}

	public void setYuerArticle(FirstYuerArticle yuerArticle) {
		this.yuerArticle = yuerArticle;
	}
}