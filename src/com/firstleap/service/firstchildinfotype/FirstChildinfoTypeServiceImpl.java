package com.firstleap.service.firstchildinfotype;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firstchildinfotype.IFirstChildinfoTypeDao;
import com.firstleap.entity.po.FirstChildinfoType;

@Transactional
@Service("FirstChildinfoTypeServiceImpl")
public class FirstChildinfoTypeServiceImpl extends BaseServiceImpl implements
IFirstChildinfoTypeService {

	@Autowired
	private IFirstChildinfoTypeDao dao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstChildinfoType childinfoType;
	/* (non-Javadoc)
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	
	public FirstChildinfoType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			childinfoType = dao.get(id);
		}
		return childinfoType;
	}
	
	/* (non-Javadoc)
	 * ɾ��
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	
	public String delete(String id) {
		// TODO Auto-generated method stub
		String message = "";
		boolean flag = true;
		if(!(null == id || "".equals(id))){
			try {
				
				flag = dao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 message ="sccg";
		}
		return message;
	}
	
	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoType firstChildinfoType) {
			String hql = "from FirstChildinfoType l where l.libuChildinfoType = 1 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}


	/* (non-Javadoc)
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoType firstChildinfoType) {
			String hql = "from FirstChildinfoType l where l.libuChildinfoType = 2 ";
			return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
		
	}
	
	
	
	public List<FirstChildinfoType> list(String hosid) {
		// TODO Auto-generated method stub
		String hql = "from FirstChildinfoType l where l.libuChildinfoType = ? ";
		return dao.findByListHql(hql, hosid);
		
	}




	

	
	
	/**************************封装get set***************************/
	
	public IFirstChildinfoTypeDao getDao() {
		return dao;
	}


	public void setDao(IFirstChildinfoTypeDao dao) {
		this.dao = dao;
	}


	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}


	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}


	public FirstChildinfoType getChildinfoType() {
		return childinfoType;
	}


	public void setChildinfoType(FirstChildinfoType childinfoType) {
		this.childinfoType = childinfoType;
	}


	
	
}
