package eu.skillguard.web.gui.components;

import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebDirectoryUpload extends WebAbstractComponent<eu.skillguard.web.toolkit.ui.directoryupload.DirectoryUpload> implements DirectoryUpload {
    public WebDirectoryUpload() {
        this.component = new eu.skillguard.web.toolkit.ui.directoryupload.DirectoryUpload();
    }
}