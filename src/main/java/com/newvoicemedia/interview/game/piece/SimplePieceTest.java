package com.newvoicemedia.interview.game.piece;

import com.newvoicemedia.interview.game.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.newvoicemedia.interview.game.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName( "SimplePiece" )
public class SimplePieceTest
{

    private SimplePiece piece;


    @BeforeEach
    void setUp()
    {
        piece = new SimplePiece();
    }


    @ParameterizedTest( name = "Case {index}: Turn: {0} Expected direction: {0}" )
    @MethodSource( "getDirection" )
    @DisplayName( "should turn and ends up with turn as direction" )
    public void shouldTurn( Direction direction )
    {
        piece.turn( direction );
        Direction expectedDirection = direction;
        Direction actualDirection = piece.direction();

        assertThat( actualDirection ).isEqualTo( expectedDirection );
    }


    @ParameterizedTest( name = "Case {index}: Turns: {0}->{1}->{2} Expected last direction: {2}" )
    @MethodSource( "getDirections" )
    @DisplayName( "should turn multiple times and ends with last turn as direction" )
    public void shouldTurnMultipleTimes( Direction firstTurn, Direction secondTurn, Direction thirdTurn )
    {
        piece.turn( firstTurn );
        piece.turn( secondTurn );
        piece.turn( thirdTurn );

        Direction expectedDirection = thirdTurn;
        Direction actualDirection = piece.direction();

        assertThat( actualDirection ).isEqualTo( expectedDirection );
    }


    private static Stream<Arguments> getDirection()
    {
        return Stream.of( Arguments.of( EAST ), Arguments.of( WEST ), Arguments.of( NORTH ), Arguments.of( SOUTH ) );
    }


    private static Stream<Arguments> getDirections()
    {
        return Stream.of( Arguments.of( EAST, WEST, NORTH ), Arguments.of( SOUTH, NORTH, WEST ), Arguments.of( EAST, SOUTH, EAST ),
            Arguments.of( NORTH, WEST, SOUTH ) );
    }
}