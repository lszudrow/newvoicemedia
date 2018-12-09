package com.newvoicemedia.interview;

public class Piece
{
    private Direction direction;


    Piece()
    {
        direction = Direction.NORTH;
    }


    public void turnNorth()
    {
        direction = Direction.NORTH;
    }


    Direction direction()
    {
        return direction;
    }


    public void turnSouth()
    {
        direction = Direction.SOUTH;
    }


    public void turnEast()
    {
        direction = Direction.EAST;
    }


    public void turnWest()
    {
        direction = Direction.WEST;
    }
}
