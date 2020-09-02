public class ImageJson {

    private String copyright;
    private String date;
    private String explanation;
    private String title;
    private String url;
    private String media_type;

    public ImageJson(String copyright, String date, String explanation, String title, String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.title = title;
        this.url = url;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageJson{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
