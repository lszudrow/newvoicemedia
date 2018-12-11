package com.newvoicemedia.interview.game;

class Board
{
    private static final int INITIAL = 0;

    private Integer size;
    private Piece piece;
    private Coordinate position;


    Board( Integer size )
    {
        this( size, new SimplePiece(), new Coordinate( INITIAL, INITIAL ) );
    }


    Board( Integer size, Piece piece, Coordinate position )
    {
        this.size = size;
        this.piece = piece;
        this.position = position;
    }


    void movePiece()
    {
        movePieceInARightDirection();
    }


    Integer size()
    {
        return size;
    }


    void putPiece( Piece piece )
    {
        this.piece = piece;
    }


    Piece getPiece()
    {
        return piece;
    }


    Coordinate getPosition()
    {
        return position;
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
        position.setX( positionAfterMove >= INITIAL ? positionAfterMove : position.getX() );
    }


    private void moveSouth()
    {
        int positionAfterMove = position.getY() - 1;
        position.setY( positionAfterMove >= INITIAL ? positionAfterMove : position.getY() );
    }


    private void moveNorth()
    {
        int positionAfterMove = position.getY() + 1;
        position.setY( positionAfterMove < size ? positionAfterMove : position.getY() );
    }
}