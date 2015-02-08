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
}