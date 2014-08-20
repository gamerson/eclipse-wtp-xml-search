package org.eclipse.wst.xml.search.editor.ui.statics;

import org.eclipse.core.resources.IResource;
import org.eclipse.wst.xml.search.core.statics.StaticValue;

public class StaticValueDocument extends StaticValue {

	private final String line;
	private final int startOffset;
	private final int length;
	private final IResource resource;

	public StaticValueDocument(String key, String line, int startOffset,
			int length, IResource resource) {
		super(key, getDescription(line, key));
		this.line = line;
		this.startOffset = startOffset;
		this.length = length;
		this.resource = resource;
	}

	public String getLine() {
		return line;
	}

	public int getStartOffset() {
		return startOffset;
	}

	public static String getDescription(String line, String key) {
		return line.replaceAll("\"" + key + "\"", "\"<b>" + key + "</b>\"");
	}

	public IResource getResource() {
		return resource;
	}

	public int getLength() {
		return length;
	}

}
