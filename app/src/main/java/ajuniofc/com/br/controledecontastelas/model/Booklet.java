package ajuniofc.com.br.controledecontastelas.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Booklet {

    private String title;
    private String description;
    private Calendar creationDate;
    private BookletType type;
    private List<Bill> bills;

    public Booklet(String titulo, String descricao, Calendar creationDate, BookletType type, List<Bill> bills) {
        this.title = titulo;
        this.description = descricao;
        this.creationDate = creationDate;
        this.type = type;
        this.bills = bills;
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

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public BookletType getType() {
        return type;
    }

    public void setType(BookletType type) {
        this.type = type;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getStringDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(this.creationDate.getTime());
    }
}