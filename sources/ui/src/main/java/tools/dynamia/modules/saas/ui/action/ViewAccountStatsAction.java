package tools.dynamia.modules.saas.ui.action;

import org.springframework.beans.factory.annotation.Autowired;
import tools.dynamia.actions.InstallAction;
import tools.dynamia.commons.ApplicableClass;
import tools.dynamia.crud.AbstractCrudAction;
import tools.dynamia.crud.CrudActionEvent;
import tools.dynamia.crud.CrudState;
import tools.dynamia.domain.query.QueryParameters;
import tools.dynamia.domain.services.CrudService;
import tools.dynamia.modules.saas.api.AccountStats;
import tools.dynamia.modules.saas.domain.Account;
import tools.dynamia.modules.saas.domain.AccountLog;
import tools.dynamia.modules.saas.domain.AccountStatsData;
import tools.dynamia.ui.MessageType;
import tools.dynamia.ui.UIMessages;
import tools.dynamia.zk.util.ZKUtil;
import tools.dynamia.zk.viewers.ui.Viewer;

import java.util.List;

@InstallAction
public class ViewAccountStatsAction extends AbstractCrudAction {

    @Autowired
    private CrudService crudService;

    public ViewAccountStatsAction() {
        setName("Stats");
        setMenuSupported(true);
    }

    @Override
    public void actionPerformed(CrudActionEvent evt) {

        Account account = (Account) evt.getData();
        if (account != null) {
            List<AccountStatsData> stats = crudService.find(AccountStatsData.class, QueryParameters.with("account", account));

            if (stats.isEmpty()) {
                UIMessages.showMessage("No stats found", MessageType.WARNING);
                return;
            } else {
                Viewer viewer = new Viewer("table", AccountStatsData.class);
                viewer.setValue(stats);

                ZKUtil.showDialog("Stats: " + account, viewer, "60%", "60%");
            }


        }
    }

    @Override
    public CrudState[] getApplicableStates() {
        return CrudState.get(CrudState.READ);
    }

    @Override
    public ApplicableClass[] getApplicableClasses() {
        return ApplicableClass.get(Account.class);
    }
}