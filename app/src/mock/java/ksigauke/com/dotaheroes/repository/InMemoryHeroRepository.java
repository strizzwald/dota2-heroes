package ksigauke.com.dotaheroes.repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import ksigauke.com.dotaheroes.domain.Hero;

public class InMemoryHeroRepository implements HeroRepository {

    private List<Hero> HEROES = new ArrayList<>();
    {
        HEROES.add(new Hero.Builder().id(1)
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

        HEROES.add(new Hero.Builder()
                .id(2)
                .name("Anti-mage")
                .localizedName("Anti-mage")
                .primaryAttribute("int")
                .attackType("Melee")
                .roles(
                        new ArrayList<String>() {{
                            add("Nuker");
                            add("Disabler");
                            add("Escape");
                        }}
                )
                .imageUrl("/apps/dota2/images/heroes/antimage_full.png")
                .attackMin(15)
                .attackMax(20)
                .strength(25)
                .agility(15)
                .intelligence(7)
                .build());

        HEROES.add(new Hero.Builder()
                .id(3)
                .name("Alchemist")
                .localizedName("Alchemist")
                .primaryAttribute("agi")
                .attackType("Melee")
                .roles(
                        new ArrayList<String>() {{
                            add("Nuker");
                            add("Disabler");
                            add("Escape");
                        }}
                )
                .imageUrl("/apps/dota2/images/heroes/alchemist_full.png")
                .attackMin(14)
                .attackMax(35)
                .strength(20)
                .agility(12)
                .intelligence(8)
                .build());

        HEROES.add(new Hero.Builder()
                .id(4)
                .name("Pudge")
                .localizedName("Pudge")
                .primaryAttribute("str")
                .attackType("Melee")
                .roles(
                        new ArrayList<String>() {{
                            add("Nuker");
                            add("Disabler");
                            add("Escape");
                        }}
                )
                .imageUrl("/apps/dota2/images/heroes/pudge_full.png")
                .attackMin(12)
                .attackMax(30)
                .strength(12)
                .agility(8)
                .intelligence(10)
                .build());

    }


    @Override
    public Observable<List<Hero>> getAllHeroes() {

        return Observable.create(new ObservableOnSubscribe<List<Hero>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Hero>> e) throws Exception {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                e.onNext(HEROES);
            }
        });

    }
}
