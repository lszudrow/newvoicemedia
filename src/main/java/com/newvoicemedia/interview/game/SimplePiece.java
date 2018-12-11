package com.newvoicemedia.interview.game;

import static com.newvoicemedia.interview.game.Direction.*;


public class SimplePiece
    implements Piece
{
    private Direction direction;


    SimplePiece( Direction direction )
    {
        this.direction = direction;
    }


    public SimplePiece()
    {
        this( NORTH );
    }


    @Override
    public void turn( Direction direction )
    {
        this.direction = direction;
    }


    @Override
    public Direction direction()
    {
        return direction;
    }
}
