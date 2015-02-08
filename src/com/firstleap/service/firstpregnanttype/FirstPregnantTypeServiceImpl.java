package com.firstleap.service.firstpregnanttype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.common.util.ContextPvd;
import com.firstleap.dao.firstpregnanttype.IFirstPregnantTypeDao;
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.vo.FirstPregnantTypeVO;

@Transactional
@Service("FirstPregnantTypeServiceImpl")
public class FirstPregnantTypeServiceImpl extends BaseServiceImpl implements
		IFirstPregnantTypeService {

	@Autowired
	private IFirstPregnantTypeDao firstPregnantTypeDao;

	@Autowired
	private ContextPvd contextPvdImpl;

	private FirstPregnantType firstPregnantType;

	/**
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	public FirstPregnantType getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstPregnantType = firstPregnantTypeDao.get(id);
		}
		return firstPregnantType;
	}

	/**
	 * 
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */
	public String deleteFirstPregnantType(String id) {
		String message = "";
		boolean flag = true;
		if (!(null == id || "".equals(id))) {
			try {
				flag = firstPregnantTypeDao.delete(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			message = "sccg";
		}
		return message;
	}

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantType firstPregnantType) {
		String hql = "from FirstPregnantType l where l.libuPregnantType = 1 ";
		return firstPregnantTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantType firstPregnantType) {
		String hql = "from FirstPregnantType l where l.libuPregnantType = 2 ";
		return firstPregnantTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	public List<FirstPregnantType> listFirstPregnantType(String hosid) {
		String hql = "from FirstPregnantType l where l.libuPregnantType = ? ";
		return firstPregnantTypeDao.findByListHql(hql, hosid);
	}

	/**
	 * 查询孕妇健康类别,调用一级二级分类
	 * @author LHY 2015-2-8 下午4:12:09
	 * @return Json
	 */
	public String findCategory() {
		List<FirstPregnantType> list = firstPregnantTypeDao.findByListHql("from FirstPregnantType f where 1=1 and (f.parentId is null or f.parentId = '')  and f.isDelete=0");
		List<FirstPregnantTypeVO> listVO = new ArrayList<FirstPregnantTypeVO>();
		if(list!=null && !list.isEmpty()) {
			for(FirstPregnantType type: list) {
				FirstPregnantTypeVO vo = new FirstPregnantTypeVO();
				vo.setId(type.getId());
				vo.setName(type.getName());
				List<FirstPregnantType> list2 = firstPregnantTypeDao.findByListHql("from FirstPregnantType f where 1=1 and f.parentId is not null and f.parentId='"+type.getId()+"' and f.isDelete=0");
				for(FirstPregnantType type2: list2) {
					FirstPregnantTypeVO vo1 = new FirstPregnantTypeVO();
					vo1.setId(type2.getId());
					vo1.setName(type2.getName());
					vo.getList().add(vo1);
				}
				listVO.add(vo);
			}
		}
		JSONArray json = JSONArray.fromObject(listVO);
		return json.toString();
	}
	/************************** 封装get set ***************************/
	public IFirstPregnantTypeDao getFirstPregnantTypeDao() {
		return firstPregnantTypeDao;
	}

	public void setFirstPregnantTypeDao(
			IFirstPregnantTypeDao firstPregnantTypeDao) {
		this.firstPregnantTypeDao = firstPregnantTypeDao;
	}

	public ContextPvd getContextPvdImpl() {
		return contextPvdImpl;
	}

	public void setContextPvdImpl(ContextPvd contextPvdImpl) {
		this.contextPvdImpl = contextPvdImpl;
	}

	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}

	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}
}