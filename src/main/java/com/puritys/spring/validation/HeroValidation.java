package com.puritys.spring.validation;

import javax.validation.constraints.*;

public interface HeroValidation {

    @Null(
        groups = {
            ValidationGroups.Create.class
        }
    )
    @NotNull(
        groups = {
            ValidationGroups.Update.class
        }
    )
    String getId();
    public String id = "";

    WeaponValidation getWeapon();
    WeaponValidation weapon = null;
}
