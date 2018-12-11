package com.newvoicemedia.interview.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.newvoicemedia.interview.game.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName( "Board" )
public class BoardTest
{
    public static final int BOARD_SIZE = 5;
    private Board board;
    private Piece piece;


    @BeforeEach
    void setUp()
    {
        board = new Board( BOARD_SIZE );
        piece = new SimplePiece();
        board.putPiece( piece );
    }


    @Test
    @DisplayName( "should have fixed size" )
    public void shouldHaveSize()
    {
        assertThat( board.size() ).isEqualTo( BOARD_SIZE );
    }


    @Test
    @DisplayName( "should allow player to put piece on it" )
    void shouldAllowToPutAPieceOnIt()
    {
        assertThat( board.getPiece() ).isEqualTo( piece );
    }


    @ParameterizedTest( name = "Case {index} Move one step to: {0} Expected position should be: {1}" )
    @MethodSource( "getMoves" )
    @DisplayName( "should allow player to move piece in different directions" )
    void shouldAllowToMoveAPieceOnIt( Direction direction, String expectedPosition )
    {
        movePieceToTheMiddleOfTheBoard();

        board.getPiece()
             .turn( direction );
        board.movePiece();
        assertThat( board.getPosition()
                         .toString() ).isEqualTo( expectedPosition );
    }


    private void movePieceToTheMiddleOfTheBoard()
    {
        board.movePiece();
        board.movePiece();
        board.getPiece()
             .turn( EAST );
        board.movePiece();
        board.movePiece();
    }


    private static Stream<Arguments> getMoves()
    {
        return Stream.of( Arguments.of( NORTH, "2 3" ), Arguments.of( SOUTH, "2 1" ), Arguments.of( WEST, "1 2" ), Arguments.of( EAST, "3 2" ) );
    }
}