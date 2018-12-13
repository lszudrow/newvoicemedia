package com.newvoicemedia.interview.game;

public enum Direction
{
    NORTH( "N" ), SOUTH( "S" ), EAST( "E" ), WEST( "W" );

    private String direction;


    Direction( String direction )
    {
        this.direction = direction;
    }


    @Override
    public String toString()
    {
        return direction;
    }
}
