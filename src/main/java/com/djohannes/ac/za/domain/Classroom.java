package com.djohannes.ac.za.domain;
import java.util.Objects;

public class Classroom
{
    private String roomNo;

    private Classroom()
    {

    }

    public String getRoomNo()
    {
        return roomNo;
    }

    public Classroom(Builder builder)
    {
        this.roomNo =builder.roomNo;
    }

    public static class Builder
    {
        private String roomNo;

        public Builder getRoom(String room)
        {
            this.roomNo=room;
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
        return roomNo.equals(Classroom.roomNo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(roomNo);
    }
}
