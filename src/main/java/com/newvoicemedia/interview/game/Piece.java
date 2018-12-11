package com.newvoicemedia.interview.game;

public class Piece
    implements PieceInt
{
    private Direction direction;


    Piece( Direction direction )
    {
        this.direction = direction;
    }


    public Piece()
    {
        this( Direction.NORTH );
    }


    @Override
    public void turn( Direction direction )
    {
        this.direction = direction;
    }


    public Direction direction()
    {
        return direction;
    }
}
