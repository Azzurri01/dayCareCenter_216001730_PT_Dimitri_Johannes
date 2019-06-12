package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Classroom
{
    private String id, roomNo;

    private Classroom()
    {

    }

    private Classroom(Builder builder)
    {
        this.id=builder.id;
        this.roomNo =builder.roomNo;
    }

    public String getId() {
        return id;
    }

    public String getRoomNo()
    {
        return roomNo;
    }

    public static class Builder
    {
        private String id, roomNo;

        public Builder copy(Classroom classroom)
        {
            this.id=classroom.id;
            this.roomNo=classroom.roomNo;
            return this;
        }

        public Builder id(String id)
        {
            this.id=id;
            return this;
        }

        public Builder room(String rm)
        {
            this.roomNo=rm;
            return this;
        }

        public Classroom build()
        {
            return new Classroom(this);
        }
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "roomNo='" + roomNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom Classroom = (Classroom) o;
        return id.equals(Classroom.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
