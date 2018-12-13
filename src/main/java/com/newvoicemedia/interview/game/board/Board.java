package com.newvoicemedia.interview.game.board;

import com.newvoicemedia.interview.game.piece.Piece;


public interface Board
{
    void movePiece();

    Coordinates piecePosition();

    Piece piece();
}
