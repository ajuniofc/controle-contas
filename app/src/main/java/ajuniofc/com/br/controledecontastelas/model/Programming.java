package ajuniofc.com.br.controledecontastelas.model;

/**
 * Created by admin on 10/05/2018.
 */

public class Programming {
    private boolean isRepeated;
    private BillType type;
    private int numberOfMonths = 0;

    public Programming(boolean isRepeated, BillType type, int numberOfMonths) {
        this.isRepeated = isRepeated;
        this.type = type;
        this.numberOfMonths = numberOfMonths;
    }

    public Programming(boolean isRepeated, BillType type) {
        this.isRepeated = isRepeated;
        this.type = type;
    }

    public boolean isRepeated() {
        return isRepeated;
    }

    public void setRepeated(boolean repeated) {
        isRepeated = repeated;
    }

    public BillType getType() {
        return type;
    }

    public void setType(BillType type) {
        this.type = type;
    }
}
