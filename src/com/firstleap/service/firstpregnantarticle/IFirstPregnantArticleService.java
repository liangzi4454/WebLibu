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
	 * @author LHY 2015-2-16 上午11:48:59
	 * @param size
	 * @return
	 */
	public String list(int size);
	/**
	 * <p>
	 * 	根据分类类型获取与之相关的文章列表;默认类型为1;
	 *  详细分类请查询com.firstleap.common.constant.FirstPregnantType常量类.
	 *  默认查询备孕分类下要所有二级分类在文章列表
	 * </p>
	 * @param size 查询数量
	 * @param id 父类型id 暂时没有用到
	 * @param ids 父类型下子类型的id集合
	 * @return json 对象
	 * @see com.firstleap.common.constant.FirstPregnantType
	 */
	public String findArticleCategoryList(int size, String id, String... ids);
	
	public String findHotArticle();
	/**
	 * 首页查询使用
	 * @author LHY 2015-2-16 下午1:47:46
	 * @return
	 * @throws Exception
	 */
	public String findCategoryList(String id, int size) throws Exception;
}