package ajuniofc.com.br.controledecontastelas.model;

import java.util.Calendar;

/**
 * Created by admin on 10/05/2018.
 */

public class MonthlyDebt extends Bill {
    private Programming programming;
    private boolean hasFixedValue;
    private Double value;

    public MonthlyDebt(String name, String description, Calendar expirationDate, Programming programming, Double value, boolean hasFixedValue) {
        super(name, description, expirationDate);
        this.programming = programming;
        this.value = value;
        this.hasFixedValue = hasFixedValue;
    }

    public MonthlyDebt(String name, String description, Programming programming, Double value, boolean hasFixedValue) {
        super(name, description);
        this.programming = programming;
        this.value = value;
        this.hasFixedValue = hasFixedValue;
    }

    public Programming getProgramming() {
        return programming;
    }

    public void setProgramming(Programming programming) {
        this.programming = programming;
    }

    public boolean isHasFixedValue() {
        return hasFixedValue;
    }

    public void setHasFixedValue(boolean hasFixedValue) {
        this.hasFixedValue = hasFixedValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
