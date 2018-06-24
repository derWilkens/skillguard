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
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|name")
@Table(name = "SKILLGUARD_JOBFUNCTION")
@Entity(name = "skillguard$Jobfunction")
public class Jobfunction extends StandardEntity {
    private static final long serialVersionUID = 2860066414953457377L;

    @Column(name = "NAME", length = 50)
    protected String name;



    @JoinTable(name = "SKILLGUARD_JOBFUNCTION_ROLE_LINK",
        joinColumns = @JoinColumn(name = "JOBFUNCTION_ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OnDelete(DeletePolicy.UNLINK)
    @ManyToMany
    protected List<Role> roles;

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}