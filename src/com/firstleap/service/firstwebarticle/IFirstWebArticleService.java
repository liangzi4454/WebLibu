package com.firstleap.service.firstwebarticle;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstWebArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstWebArticleService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstWebArticle getByid(String id);

	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstWebArticle firstWebArticle);

	public Pagination findAllOrQueryi(int pageNo, FirstWebArticle firstWebArticle);

	List<FirstWebArticle> list(String hosid);
	/**
	 * 今日头条
	 * @author LHY 2015-2-16 下午6:39:39
	 * @return
	 * @throws Exception
	 */
	public String todayFocus() throws Exception;
	/**
	 * 婴幼儿体检
	 * @author LHY 2015-2-16 下午6:39:39
	 * @return
	 * @throws Exception
	 */
	public String nurseryExamination(int size) throws Exception;
	
	/**
	 * 疫苗防疫
	 * @author LHY 2015-2-16 下午6:39:42
	 * @return
	 * @throws Exception
	 */
	public String vaccinePrevent(int size) throws Exception;
	
	/**
	 * 今日头条、婴幼儿体检、疫苗防疫
	 * @author LHY 2015-2-17 下午2:46:12
	 * @param size
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String findWebArticle(int size, String id) throws Exception;
}