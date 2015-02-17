package com.firstleap.service.firstpregnantarticle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firstleap.common.constant.CategoryConstant;
import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.pagination.PaginationConstants;
import com.firstleap.common.service.BaseServiceImpl;
import com.firstleap.dao.firstpregnantarticle.IFirstPregnantArticleDao;
import com.firstleap.dao.firstpregnanttype.IFirstPregnantTypeDao;
import com.firstleap.entity.po.FirstPregnantArticle;
import com.firstleap.entity.po.FirstPregnantType;
import com.firstleap.vo.FirstPregnantArticleVO;
import com.firstleap.vo.FirstPregnantArticleVOList;

@Transactional
@Service("FirstPregnantArticleServiceImpl")
public class FirstPregnantArticleServiceImpl extends BaseServiceImpl implements IFirstPregnantArticleService {

	private FirstPregnantArticle firstPregnantArticle;
	@Resource
	private IFirstPregnantArticleDao firstPregnantArticleDao;
	@Resource
	private IFirstPregnantTypeDao firstPregnantTypeDao;

	/**
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	public FirstPregnantArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			firstPregnantArticle = firstPregnantArticleDao.get(id);
		}
		return firstPregnantArticle;
	}

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantArticle firstPregnantArticle) {
		String hql = "from FirstPregnantArticle l where 1 = 1 and l.pregnantId=:pregnantId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pregnantId", firstPregnantArticle.getPregnantId());
		return firstPregnantArticleDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, map);
	}

	/**
	 * 分页
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQueryi(int pageNo, FirstPregnantArticle firstPregnantArticle) {
		String hql = "from FirstPregnantArticle l where l = 1 ";
		return firstPregnantArticleDao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	public List<FirstPregnantArticle> list(String hosid) {
		String hql = "from FirstPregnantArticle l where 1 = 1 ";
		return firstPregnantArticleDao.findByListHql(hql, hosid);
	}

	public String list(int size) {
		String hql = "from FirstPregnantArticle l where 1=1 order by createdDate desc limit 3";
//		List<FirstPregnantArticle> list = firstPregnantArticleDao.findByListHql(hql);
		Pagination pagination = firstPregnantArticleDao.findByHql(hql, 0, size, null);
		return JSONArray.fromObject(pagination.getList()).toString();
	}
	
	public String findArticleCategoryList(int size, String id, String... ids) {
		if(size==0) {
			return "";
		} else if(ids==null || ids.length==0) {//StringUtils.isEmpty(id) || ids.length==0
			id = CategoryConstant.FirstPregnantType.PREGNANT_TYPE_1;
			ids = new String[] {
				CategoryConstant.FirstPregnantType.PREGNANT_TYPE_101,
				CategoryConstant.FirstPregnantType.PREGNANT_TYPE_102,
				CategoryConstant.FirstPregnantType.PREGNANT_TYPE_103,
				CategoryConstant.FirstPregnantType.PREGNANT_TYPE_104
			};
		}
		String aa = "";
		for(String str: ids) {
			aa += "'" + str + "',";
		}
		aa = aa.substring(0, aa.lastIndexOf(","));
		List<FirstPregnantArticleVOList> voListvo = new ArrayList<FirstPregnantArticleVOList>();
		String hql = "from FirstPregnantArticle f where 1=1 and f.pregnantId in("+aa+") order by createdDate asc, paixu asc";
//		List<FirstPregnantArticle> lista = firstPregnantArticleDao.findByListHql(hql);
		Pagination pagination1 = firstPregnantArticleDao.findByHql(hql, 0, size, null);
		List<FirstPregnantArticle> lista = pagination1.getList();
		List<FirstPregnantArticleVO> voLista = new ArrayList<FirstPregnantArticleVO>();
		for(FirstPregnantArticle article : lista) {
			FirstPregnantArticleVO vo = new FirstPregnantArticleVO();
			vo.setId(article.getId());
			vo.setTitle(article.getPregnantTitle());
			voLista.add(vo);
		}
		FirstPregnantArticleVOList firstPregnantArticleVOLista = new FirstPregnantArticleVOList();
		firstPregnantArticleVOLista.setList(voLista);
		voListvo.add(firstPregnantArticleVOLista);
		FirstPregnantType firstPregnantTypea = firstPregnantTypeDao.get(ids[0]);
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("id", ids[0]);
		mapa.put("name", firstPregnantTypea.getName());
		firstPregnantArticleVOLista.setMap(mapa);
		
		for(String str: ids) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("parentId", str);
			String hql2 = "from FirstPregnantArticle f where 1=1 and f.pregnantId =:parentId order by paixu asc, createdDate asc limit "+size;
			Pagination pagination = firstPregnantArticleDao.findByHql(hql2, 0, size, paramMap);
			List<FirstPregnantArticle> list = pagination.getList();
			if(list!=null && list.size()>0) {
				FirstPregnantArticleVOList firstPregnantArticleVOList = new FirstPregnantArticleVOList();
				List<FirstPregnantArticleVO> voList = new ArrayList<FirstPregnantArticleVO>();
				for(int i=0; i<list.size(); i++) {
					FirstPregnantArticle article = list.get(i);
					if(str.equals(article.getPregnantId())) {
						FirstPregnantArticleVO vo = new FirstPregnantArticleVO();
						vo.setId(article.getId());
						vo.setTitle(article.getPregnantTitle());
						voList.add(vo);
					}
				}
				FirstPregnantType firstPregnantType = firstPregnantTypeDao.get(str);
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", str);
				map.put("name", firstPregnantType.getName());
				firstPregnantArticleVOList.setMap(map);
				firstPregnantArticleVOList.setList(voList);
				voListvo.add(firstPregnantArticleVOList);
			}
		}
		return JSONArray.fromObject(voListvo).toString();
	}
	
	public String findHotArticle() {
		String hql = "FROM FirstPregnantArticle a WHERE (SELECT COUNT(*) FROM FirstPregnantArticle b WHERE b.pregnantId = a.pregnantId AND a.createdDate< b.createdDate) <1 ORDER BY paixu ASC, createdDate DESC";
		List<FirstPregnantArticle> list = firstPregnantArticleDao.findByListHql(hql);
		if(list.size()>9) {
			list = list.subList(0, 9);
		}
		return JSONArray.fromObject(list).toString();
	}
	
	public String findCategoryList(String id, int size) throws Exception {
		String hql = "from FirstPregnantType f where 1=1 and f.parentId is not null and f.parentId ='"+id+"'";
		List<FirstPregnantType> list = firstPregnantTypeDao.findByListHql(hql);
		String aa = "";
		for(FirstPregnantType firstPregnantType: list) {
			aa += "'" + firstPregnantType.getId() + "',";
		}
		aa = aa.substring(0, aa.lastIndexOf(","));
		List<FirstPregnantArticle> list2 = new ArrayList<FirstPregnantArticle>();
		if(aa.length()>0) {
			hql = "from FirstPregnantArticle f where 1=1 and f.pregnantId in ("+aa+") order by f.paixu asc, createdDate desc ";
			Pagination pagination = firstPregnantArticleDao.findByHql(hql, 0, size, null);
			list2 = pagination.getList();
		}
		return JSONArray.fromObject(list2).toString();
	}

	/************************** 封装get set ***************************/
	public FirstPregnantArticle getFirstPregnantArticle() {
		return firstPregnantArticle;
	}

	public void setFirstPregnantArticle(
			FirstPregnantArticle firstPregnantArticle) {
		this.firstPregnantArticle = firstPregnantArticle;
	}

}