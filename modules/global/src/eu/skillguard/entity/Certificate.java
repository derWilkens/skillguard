package eu.skillguard.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamePattern("%s|id")
@Table(name = "SKILLGUARD_CERTIFICATE")
@Entity(name = "skillguard$Certificate")
public class Certificate extends StandardEntity {
    private static final long serialVersionUID = -2715365484727941956L;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISSUING_DATE")
    protected Date issuingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRATION_DATE")
    protected Date expirationDate;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VERFIED_BY_ID")
    protected User verfiedBy;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OnDeleteInverse(DeletePolicy.DENY)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUALIFICATION_TYPE_ID")
    protected CertificateType qualificationType;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_DATA_ID")
    protected FileDescriptor fileData;

    public CertificateType getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(CertificateType qualificationType) {
        this.qualificationType = qualificationType;
    }


    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setVerfiedBy(User verfiedBy) {
        this.verfiedBy = verfiedBy;
    }

    public User getVerfiedBy() {
        return verfiedBy;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setFileData(FileDescriptor fileData) {
        this.fileData = fileData;
    }

    public FileDescriptor getFileData() {
        return fileData;
    }


}