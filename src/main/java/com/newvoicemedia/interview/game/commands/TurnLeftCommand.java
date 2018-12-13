package com.newvoicemedia.interview.game.commands;

import com.newvoicemedia.interview.game.Direction;
import com.newvoicemedia.interview.game.board.Board;
import com.newvoicemedia.interview.game.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

import static com.newvoicemedia.interview.game.Direction.*;


public class TurnLeftCommand
    implements Command
{
    {
        directions = new ArrayList( Arrays.asList( NORTH, EAST, SOUTH, WEST ) );
    }

    private ArrayList directions;
    private Piece piece;


    public TurnLeftCommand( Board board )
    {
        this.piece = board.piece();
    }


    @Override
    public void execute()
    {
        piece.turn( nextDirectionOnTheLeft() );
    }


    private Direction nextDirectionOnTheLeft()
    {
        return (Direction)directions.get( (directions.indexOf( piece.direction() ) - 1) % 3 );
    }
}
