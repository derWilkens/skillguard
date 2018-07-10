package eu.skillguard.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EducationalLevel implements EnumClass<Integer> {

    Basic(10),
    Init(20),
    Cont(30);

    private Integer id;

    EducationalLevel(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static EducationalLevel fromId(Integer id) {
        for (EducationalLevel at : EducationalLevel.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}