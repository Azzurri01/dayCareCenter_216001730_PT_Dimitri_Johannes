package com.djohannes.ac.za.domain;

public class Allergy
{
    private String mAllergy;

    private Allergy()
    {

    }

    public String getAllergy() {
        return mAllergy;
    }

    public Allergy(Builder builder)
    {
        this.mAllergy=builder.bAllergy;;
    }

    public static class Builder
    {
        private String mAllergies, mInjection, mDrop, mDate, bAllergy;

        public Builder getAllergy(String allergy)
        {
            this.bAllergy=allergy;
            return this;
        }

        public Allergy build()
        {
            return new Allergy(this);
        }
    }
}
