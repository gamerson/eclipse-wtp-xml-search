package org.eclipse.wst.xml.search.editor.ui.internal.contentassist;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionDelta;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.xml.search.core.AbstractRegistryManager;
import org.eclipse.wst.xml.search.editor.ui.internal.XMLSearchEditorUIPlugin;

public class ContentAssistBindingsManager extends AbstractRegistryManager{
	private static final String BINDING_ELT = "binding";
	private static final String REFERENCE_TO_ATTR = "referenceTo";
	private static final String ADDITIONAL_PROPOSAL_INFO_PROVIDER_ATTR = "additionalProposalInfoProvider";

	public static final ContentAssistBindingsManager INSTANCE = new ContentAssistBindingsManager();
	private static final String BINDINGS_EXTENSION_POINT = "contentAssistBindings";

	private Map<String, String> providerIdByReferenceToId = null;

	public static ContentAssistBindingsManager getDefault() {
		return INSTANCE;
	}

	@Override
	protected void handleExtensionDelta(IExtensionDelta delta) {
		if (providerIdByReferenceToId == null) {// not loaded yet
			return;
		}
		if (delta.getKind() == IExtensionDelta.ADDED) {
			IConfigurationElement[] cf = delta.getExtension()
					.getConfigurationElements();
			addBinding(providerIdByReferenceToId, cf);
		} else {// TODO : remove references
		}
	}

	private synchronized void addBinding(
			Map<String, String> searcherIdByReferenceId, IConfigurationElement[] cf) {
		for (IConfigurationElement ce : cf) {
			if (BINDING_ELT.equals(ce.getName())) {
				final String additionalProposalInfoProviderId = ce.getAttribute(ADDITIONAL_PROPOSAL_INFO_PROVIDER_ATTR);
				final String referenceToId = ce.getAttribute(REFERENCE_TO_ATTR);
				searcherIdByReferenceId.put(referenceToId, additionalProposalInfoProviderId);
			}
		}
	}

	public String getAdditionalProposalInfoProviderId(String referenceId) {
		if (providerIdByReferenceToId == null) {
			loadBindings();
		}
		return providerIdByReferenceToId.get(referenceId);
	}

	private synchronized void loadBindings() {
		if (providerIdByReferenceToId != null) {
			return;
		}
		Map<String, String> providerIdByReferenceToId = null;
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		if (registry != null) {
			IConfigurationElement[] cf = registry.getConfigurationElementsFor(
					XMLSearchEditorUIPlugin.PLUGIN_ID, BINDINGS_EXTENSION_POINT);
			providerIdByReferenceToId = new HashMap<String, String>(cf.length);
			addBinding(providerIdByReferenceToId, cf);
		} else {
			providerIdByReferenceToId = new HashMap<String, String>();
		}
		this.providerIdByReferenceToId = providerIdByReferenceToId;
		super.addRegistryListenerIfNeeded();

	}
	
	@Override
	protected String getExtensionPoint() {
		return BINDINGS_EXTENSION_POINT;
	}

	@Override
	protected String getPluginId() {
		// change it to editor ui plugin
		return XMLSearchEditorUIPlugin.PLUGIN_ID;
	}
}
