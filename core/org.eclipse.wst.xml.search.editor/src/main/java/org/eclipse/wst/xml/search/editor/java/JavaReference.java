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
package org.eclipse.wst.xml.search.editor.java;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.wst.xml.search.editor.references.AbstractReference;

public class JavaReference extends AbstractReference implements IJavaReference {

	private final IJavaElementMatcher matcher;

	public JavaReference(IJavaElementMatcher matcher) {
		this.matcher = matcher;
	}

	public boolean match(IJavaElement element) {
		return matcher.match(element);
	}

}
