package eu.skillguard.web.certificate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileMultiUploadField;
import com.haulmont.cuba.gui.components.UploadField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.theme.ThemeConstants;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

public class FolderUpload extends AbstractWindow {

	protected Map<FileDescriptor, UUID> tmpFileDescriptors = new HashMap<>();

    @Inject
    protected CollectionDatasource<FileDescriptor, UUID> filesDs = null;

    @Inject
    protected FileMultiUploadField multiUpload;

    @Named("windowActions.windowCommit")
    protected Button okBtn;

    @Inject
    protected ThemeConstants themeConstants;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        multiUpload.setDropZone(new UploadField.DropZone(this));

        getDialogOptions()
                .setHeight(themeConstants.get("cuba.gui.multiupload.height"))
                .setResizable(true);

        filesDs.refresh();

        okBtn.setEnabled(false);

        multiUpload.setCaption(getMessage("upload"));
        multiUpload.addQueueUploadCompleteListener(() -> {
            okBtn.setEnabled(true);

            FileUploadingAPI fileUploading = AppBeans.get(FileUploadingAPI.NAME);
            Map<UUID, String> uploads = multiUpload.getUploadsMap();
            for (Map.Entry<UUID, String> upload : uploads.entrySet()) {
                FileDescriptor fDesc = fileUploading.getFileDescriptor(upload.getKey(), upload.getValue());

                tmpFileDescriptors.put(fDesc, upload.getKey());
                filesDs.addItem(fDesc);
            }
            multiUpload.clearUploads();
        });

        multiUpload.addFileUploadStartListener(e -> okBtn.setEnabled(false));
        
    }

    @Override
    public void ready() {
        // skip set item
        okBtn.setEnabled(false);
    }

    @Override
    public boolean close(String actionId) {
        if (!COMMIT_ACTION_ID.equals(actionId)) {
            FileUploadingAPI fileUploading = AppBeans.get(FileUploadingAPI.NAME);
            for (Map.Entry<FileDescriptor, UUID> upload : tmpFileDescriptors.entrySet()) {
                try {
                    fileUploading.deleteFile(upload.getValue());
                } catch (FileStorageException e) {
                    throw new RuntimeException("Unable to delete file from temp storage", e);
                }
            }
        }
        return super.close(actionId);
    }

    protected void saveFiles() {
        FileUploadingAPI fileUploading = AppBeans.get(FileUploadingAPI.NAME);
        try {
            // Relocate the file from temporary storage to permanent
            for (FileDescriptor fDesc : filesDs.getItems()) {
                fileUploading.putFileIntoStorage(tmpFileDescriptors.get(fDesc), fDesc);
            }
        } catch (FileStorageException e) {
            throw new RuntimeException("Unable to put files into storage", e);
        }
    }

    public Collection<FileDescriptor> getFiles() {
        return filesDs.getItems();
    }

    public void commitAndClose() {
        if (getDsContext().commit()) {
            saveFiles();

            close(COMMIT_ACTION_ID);
        }
    }

    public void close() {
        close(CLOSE_ACTION_ID);
    }

	
	
}
