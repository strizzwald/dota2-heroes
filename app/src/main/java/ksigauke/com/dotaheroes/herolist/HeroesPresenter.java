package ksigauke.com.dotaheroes.herolist;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ksigauke.com.dotaheroes.DotaHeroesApplication;
import ksigauke.com.dotaheroes.domain.Hero;
import ksigauke.com.dotaheroes.repository.HeroRepository;


public class HeroesPresenter implements HeroesContract.Presenter {

    @Inject
    HeroRepository heroRepository;

    private HeroesContract.View heroesView;

    private Scheduler ioScheduler, mainScheduler;

    public HeroesPresenter(HeroRepository heroRepository, Scheduler ioScheduler, Scheduler mainScheduler){
        this.ioScheduler = ioScheduler;
        this.mainScheduler = mainScheduler;
        this.heroRepository = heroRepository;
    }

    @Override
    public void getAllHeroes() {
        heroRepository.getAllHeroes()
                .observeOn(mainScheduler)
                .doOnNext(new Consumer<List<Hero>>() {
                    @Override
                    public void accept(List<Hero> heroes) throws Exception {
                        heroesView.showLoadingBar();
                    }
                })
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
                .subscribe(new Observer<List<Hero>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Hero> heroes) {
                        heroesView.displayHeroes(heroes);
                        heroesView.hideLoadingBar();
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

    @Override
    public void setView(HeroesContract.View v) {
        heroesView = v;
    }

}
