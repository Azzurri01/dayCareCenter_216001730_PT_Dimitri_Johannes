package com.djohannes.ac.za.domain;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@EntityScan
public class Classroom implements Comparable<Classroom>
{
    @Id
    private String id;
    private String roomNo;

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
                "Id='" + id + '\'' +
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

    @Override
    public int compareTo(Classroom classroom) {
        return this.id.compareToIgnoreCase(classroom.id);
    }
}
