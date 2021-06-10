package desktop.actions.actionskruidvat;


import desktop.actions.Repository;

public class ActionsRepository extends Repository {

    public BasketActions getBasketActions() {
        return get(BasketActions.class);
    }

    public HomePageActions getHomePageActions() {
        return get(HomePageActions.class);
    }
}
