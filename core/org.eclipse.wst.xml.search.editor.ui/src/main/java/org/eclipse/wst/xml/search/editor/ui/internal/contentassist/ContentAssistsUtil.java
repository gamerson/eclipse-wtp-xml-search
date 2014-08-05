package org.eclipse.wst.xml.search.editor.ui.internal.contentassist;

import org.eclipse.wst.xml.search.editor.core.references.IXMLReferenceTo;
import org.eclipse.wst.xml.search.editor.ui.contentassist.DefaultDOMContentAssistAdditionalProposalInfoProvider;
import org.eclipse.wst.xml.search.editor.ui.contentassist.IContentAssistAdditionalProposalInfoProvider;
import org.eclipse.wst.xml.search.editor.ui.contentassist.PropertyContentAssistAdditionalProposalInfoProvider;
import org.eclipse.wst.xml.search.editor.ui.contentassist.ResourceContentAssistAdditionalProposalInfoProvider;

public class ContentAssistsUtil {
	private static final ContentAssistsManager contentAssistsManager = ContentAssistsManager.getDefault();
	private static final ContentAssistBindingsManager bindingManager = 
			ContentAssistBindingsManager.getDefault();

	public static IContentAssistAdditionalProposalInfoProvider getProvider(IXMLReferenceTo referenceTo) {
		String providerId = bindingManager.getAdditionalProposalInfoProviderId(referenceTo.getReferenceToId());
		IContentAssistAdditionalProposalInfoProvider provider = contentAssistsManager.getProvider(providerId);
		return provider != null ? provider : getDefaultProvider(referenceTo);
	}

	private static IContentAssistAdditionalProposalInfoProvider getDefaultProvider(IXMLReferenceTo referenceTo) {
		switch (referenceTo.getType()) {
		case XML:
			return DefaultDOMContentAssistAdditionalProposalInfoProvider.INSTANCE;
		case PROPERTY:
			return PropertyContentAssistAdditionalProposalInfoProvider.INSTANCE;
		case RESOURCE:
			return ResourceContentAssistAdditionalProposalInfoProvider.INSTANCE;
		default:
			return null;
		}
	}
}
