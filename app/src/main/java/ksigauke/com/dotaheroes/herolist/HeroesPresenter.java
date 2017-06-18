package ksigauke.com.dotaheroes.herolist;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.repository.HeroRepository;


public class HeroesPresenter implements HeroesContract.Presenter {

    private HeroRepository heroRepository;
    private HeroesContract.View heroesView;

    public HeroesPresenter(HeroRepository heroRepository, HeroesContract.View heroesView){
        this.heroRepository = heroRepository;
        this.heroesView = heroesView;
    }

    @Override
    public void getAllHeroes() {
        heroRepository.getAllHeroes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Hero> heroes) {
                        heroesView.displayHeroes(heroes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        heroesView.showError("Could not load heroes");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
