package org.springframework.research.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Create By Zhenli.Hu
 * Create Time 2019-08-05 17:12
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"org.springframework.research.imports.UserManager"};
	}
}
