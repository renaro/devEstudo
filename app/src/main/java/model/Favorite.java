package model;

/**
 * Created by movile on 04/07/15.
 */
public class Favorite {

    private String mSlug;
    private String mTitle;

    public Favorite(String title, String slug) {
        this.mTitle = title;
        this.mSlug = slug;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String mSlug) {
        this.mSlug = mSlug;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
