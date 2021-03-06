/**
 *  Copyright (c) 2013-2014 Angelo ZERR.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.wst.xml.search.editor.util;

import org.eclipse.wst.xml.search.core.queryspecifications.IXMLQuerySpecification;
import org.eclipse.wst.xml.search.core.queryspecifications.XMLQuerySpecificationManager;
import org.eclipse.wst.xml.search.editor.references.IXMLReferencePath;

public class XMLQuerySpecificationUtil {

	public static IXMLQuerySpecification getQuerySpecification(
			IXMLReferencePath path) {
		return getQuerySpecification(path.getQuerySpecificationId());
	}

	public static IXMLQuerySpecification getQuerySpecification(
			String querySpecificationId) {
		return XMLQuerySpecificationManager.getDefault().getQuerySpecification(
				querySpecificationId);
	}
	
}
