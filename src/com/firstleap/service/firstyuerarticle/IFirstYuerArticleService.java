package com.firstleap.service.firstyuerarticle;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstYuerArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstYuerArticleService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstYuerArticle getByid(String id);

	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo,
			FirstYuerArticle firstYuerArticle);

	public Pagination findAllOrQueryi(int pageNo,
			FirstYuerArticle firstYuerArticle);

	List<FirstYuerArticle> list(String hosid);
}