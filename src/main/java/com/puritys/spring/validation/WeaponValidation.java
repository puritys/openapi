package com.puritys.spring.validation;

//import com.puritys.spring.model.*;
import javax.validation.constraints.*;

public interface WeaponValidation {

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
    String id = "";

}
