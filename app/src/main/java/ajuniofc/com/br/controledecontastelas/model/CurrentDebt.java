package ajuniofc.com.br.controledecontastelas.model;

import java.util.Calendar;

/**
 * Created by admin on 10/05/2018.
 */

public class CurrentDebt extends Bill{
    private Double value;

    public CurrentDebt(String name, String description, Calendar expirationDate, Double value) {
        super(name, description, expirationDate);
        this.value = value;
    }

    public CurrentDebt(String name, String description, Double value) {
        super(name, description);
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
