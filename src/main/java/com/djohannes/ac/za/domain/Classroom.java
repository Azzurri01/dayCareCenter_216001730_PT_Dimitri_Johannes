package com.djohannes.ac.za.domain;

public class Classroom
{
    private int cRoomNo;

    private Classroom()
    {

    }

    public int getRoomNo()
    {
        return cRoomNo;
    }

    public Classroom(Builder builder)
    {
        this.cRoomNo=builder.roomNo;
    }

    public static class Builder
    {
        private int roomNo;

        public Builder getRoom(int room)
        {
            this.roomNo=room;
            return this;
        }

        public Classroom build()
        {
            return new Classroom(this);
        }
    }
}
