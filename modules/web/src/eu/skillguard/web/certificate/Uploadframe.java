package eu.skillguard.web.certificate;

import java.util.Map;

import javax.inject.Inject;

import com.haulmont.cuba.gui.app.core.file.MultiUploader;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;

import eu.skillguard.web.toolkit.ui.directoryupload.DirectoryUpload;

public class Uploadframe extends AbstractWindow {
	
	@Inject
	private HBoxLayout uploadBox;
	private DirectoryUpload directoryUpload; 
	private MultiUploader multiUploadButton;
	
	@Override
	public void init(Map<String, Object> params) {
		directoryUpload = new DirectoryUpload();
		com.vaadin.ui.Layout box = (Layout) WebComponentsHelper.unwrap(uploadBox);
		box.addComponent(directoryUpload);
		MultiUploader upl = (MultiUploader) WebComponentsHelper.unwrap(multiUploadButton);
		
		TextField  lbl;
		
	}
}