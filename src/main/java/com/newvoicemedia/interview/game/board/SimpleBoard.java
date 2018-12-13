package com.newvoicemedia.interview.game.board;

import com.newvoicemedia.interview.game.piece.Piece;
import com.newvoicemedia.interview.game.piece.SimplePiece;


public class SimpleBoard
    implements Board
{
    private static final int ZERO = 0;
    private static final int DEFAULT_SIZE = 5;

    private Integer size;
    private Piece piece;
    private Coordinates position;


    public SimpleBoard()
    {
        this( DEFAULT_SIZE, new SimplePiece(), new Coordinates( ZERO, ZERO ) );
    }


    SimpleBoard( Integer size, Piece piece, Coordinates position )
    {
        this.size = size;
        this.piece = piece;
        this.position = position;
    }


    @Override
    public void movePiece()
    {
        movePieceInARightDirection();
    }


    @Override
    public Coordinates piecePosition()
    {
        return position;
    }


    @Override
    public Piece piece()
    {
        return piece;
    }


    Integer size()
    {
        return size;
    }


    private void movePieceInARightDirection()
    {
        switch( piece.direction() )
        {
            case NORTH:
                moveNorth();
                break;
            case SOUTH:
                moveSouth();
                break;
            case EAST:
                moveEast();
                break;
            case WEST:
                moveWest();
                break;
        }
    }


    private void moveWest()
    {
        int positionAfterMove = position.getX() - 1;
        position.setX( positionAfterMove < size ? positionAfterMove : position.getX() );
    }


    private void moveEast()
    {
        int positionAfterMove = position.getX() + 1;
        position.setX( positionAfterMove >= ZERO ? positionAfterMove : position.getX() );
    }


    private void moveSouth()
    {
        int positionAfterMove = position.getY() - 1;
        position.setY( positionAfterMove >= ZERO ? positionAfterMove : position.getY() );
    }


    private void moveNorth()
    {
        int positionAfterMove = position.getY() + 1;
        position.setY( positionAfterMove < size ? positionAfterMove : position.getY() );
    }
}