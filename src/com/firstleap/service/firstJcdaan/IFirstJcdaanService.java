package com.firstleap.service.firstJcdaan;

import java.util.List;

import com.firstleap.common.service.BaseService;
import com.firstleap.entity.po.FirstJcdaan;

/**
 * 
 * @author LHY 2015-2-17 下午7:13:40
 */
public interface IFirstJcdaanService extends BaseService {
	public FirstJcdaan get(String id) throws Exception;
	public List<FirstJcdaan> findList(String id) throws Exception;
}
