package com.newvoicemedia.interview.game.commands;

import com.newvoicemedia.interview.game.board.Board;


public class MoveCommand
    implements Command
{
    private Board board;


    public MoveCommand( Board board )
    {
        this.board = board;
    }


    @Override
    public void execute()
    {
        board.movePiece();
    }
}
