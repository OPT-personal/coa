package menu;

import utils.Authenticatie;

public class ActieLogout implements IActie {
    @Override
    public void voerActieUit() {
        Authenticatie.getInstance().logout();
    }
}
