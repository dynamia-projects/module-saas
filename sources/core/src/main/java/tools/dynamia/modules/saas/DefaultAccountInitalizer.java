/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.dynamia.modules.saas;

import org.springframework.stereotype.Component;
import tools.dynamia.modules.saas.api.dto.AccountDTO;
import tools.dynamia.modules.saas.api.AccountInitializer;

/**
 *
 * @author Mario Serrano Leones
 */
@Component
public class DefaultAccountInitalizer implements AccountInitializer {

    @Override
    public void init(AccountDTO accountDTO) {
//nothing to do
    }

}
