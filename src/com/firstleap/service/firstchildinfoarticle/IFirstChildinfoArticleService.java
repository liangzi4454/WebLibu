package com.firstleap.service.firstchildinfoarticle;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstChildinfoArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstChildinfoArticleService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstChildinfoArticle getByid(String id);

	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstChildinfoArticle firstChildinfoArticle);

	public Pagination findAllOrQueryi(int pageNo, FirstChildinfoArticle firstChildinfoArticle);

	List<FirstChildinfoArticle> list(String hosid);
}