package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Activity
{
    private String name, id;


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Activity(Builder builder)
    {
        this.id =builder.id;
        this.name =builder.name;
    }

    public static class Builder
    {
        private String name, id;

        public Builder getID(String id)
        {
            this.id =id;
            return this;
        }

        public Builder getName(String name)
        {
            this.name =name;
            return this;
        }

        public Activity build()
        {
            return new Activity(this);
        }
    }

    @Override
    public String toString() {
        return "Activity{" +
                "ActivityID='" + id + '\'' +
                ", ActivityName='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
