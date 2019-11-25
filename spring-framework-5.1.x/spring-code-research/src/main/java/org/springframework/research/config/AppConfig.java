package org.springframework.research.config;

import org.springframework.context.annotation.*;
import org.springframework.research.dao.IndexDao;
import org.springframework.research.imports.GoodsManager;
import org.springframework.research.imports.MyImportSelector;

/**
 * Create By Zhenli.Hu
 * Create Time 2019-07-30 10:46
 */
@Configuration
@ComponentScan(value = {"org.springframework.research"},basePackageClasses = {IndexDao.class})
@Import({MyImportSelector.class, GoodsManager.class})
@EnableAspectJAutoProxy
public class AppConfig {

}
