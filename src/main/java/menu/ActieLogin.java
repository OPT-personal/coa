package menu;

import utils.Authenticatie;


public class ActieLogin implements IActie {

    @Override
    public void voerActieUit() {
        Authenticatie.getInstance().login();
    }
}
