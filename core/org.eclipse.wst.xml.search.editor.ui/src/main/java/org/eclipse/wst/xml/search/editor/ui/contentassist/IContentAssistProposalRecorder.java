/*******************************************************************************
 * Copyright (c) 2011 Angelo ZERR.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:      
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.xml.search.editor.ui.contentassist;

import org.eclipse.swt.graphics.Image;

public interface IContentAssistProposalRecorder {

	void recordProposal(Image image, int relevance, String displayText,
			String replaceText);

	void recordProposal(Image image, int relevance, String displayText,
			String replaceText, Object proposedObject);

	void recordProposal(Image image, int relevance, String displayText,
			String replaceText, int cursorPosition, Object proposedObject);
}
