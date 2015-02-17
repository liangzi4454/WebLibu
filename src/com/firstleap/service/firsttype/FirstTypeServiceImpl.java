package com.firstleap.service.firsttype;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.dao.firsttype.IFirstTypeDao;
import com.firstleap.entity.po.FirstType;
import com.firstleap.vo.IndexMenu;

@Transactional
@Service("FirstTypeServiceImpl")
public class FirstTypeServiceImpl extends BaseServiceImpl implements IFirstTypeService {

	private FirstType firstType;
	@Resource
	private IFirstTypeDao firstTypeDao;

	/**
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	public FirstType getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstType = firstTypeDao.get(id);
		}
		return firstType;
	}

	/**
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#deleteChildinfo(java.lang.String)
	 */

	public String deleteFirstType(String id) {
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

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQuery(int pageNo, FirstType firstType) {
		String hql = "from FirstType l where l.libuTypeType = 1 ";
		return firstTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */

	public Pagination findAllOrQueryi(int pageNo, FirstType firstType) {
		String hql = "from FirstType l where l.libuTypeType = 2 ";
		return firstTypeDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}
	
	public String findIndexMenu() throws Exception {
		String hql= "from FirstType f where 1=1 and f.parentId is null or f.parentId = '' order by f.paixu asc, f.createdDate desc";
		List<IndexMenu> menuList = new ArrayList<IndexMenu>();
		List<FirstType> list = firstTypeDao.findByListHql(hql);
		findIndexMenu(list, menuList);
		return JSONArray.fromObject(menuList).toString();
	}
	private void findIndexMenu(List<FirstType> list, List<IndexMenu> menuList) {
		if(list!=null && list.size()>0) {
			for(FirstType firstType: list) {
				IndexMenu indexMenu = new IndexMenu();
				indexMenu.setId(firstType.getId());
				indexMenu.setName(firstType.getName());
				indexMenu.setType(firstType.getLibuTypeType());
				menuList.add(indexMenu);
				String hql= "from FirstType f where 1=1 and f.parentId is not null and f.parentId != '' and f.parentId='"+firstType.getId()+"'order by f.paixu asc, f.createdDate desc";
				List<FirstType> list2 = firstTypeDao.findByListHql(hql);
				List<IndexMenu> menuList2 = new ArrayList<IndexMenu>();
				if(list2!=null && list2.size()>0) {
					for(FirstType firstType2: list2) {
						IndexMenu indexMenu2 = new IndexMenu();
						indexMenu2.setId(firstType2.getId());
						indexMenu2.setName(firstType2.getName());
						indexMenu2.setType(firstType2.getLibuTypeType());
						menuList2.add(indexMenu2);
					}
				}
				indexMenu.setList(menuList2);
			}
		}
	}
	private void findIndexMenu(FirstType firstType, List<IndexMenu> menuList) {
		/**/
		
	}
	
	public List<FirstType> listFirstBumen(String hosid) {
		String hql = "from FirstType where libuTypeType = ? ";
		return firstTypeDao.findByListHql(hql, hosid);
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}
}