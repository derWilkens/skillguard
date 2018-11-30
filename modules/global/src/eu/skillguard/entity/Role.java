package eu.skillguard.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Date;
import javax.persistence.Version;
import com.haulmont.cuba.core.entity.BaseUuidEntity;
import com.haulmont.cuba.core.entity.Versioned;
import com.haulmont.cuba.core.entity.SoftDelete;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.FtsChangeType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

@NamePattern("%s|name")
@Table(name = "SKILLGUARD_ROLE")
@Entity(name = "skillguard$Role")
public class Role extends StandardEntity {
    private static final long serialVersionUID = 9218598404697048319L;

    @Column(name = "NAME", length = 50)
    protected String name;


    @Column(name = "LEVEL_")
    protected Integer level;


    @OrderBy("name")
    @JoinTable(name = "SKILLGUARD_ROLE_CERTIFICATE_TYPE_LINK",
        joinColumns = @JoinColumn(name = "ROLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "CERTIFICATE_TYPE_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected List<CertificateType> certificateTypes;

    @JoinTable(name = "SKILLGUARD_EMPLOYEE_ROLE_LINK",
        joinColumns = @JoinColumn(name = "ROLE_ID"),
        inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected List<Employee> employees;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    public void setCertificateTypes(List<CertificateType> certificateTypes) {
        this.certificateTypes = certificateTypes;
    }

    public List<CertificateType> getCertificateTypes() {
        return certificateTypes;
    }


    public void setLevel(EducationalLevel level) {
        this.level = level == null ? null : level.getId();
    }

    public EducationalLevel getLevel() {
        return level == null ? null : EducationalLevel.fromId(level);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}