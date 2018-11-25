
package tools.dynamia.modules.saas.listeners;

import org.springframework.stereotype.Component;

import tools.dynamia.commons.BeanUtils;
import tools.dynamia.domain.query.QueryParameters;
import tools.dynamia.domain.util.CrudServiceListenerAdapter;
import tools.dynamia.modules.saas.AccountContext;
import tools.dynamia.modules.saas.api.AccountAware;
import tools.dynamia.modules.saas.domain.Account;

/**
 *
 * @author Mario Serrano Leones
 */
@Component
public class AccountAwareCrudServiceListener extends CrudServiceListenerAdapter<AccountAware> {
    
    private static final String ACCOUNT_ID = "accountId";

    @Override
    public void beforeCreate(AccountAware entity) {
        if (entity.getAccountId() == null) {
            try {
                entity.setAccountId(AccountContext.getCurrent().getAccount().getId());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void beforeQuery(QueryParameters params) {
        if (!params.containsKey(ACCOUNT_ID) || params.get(ACCOUNT_ID) == null) {
            Class paramsType = params.getType();
            if (paramsType != null) {
                Object obj = BeanUtils.newInstance(paramsType);
                if (obj instanceof AccountAware) {
                    Account account = AccountContext.getCurrent().getAccount();
                    if (account != null) {
                        params.add(ACCOUNT_ID, account.getId());
                    }
                }
            }
        }
    }
    

}
