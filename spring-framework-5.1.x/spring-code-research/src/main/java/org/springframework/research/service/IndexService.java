package org.springframework.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.research.dao.IndexDao;
import org.springframework.stereotype.Service;

/**
 * Create By Zhenli.Hu
 * Create Time 2019-08-06 12:34
 */
@Service
public class IndexService {

	@Autowired
	private IndexDao indexDao;

}
