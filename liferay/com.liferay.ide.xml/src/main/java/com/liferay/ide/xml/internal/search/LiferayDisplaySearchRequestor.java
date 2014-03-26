/*******************************************************************************
 * Copyright (c) 2013-2014 Angelo ZERR.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:      
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package com.liferay.ide.xml.internal.search;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.wst.xml.search.core.queryspecifications.requestor.ContentTypeXMLSearchRequestor;
import org.eclipse.wst.xml.search.core.queryspecifications.requestor.IXMLSearchRequestor;

import com.liferay.ide.xml.LiferayXMLConstants;

/**
 * 
 * XML Search requestor for liferay-display.xml descriptors.
 * 
 */
public class LiferayDisplaySearchRequestor extends
		ContentTypeXMLSearchRequestor {

	public static IXMLSearchRequestor INSTANCE = new LiferayDisplaySearchRequestor();

	@Override
	protected Collection<String> getSupportedContentTypeIds() {
		Collection<String> contentTypeIds = new ArrayList<String>();
		contentTypeIds
				.add(LiferayXMLConstants.LIFERAY_DISPLAY_XML_CONTENT_TYPE);
		return contentTypeIds;
	}

}