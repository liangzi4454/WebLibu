package com.firstleap.service.firstpregnanttype;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.constant.CategoryConstant;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.dao.firstpregnanttype.IFirstPregnantTypeDao;
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.vo.FirstPregnantTypeVO;

@Transactional
@Service("FirstPregnantTypeServiceImpl")
public class FirstPregnantTypeServiceImpl extends BaseServiceImpl implements IFirstPregnantTypeService {

	@Resource
	private IFirstPregnantTypeDao firstPregnantTypeDao;
	
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
		List<FirstPregnantType> list = firstPregnantTypeDao.findByListHql("from FirstPregnantType f where 1=1 and f.typeId='"+CategoryConstant.FirstType.PREGNANT_MOTHER_STYLE+"' and (f.parentId is null or f.parentId = '') order by libuPregnantType asc, paixu asc, createdDate asc");
		List<FirstPregnantTypeVO> listVO = new ArrayList<FirstPregnantTypeVO>();
		if(list!=null && !list.isEmpty()) {
			for(FirstPregnantType type: list) {
				FirstPregnantTypeVO vo = new FirstPregnantTypeVO();
				vo.setId(type.getId());
				vo.setName(type.getName());
				vo.setType(type.getLibuPregnantType());
				List<FirstPregnantType> list2 = firstPregnantTypeDao.findByListHql("from FirstPregnantType f where 1=1 and f.typeId is null and f.parentId='"+type.getId()+"' order by paixu asc, createdDate asc");
				for(FirstPregnantType type2: list2) {
					FirstPregnantTypeVO vo1 = new FirstPregnantTypeVO();
					vo1.setId(type2.getId());
					vo1.setName(type2.getName());
					vo1.setParentId(type.getId());
					vo1.setType(type2.getLibuPregnantType());
					vo.getList().add(vo1);
				}
				listVO.add(vo);
			}
		}
		JSONArray json = JSONArray.fromObject(listVO);
		return json.toString();
	}
	
	/************************** 封装get set ***************************/
	public FirstPregnantType getFirstPregnantType() {
		return firstPregnantType;
	}

	public void setFirstPregnantType(FirstPregnantType firstPregnantType) {
		this.firstPregnantType = firstPregnantType;
	}
}