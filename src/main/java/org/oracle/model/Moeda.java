package org.oracle.model;

import java.util.Map;

public class Moeda {
    private String base_code;
    private Map<String, Double> conversion_rates;;

    public Moeda(Moeda moeda) {
        this.base_code = moeda.getBase_code();
        this.conversion_rates = moeda.getConversion_rates();
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "Moeda{" +
                "base_code='" + base_code + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
