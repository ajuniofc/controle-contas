package ajuniofc.com.br.controledecontastelas.model;

import java.util.Calendar;

abstract public class Bill {
    private String name;
    private String description;
    private Double paidValue;
    private boolean hasExpiration = false;
    private Calendar expirationDate;
    private boolean status = false;

    public Bill(String name, String description, Calendar expirationDate) {
        this.name = name;
        this.description = description;
        this.expirationDate = expirationDate;
        this.hasExpiration = true;
    }

    public Bill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPaidValue() {
        return paidValue;
    }

    public void setPaidValue(Double paidValue) {
        this.paidValue = paidValue;
    }

    public boolean isHasExpiration() {
        return hasExpiration;
    }

    public void setHasExpiration(boolean hasExpiration) {
        this.hasExpiration = hasExpiration;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getName();
    }
}
