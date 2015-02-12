package com.firstleap.service.firstchildinfotype;

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
import com.firstleap.dao.firstchildinfotype.IFirstChildinfoTypeDao;
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.vo.FirstPregnantTypeVO;

@Transactional
@Service("FirstChildinfoTypeServiceImpl")
public class FirstChildinfoTypeServiceImpl extends BaseServiceImpl implements IFirstChildinfoTypeService {

	@Resource
	private IFirstChildinfoTypeDao dao;
	
	private FirstChildinfoType childinfoType;
	
	public FirstChildinfoType getByid(String id) {
		if(null == id || id.trim().length() ==0){
			return null;
		}else{
			childinfoType = dao.get(id);
		}
		return childinfoType;
	}
	
	public String delete(String id) {
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
	
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoType firstChildinfoType) {
		String hql = "from FirstChildinfoType l where l.libuChildinfoType = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoType firstChildinfoType) {
		String hql = "from FirstChildinfoType l where l.libuChildinfoType = 2 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}
	
	public List<FirstChildinfoType> list(String hosid) {
		String hql = "from FirstChildinfoType l where l.libuChildinfoType = ? ";
		return dao.findByListHql(hql, hosid);
	}
	/**
	 * 查询婴幼儿健康类别,调用一级二级分类
	 * @author LHY 2015-2-12 下午4:12:09
	 * @return Json
	 */
	public String findCategory() {
		List<FirstChildinfoType> list = dao.findByListHql("from FirstChildinfoType f where 1=1 and f.typeId='"+CategoryConstant.FirstType.CHILD_REARING_STYLE+"' and (f.parentId is null or f.parentId = '') order by libuChildinfoType asc, paixu asc, createdDate asc");
		List<FirstPregnantTypeVO> listVO = new ArrayList<FirstPregnantTypeVO>();
		if(list!=null && !list.isEmpty()) {
			for(FirstChildinfoType type: list) {
				FirstPregnantTypeVO vo = new FirstPregnantTypeVO();
				vo.setId(type.getId());
				vo.setName(type.getName());
				vo.setType(type.getLibuChildinfoType());
				List<FirstChildinfoType> list2 = dao.findByListHql("from FirstChildinfoType f where 1=1 and f.typeId is null and f.parentId='"+type.getId()+"' order by paixu asc, createdDate asc");
				for(FirstChildinfoType type2: list2) {
					FirstPregnantTypeVO vo1 = new FirstPregnantTypeVO();
					vo1.setId(type2.getId());
					vo1.setName(type2.getName());
					vo1.setParentId(type.getId());
					vo1.setType(type2.getLibuChildinfoType());
					vo.getList().add(vo1);
				}
				listVO.add(vo);
			}
		}
		JSONArray json = JSONArray.fromObject(listVO);
		return json.toString();
	}
	/**************************封装get set***************************/
	public FirstChildinfoType getChildinfoType() {
		return childinfoType;
	}

	public void setChildinfoType(FirstChildinfoType childinfoType) {
		this.childinfoType = childinfoType;
	}
}