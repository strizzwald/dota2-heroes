package ksigauke.com.dotaheroes.herolist;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.repository.HeroRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HeroesPresenterTest {

    @Mock
    HeroesContract.View heroView;

    @Mock
    HeroRepository heroRepository;

    private HeroesPresenter heroesPresenter;

    private static final List<Hero> HEROES = new ArrayList<Hero>() {
        {
            add(new Hero.Builder().id(1)
                    .name("Razor")
                    .localizedName("Razor")
                    .primaryAttribute("int")
                    .attackType("Range")
                    .roles(
                            new ArrayList<String>() {{
                                add("Nuker");
                                add("Disabler");
                                add("Escape");
                            }}
                    )
                    .imageUrl("/apps/dota2/images/heroes/razor_full.png")
                    .attackMin(12)
                    .attackMax(23)
                    .strength(23)
                    .agility(12)
                    .intelligence(25)
                    .build());
        }
    };


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        heroesPresenter = new HeroesPresenter(heroRepository, Schedulers.trampoline(), Schedulers.trampoline());
        heroesPresenter.setView(heroView);
    }

    @Test
    public void getAllHeroes_DisplaysHeroesOnView() {

        //Arrange
        when(heroRepository.getAllHeroes()).thenReturn(Observable.just(HEROES));

        //Act
        heroesPresenter.getAllHeroes();

        //Assert
        verify(heroView).showLoadingBar();
        verify(heroView).hideLoadingBar();
        verify(heroView).displayHeroes(HEROES);

    }

}
