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
	/**
	 * @author LHY 2015-2-16 上午11:48:59
	 * @param size
	 * @return
	 */
	public String list(int size);
	/**
	 * <p>
	 * 	根据分类类型获取与之相关的文章列表;默认类型为1;
	 *  详细分类请查询com.firstleap.common.constant.CategoryConstant.FirstChildinfoType常量类.
	 *  默认查询新生儿分类下要所有二级分类在文章列表
	 * </p>
	 * @param size 查询数量
	 * @param id 父类型id 暂时没有用到
	 * @param ids 父类型下子类型的id集合
	 * @return json 对象
	 * @see com.firstleap.common.constant.CategoryConstant.FirstChildinfoType
	 */
	public String findArticleCategoryList(int size, String id, String... ids);
	
	public String findHotArticle();
}