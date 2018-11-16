package at.htl.exam01.document;

public class Buch extends Document {

    public String title;

    public Buch(String author, String title) {
        super(author);
        this.author = author;
        this.title = title;
    }

    public String getTitle() {

        return title;
    }
}
