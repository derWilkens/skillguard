package eu.skillguard.entity;

import javax.persistence.Entity;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Listeners("skillguard_EmployeeListener")
@NamePattern("%s, |lastName,firstName")
@Entity(name = "skillguard$Employee")
public class Employee extends User {
    private static final long serialVersionUID = -7597677918055082569L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    protected Department department;

    @JoinTable(name = "SKILLGUARD_EMPLOYEE_ROLE_LINK",
        joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected List<Role> additionalRoles;

    @Lookup(type = LookupType.DROPDOWN)
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOBFUNCTION_ID")
    protected Jobfunction jobfunction;

    public void setAdditionalRoles(List<Role> additionalRoles) {
        this.additionalRoles = additionalRoles;
    }

    public List<Role> getAdditionalRoles() {
        return additionalRoles;
    }


    public void setJobfunction(Jobfunction jobfunction) {
        this.jobfunction = jobfunction;
    }

    public Jobfunction getJobfunction() {
        return jobfunction;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }


}