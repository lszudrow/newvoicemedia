package com.newvoicemedia.interview.game;

import com.newvoicemedia.interview.game.board.SimpleBoard;
import com.newvoicemedia.interview.game.board.Board;
import com.newvoicemedia.interview.game.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class Game
{
    private static final String SEPARATOR = " ";
    private Board board;
    private Map<String, Command> commands;

    {
        board = new SimpleBoard();
        commands = new HashMap<>();
        commands.put( "M", new MoveCommand( board ) );
        commands.put( "L", new TurnLeftCommand( board ) );
        commands.put( "R", new TurnRightCommand( board ) );
    }

    public String play( String commands )
    {
        executeCommands( commands );
        return gameResult();
    }


    private String gameResult()
    {

        return new StringBuffer().append( board.piecePosition()
                                               .toString() )
                                 .append( SEPARATOR )
                                 .append( board.piece()
                                               .direction()
                                               .toString() )
                                 .toString();
    }


    private void executeCommands( String commands )
    {
        Stream.of( commands.trim()
                           .toUpperCase()
                           .split( "" ) )
              .forEach( this::executeCommand );
    }


    private void executeCommand( String command )
    {
        commands.getOrDefault( command, new DoNothingCommand() )
                .execute();
    }
}
