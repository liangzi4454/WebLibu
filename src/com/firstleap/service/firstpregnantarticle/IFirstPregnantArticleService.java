package com.firstleap.service.firstpregnantarticle;

import java.util.List;

import com.firstleap.common.pagination.Pagination;
import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstPregnantArticle;

/**
 * @author zsc
 * 
 */
public interface IFirstPregnantArticleService extends BaseService {
	/**
	 * @param id
	 * @return
	 */
	FirstPregnantArticle getByid(String id);
	/**
	 * @param pageNo
	 * @return 分页
	 */
	public Pagination findAllOrQuery(int pageNo, FirstPregnantArticle firstPregnantArticle);

	public Pagination findAllOrQueryi(int pageNo, FirstPregnantArticle firstPregnantArticle);

	List<FirstPregnantArticle> list(String hosid);
	/**
	 * <p>
	 * 	根据分类类型获取与之相关的文章列表;默认类型为1;
	 *  详细分类请查询com.firstleap.common.constant.FirstPregnantType常量类
	 * </p>
	 * @param obj
	 * @return json对象
	 * @see com.firstleap.common.constant.FirstPregnantType
	 */
	public String findArticleCategory(String obj);
}