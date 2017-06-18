package ksigauke.com.dotaheroes.herolist;

import java.util.List;

import ksigauke.com.dotaheroes.domain.Hero;

public interface HeroesContract {

    interface View {
        void showLoadingBar();
        void displayHeroes(List<Hero> heroes);
        void hideLoadingBar();
        void showError(String errorMessage);
    }

    interface Presenter{
        void getAllHeroes();
    }

}
