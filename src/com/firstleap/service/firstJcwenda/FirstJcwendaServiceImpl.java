package com.firstleap.service.firstJcwenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.dao.firstJcwenda.IFirstJcwendaDao;
import com.firstleap.entity.po.FirstJcwenda;

@Transactional
@Service("FirstJcwendaServiceImpl")
public class FirstJcwendaServiceImpl extends BaseServiceImpl implements IFirstJcwendaService {
	private FirstJcwenda firstJcwenda;
	@Resource
	private IFirstJcwendaDao firstJcwendaDao;
	/**
	 * 根据ID查询
	 */
	public FirstJcwenda getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstJcwenda = firstJcwendaDao.get(id);
		}
		return firstJcwenda;
	}
	
	public Pagination findAllOrQuery(int pageNo, FirstJcwenda firstJcwenda) {
		String hql = "from FirstJcwenda l where 1 = 1";
		Map<String, Object> map = new HashMap<String, Object>();
		return firstJcwendaDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, map);
	}
	
	public Pagination findAllOrQueryi(int pageNo, FirstJcwenda firstJcwenda) {
		String hql = "from FirstJcwenda l where l = 1 ";
		return firstJcwendaDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	public List<FirstJcwenda> list(String hosid) {
		String hql = "from FirstJcwenda l where 1 = 1 ";
		return firstJcwendaDao.findByListHql(hql, hosid);
	}
	
	public String list(int size) {
		String hql = "from FirstJcwenda l where 1=1 order by createdDate desc";
		Pagination pagination = firstJcwendaDao.findByHql(hql, 0, size, null);
		return JSONArray.fromObject(pagination.getList()).toString();
	}
	
	/************************** 封装get set ***************************/

	public FirstJcwenda getFirstJcwenda() {
		return firstJcwenda;
	}

	public void setFirstJcwenda(FirstJcwenda firstJcwenda) {
		this.firstJcwenda = firstJcwenda;
	}	
}