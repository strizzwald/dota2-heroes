package ksigauke.com.dotaheroes.herolist;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import ksigauke.com.dotaheroes.Constants;
import ksigauke.com.dotaheroes.R;

public final class HeroBinder {

    private HeroBinder() {
    }
    private static RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            Log.d(HeroBinder.class.getSimpleName(), e.getMessage());
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    };

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        String imageUrl = Constants.API_BASE_URL + url;
        Context context = imageView.getContext();
        Glide.with(context)
                .load(imageUrl)
                .listener(requestListener)
                .into(imageView);
    }

    @BindingAdapter("primaryAttributeIcon")
    public static void setPrimaryAttributeIcon(ImageView imageView, String primaryAttribute) {
        int drawable;

        switch (primaryAttribute.toLowerCase()) {
            case "strength":
                drawable = R.drawable.ic_strength_dot;
                break;
            case "agility":
                drawable = R.drawable.ic_agility_dot;
                break;
            case "intelligence":
                drawable = R.drawable.ic_intelligence_dot;
                break;
            default:
                throw new RuntimeException();
        }
        Context context = imageView.getContext();

        // Hacky. See https://github.com/bumptech/glide/issues/350
        Glide.with(context)
                .load("")
                .error(drawable)
                .into(imageView);
    }

}
