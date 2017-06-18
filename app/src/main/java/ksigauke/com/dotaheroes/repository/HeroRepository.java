package ksigauke.com.dotaheroes.repository;

import java.util.List;

import io.reactivex.Observable;
import ksigauke.com.dotaheroes.domain.Hero;

public interface HeroRepository {
    Observable<List<Hero>> getAllHeroes();
}
                                                                                                           