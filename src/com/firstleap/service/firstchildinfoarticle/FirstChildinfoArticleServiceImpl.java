package com.firstleap.service.firstchildinfoarticle;

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
import com.firstleap.dao.firstchildinfoarticle.IFirstChildinfoArticleDao;
import com.firstleap.dao.firstchildinfotype.IFirstChildinfoTypeDao;
import com.firstleap.entity.po.FirstChildinfoArticle;
import com.firstleap.entity.po.FirstChildinfoType;
import com.firstleap.vo.FirstPregnantArticleVO;
import com.firstleap.vo.FirstPregnantArticleVOList;

@Transactional
@Service("FirstChildinfoArticleServiceImpl")
public class FirstChildinfoArticleServiceImpl extends BaseServiceImpl implements IFirstChildinfoArticleService {

	@Resource
	private IFirstChildinfoArticleDao dao;
	@Resource
	private IFirstChildinfoTypeDao firstChildinfoTypeDao;
	
	private FirstChildinfoArticle childinfoArticle;

	/**
	 * 根据ID查询
	 * @see net.ltak.service.vaccintion.ILtakVaccintionService#getByid(java.lang.String)
	 */
	public FirstChildinfoArticle getByid(String id) {
		if (null == id || id.trim().length() == 0) {
			return null;
		} else {
			childinfoArticle = dao.get(id);
		}
		return childinfoArticle;
	}

	/**
	 * @see net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int, net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoArticle firstChildinfoArticle) {
		String hql = "from FirstChildinfoArticle l where 1 = 1 and l.parentId=:parentId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", firstChildinfoArticle.getParentId());
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, map);
	}

	/**
	 * @see
	 * net.ltak.service.childinfo.ILtakChildinfoService#findAllOrQueryAll(int,
	 * net.ltak.entity.po.LtakChildinfo)
	 */
	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoArticle firstChildinfoArticle) {
		String hql = "from FirstChildinfoArticle l where l = 1 ";
		return dao.findByHql(hql, pageNo, PaginationConstants.PAGE_DEFAULT, null);
	}

	public List<FirstChildinfoArticle> list(String hosid) {
		String hql = "from FirstChildinfoArticle l where 1=1 and l.parentId=? order by createdDate desc";
		return dao.findByListHql(hql, hosid);
	}
	
	public String list(int size) {
		String hql = "from FirstChildinfoArticle l where 1=1 order by createdDate desc";
		Pagination pagination = dao.findByHql(hql, 0, size, null);
		return JSONArray.fromObject(pagination.getList()).toString();
	}

	public String findArticleCategoryList(int size, String id, String... ids) {
		if(size==0) {
			return "";
		} else if(ids==null || ids.length==0) {//StringUtils.isEmpty(id) || ids.length==0
			id = CategoryConstant.FirstChildinfoType.CHILDINFO_TYPE_1;
			ids = new String[] {
				//CategoryConstant.FirstChildinfoType.CHILDINFO_TYPE_101,
				CategoryConstant.FirstChildinfoType.CHILDINFO_TYPE_102,
				CategoryConstant.FirstChildinfoType.CHILDINFO_TYPE_103,
				CategoryConstant.FirstChildinfoType.CHILDINFO_TYPE_104
			};
		}
		String aa = "";
		for(String str: ids) {
			aa += "'" + str + "',";
		}
		aa = aa.substring(0, aa.lastIndexOf(","));
		List<FirstPregnantArticleVOList> voListvo = new ArrayList<FirstPregnantArticleVOList>();
		String hql = "from FirstChildinfoArticle f where 1=1 and f.parentId in("+aa+") order by createdDate asc, paixu asc limit 6";
		List<FirstChildinfoArticle> lista = dao.findByListHql(hql);
		List<FirstPregnantArticleVO> voLista = new ArrayList<FirstPregnantArticleVO>();
		for(FirstChildinfoArticle article : lista) {
			FirstPregnantArticleVO vo = new FirstPregnantArticleVO();
			vo.setId(article.getId());
			vo.setTitle(article.getChildinfoTitle());
			voLista.add(vo);
		}
		FirstPregnantArticleVOList firstPregnantArticleVOLista = new FirstPregnantArticleVOList();
		firstPregnantArticleVOLista.setList(voLista);
		voListvo.add(firstPregnantArticleVOLista);
		FirstChildinfoType firstPregnantTypea = firstChildinfoTypeDao.get(ids[0]);
		Map<String, String> mapa = new HashMap<String, String>();
		mapa.put("id", ids[0]);
		mapa.put("name", firstPregnantTypea.getName());
		firstPregnantArticleVOLista.setMap(mapa);
		
		for(String str: ids) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("parentId", str);
			String hql2 = "from FirstChildinfoArticle f where 1=1 and f.parentId =:parentId order by paixu asc, createdDate asc limit "+size;
			Pagination pagination = dao.findByHql(hql2, 0, size, paramMap);
			List<FirstChildinfoArticle> list = pagination.getList();
			if(list!=null && list.size()>0) {
				FirstPregnantArticleVOList firstPregnantArticleVOList = new FirstPregnantArticleVOList();
				List<FirstPregnantArticleVO> voList = new ArrayList<FirstPregnantArticleVO>();
				for(int i=0; i<list.size(); i++) {
					FirstChildinfoArticle article = list.get(i);
					if(str.equals(article.getParentId())) {
						FirstPregnantArticleVO vo = new FirstPregnantArticleVO();
						vo.setId(article.getId());
						vo.setTitle(article.getChildinfoTitle());
						voList.add(vo);
					}
				}
				FirstChildinfoType firstPregnantType = firstChildinfoTypeDao.get(str);
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
		String hql = "from FirstChildinfoArticle a WHERE (SELECT COUNT(*) FROM FirstChildinfoArticle b WHERE b.parentId = a.parentId AND a.createdDate< b.createdDate) <1 ORDER BY paixu ASC, createdDate DESC";
		List<FirstChildinfoArticle> list = dao.findByListHql(hql);
		if(list.size()>9) {
			list = list.subList(0, 9);
		}
		return JSONArray.fromObject(list).toString();
	}
	/************************** 封装get set ***************************/
	
	public FirstChildinfoArticle getChildinfoArticle() {
		return childinfoArticle;
	}

	public void setChildinfoArticle(FirstChildinfoArticle childinfoArticle) {
		this.childinfoArticle = childinfoArticle;
	}
}