package com.djohannes.ac.za.domain;

public class Medical
{
    private String mAllergies, mInjection, mDrop, mDate, mDeworming;

    private Medical()
    {

    }

    public String getAllergies() {
        return mAllergies;
    }

    public String getInjection() {
        return mInjection;
    }

    public String getDrop() {
        return mDrop;
    }

    public String getDate() {
        return mDate;
    }

    public String getDeworming() {
        return mDeworming;
    }

    public Medical(Builder builder)
    {
        this.mAllergies=builder.mAllergies;
        this.mInjection=builder.mInjection;
        this.mDrop=builder.mDrop;
        this.mDate=builder.mDate;
        this.mDeworming=builder.mDeworming;
    }

    public static class Builder
    {
        private String mAllergies, mInjection, mDrop, mDate, mDeworming;

        public Builder getAllergy(String allergy)
        {
            this.mAllergies=allergy;
            return this;
        }

        public Builder getInjection(String injection)
        {
            this.mInjection=injection;
            return this;
        }

        public Builder getDrop(String drop)
        {
            this.mDrop=drop;
            return this;
        }

        public Builder getDate(String date)
        {
            this.mDate=date;
            return this;
        }

        public Builder getDeworm(String deworming)
        {
            this.mDeworming=deworming;
            return this;
        }

        public Medical build()
        {
            return new Medical(this);
        }
    }
}
