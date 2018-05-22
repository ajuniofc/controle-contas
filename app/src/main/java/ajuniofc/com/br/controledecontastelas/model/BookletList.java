package ajuniofc.com.br.controledecontastelas.model;

import java.util.List;

public class BookletList {
    private List<Booklet> booklets;

    public BookletList(List<Booklet> booklets) {
        this.booklets = booklets;
    }

    public List<Booklet> getBooklets() {
        return booklets;
    }

    public void setBooklets(List<Booklet> booklets) {
        this.booklets = booklets;
    }
}
