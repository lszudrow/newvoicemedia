package com.newvoicemedia.interview.game.board;

import com.newvoicemedia.interview.game.Direction;
import com.newvoicemedia.interview.game.piece.Piece;
import com.newvoicemedia.interview.game.piece.SimplePiece;
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
class SimpleBoardTest
{
    private static final int DEFAULT_SIZE = 5;
    private SimpleBoard simpleBoard;
    private Piece piece;


    @BeforeEach
    void setUp()
    {
        simpleBoard = new SimpleBoard();
        piece = new SimplePiece();
    }


    @Test
    @DisplayName( "should have fixed size" )
    void shouldHaveSize()
    {
        assertThat( simpleBoard.size() ).isEqualTo( DEFAULT_SIZE );
    }


    @Test
    @DisplayName( "should allow player to put piece on it" )
    void shouldAllowToPutAPieceOnIt()
    {
        assertThat( simpleBoard.piece() ).isEqualTo( piece );
    }


    @ParameterizedTest( name = "Case {index} Move one step to: {0} Expected position should be: {1}" )
    @MethodSource( "getMoves" )
    @DisplayName( "should allow player to move piece in different directions" )
    void shouldAllowToMoveAPieceOnIt( Direction direction, String expectedPosition )
    {
        movePieceToTheMiddleOfTheBoard();

        simpleBoard.piece()
                   .turn( direction );
        simpleBoard.movePiece();
        assertThat( simpleBoard.piecePosition()
                               .toString() ).isEqualTo( expectedPosition );
    }


    private void movePieceToTheMiddleOfTheBoard()
    {
        simpleBoard.movePiece();
        simpleBoard.movePiece();
        simpleBoard.piece()
                   .turn( EAST );
        simpleBoard.movePiece();
        simpleBoard.movePiece();
    }


    private static Stream<Arguments> getMoves()
    {
        return Stream.of( Arguments.of( NORTH, "2 3" ), Arguments.of( SOUTH, "2 1" ), Arguments.of( WEST, "1 2" ), Arguments.of( EAST, "3 2" ) );
    }
}