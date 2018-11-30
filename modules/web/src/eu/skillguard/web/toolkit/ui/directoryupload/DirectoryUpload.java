package eu.skillguard.web.toolkit.ui.directoryupload;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.RequestHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.server.VaadinSession;
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
    
	
	VaadinSession.getCurrent().addRequestHandler(
	        new RequestHandler() {
	    @Override
	    public boolean handleRequest(VaadinSession session,
	                                 VaadinRequest request,
	                                 VaadinResponse response)
	            throws IOException {
	        if ("/rhexample".equals(request.getPathInfo())) {
	            // Generate a plain text document
	            response.setContentType("text/plain");
	            response.getWriter().append(
	               "Here's some dynamically generated content.\n");
	            response.getWriter().format(Locale.ENGLISH,
	               "Time: %Tc\n", new Date());

	            // Use shared session data
	            response.getWriter().format("Session data: %s\n",
	                session.getAttribute("mydata"));

	            return true; // We wrote a response
	        } else
	            return false; // No response was written
	    }
	});
	}
}