package com.newvoicemedia.interview.game;

class Coordinate
{
    public static final String SPACE_CHARACTER = " ";

    private Integer x;

    private Integer y;


    Coordinate( Integer x, Integer y )
    {
        this.x = x;
        this.y = y;
    }


    Integer getX()
    {
        return x;
    }


    void setX( Integer x )
    {
        this.x = x;
    }


    Integer getY()
    {
        return y;
    }


    void setY( Integer y )
    {
        this.y = y;
    }


    @Override
    public String toString()
    {
        return new StringBuilder().append( x )
                                  .append( SPACE_CHARACTER )
                                  .append( y )
                                  .toString();
    }
}
