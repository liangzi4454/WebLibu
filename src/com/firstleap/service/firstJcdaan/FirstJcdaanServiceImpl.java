package com.firstleap.service.firstJcdaan;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.dao.firstJcdaan.IFirstJcdaanDao;
import com.firstleap.entity.po.FirstJcdaan;

/**
 * 
 * @author LHY 2015-2-17 下午7:13:56
 */
@Service("FirstJcdaanServiceImpl")
public class FirstJcdaanServiceImpl extends BaseServiceImpl implements IFirstJcdaanService {
	@Resource
	private IFirstJcdaanDao firstJcdaanDao;
	/**
	 * @author LHY 2015-2-17 下午7:18:41
	 * @see com.firstleap.service.firstJcdaan.IFirstJcdaanService#get(java.lang.String)
	 */
	public FirstJcdaan get(String id) throws Exception {
		FirstJcdaan firstJcdaan = firstJcdaanDao.get(id);
		return firstJcdaan;
	}
	/**
	 * @author LHY 2015-2-17 下午7:30:45
	 * @see com.firstleap.service.firstJcdaan.IFirstJcdaanService#findList(java.lang.String)
	 */
	public List<FirstJcdaan> findList(String id) throws Exception {
		String hql = "from FirstJcdaan f where 1=1 and f.wendaId = '"+id+"'";
		Pagination pagination = firstJcdaanDao.findByHql(hql, 0, 1, null);
		return pagination.getList();
	}
}