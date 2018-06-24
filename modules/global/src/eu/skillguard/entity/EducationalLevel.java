package eu.skillguard.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EducationalLevel implements EnumClass<Integer> {

    Init(10),
    Cont(20);

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