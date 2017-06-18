package ksigauke.com.dotaheroes.herolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ksigauke.com.dotaheroes.databinding.FragmentHeroItemBinding;
import ksigauke.com.dotaheroes.domain.Hero;

public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    private List<Hero> heroes;

    public HeroesAdapter(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.bind(hero);
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FragmentHeroItemBinding binding = FragmentHeroItemBinding.inflate(inflater, parent, false);

        return new HeroViewHolder(binding);
    }

    public void setHeroes(List<Hero> heroes) {
        if (this.heroes != null) {
            this.heroes = heroes;
            notifyDataSetChanged();
        }
    }
}
