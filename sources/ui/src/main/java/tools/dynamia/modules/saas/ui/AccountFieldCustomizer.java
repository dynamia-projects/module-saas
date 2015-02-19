/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.dynamia.modules.saas.ui;

import org.springframework.stereotype.Component;

import tools.dynamia.modules.saas.domain.Account;
import tools.dynamia.viewers.Field;
import tools.dynamia.viewers.FieldCustomizer;
import tools.dynamia.viewers.FieldGroup;

/**
 *
 * @author mario
 */
@Component
public class AccountFieldCustomizer implements FieldCustomizer {

    @Override
    public void customize(String viewTypeName, Field field) {
        if (field.getFieldClass() == Account.class) {
            field.getViewDescriptor().removeField(field.getName());
            FieldGroup group = field.getGroup();
            if (group != null) {
                group.removeField(field);
            }
        }
    }

}