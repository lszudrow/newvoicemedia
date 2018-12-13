package com.newvoicemedia.interview.game.board;

public class Coordinates
{
    private static final String SEPARATOR = " ";

    private Integer x;

    private Integer y;


    Coordinates( Integer x, Integer y )
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
                                  .append( SEPARATOR )
                                  .append( y )
                                  .toString();
    }
}
