package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Religion
{
    private String faith;

    private Religion()
    {}
    
    public String getFaith() {
        return faith;
    }
    
    public Religion(Builder builder) {
        this.faith =builder.faith;
    }
    
    public static class Builder
    {
        private String faith;
        
        public Builder getmeal(String faith)
        {
            this.faith=faith;
            return this;
        }
        
        public Religion build()
        {
            return new Religion(this);
        }
    }

    @Override
    public String toString() {
        return "Religion{" +
                "faith='" + faith + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Religion religion= (Religion) o;
        return faith.equals(religion.faith);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(faith);
    }
}
