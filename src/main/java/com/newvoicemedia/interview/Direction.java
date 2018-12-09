package com.newvoicemedia.interview;

enum Direction
{
    NORTH( "N" ), SOUTH( "S" ), EAST( "E" ), WEST( "W" );

    private String direction;


    Direction( String direction )
    {
        this.direction = direction;
    }


    public String getDirection()
    {
        return direction;
    }


    @Override
    public String toString()
    {
        return "Direction{" + "direction='" + direction + '\'' + '}';
    }
}
