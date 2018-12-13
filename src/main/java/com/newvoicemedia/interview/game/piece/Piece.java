package com.newvoicemedia.interview.game.piece;

import com.newvoicemedia.interview.game.Direction;


public interface Piece
{
    void turn( Direction direction );

    Direction direction();
}
