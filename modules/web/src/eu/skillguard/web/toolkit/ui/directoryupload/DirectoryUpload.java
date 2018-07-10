package eu.skillguard.web.toolkit.ui.directoryupload;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

import elemental.json.JsonObject;

@JavaScript({"directoryupload-connector.js"})
public class DirectoryUpload extends AbstractJavaScriptComponent {

	private FilesSelectedListener listener;
	
    @Override
    protected DirectoryUploadState getState() {
        return (DirectoryUploadState) super.getState();
    }
    public interface FilesSelectedListener {
        void filesSelected(JsonObject jsonItem);
    }
    
	private static final long serialVersionUID = 1L;
	public DirectoryUpload() {
		addFunction("filesSelected", arguments -> {
			listener.filesSelected(arguments.getObject(0));
		});
    }
}