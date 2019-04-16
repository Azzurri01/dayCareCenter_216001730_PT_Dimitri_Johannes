package com.djohannes.ac.za.domain;

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

}
