package ksigauke.com.dotaheroes.herolist;

import android.support.v7.widget.RecyclerView;

import ksigauke.com.dotaheroes.databinding.FragmentHeroItemBinding;
import ksigauke.com.dotaheroes.domain.Hero;

class HeroViewHolder extends RecyclerView.ViewHolder {
    private final FragmentHeroItemBinding heroItemBinding;

    public HeroViewHolder(FragmentHeroItemBinding binding) {
        super(binding.getRoot());
        heroItemBinding = binding;
    }

    void bind(Hero hero) {
        heroItemBinding.setHero(hero);
        heroItemBinding.executePendingBindings();
    }
}
