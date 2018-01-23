package dongyang.jeff.recyclerview;

/**
 * Created by song on 2018-01-23.
 */

public class RecycylerItem {
    private String title;
    private String description;

    public RecycylerItem() {
    }

    public RecycylerItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
