package com.newvoicemedia.interview.game.piece;

import com.newvoicemedia.interview.game.Direction;

import static com.newvoicemedia.interview.game.Direction.NORTH;


public class SimplePiece
    implements Piece
{
    private Direction direction;


    public SimplePiece()
    {
        this( NORTH );
    }


    SimplePiece( Direction direction )
    {
        this.direction = direction;
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
