package com.newvoicemedia.interview.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName( "Piece" )
public class PieceTest
{

    private Piece piece;


    @BeforeEach
    void setUp()
    {
        piece = new Piece();
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
        Piece piece = new Piece();

        piece.turn( firstTurn );
        piece.turn( secondTurn );
        piece.turn( thirdTurn );

        Direction expectedDirection = thirdTurn;
        Direction actualDirection = piece.direction();

        assertThat( actualDirection ).isEqualTo( expectedDirection );
    }


    private static Stream<Arguments> getDirection()
    {
        return Stream.of( Arguments.of( Direction.EAST ), Arguments.of( Direction.WEST ), Arguments.of( Direction.NORTH ),
            Arguments.of( Direction.SOUTH ) );
    }


    private static Stream<Arguments> getDirections()
    {
        return Stream.of( Arguments.of( Direction.EAST, Direction.WEST, Direction.NORTH ),
            Arguments.of( Direction.SOUTH, Direction.NORTH, Direction.WEST ), Arguments.of( Direction.EAST, Direction.SOUTH, Direction.EAST ),
            Arguments.of( Direction.NORTH, Direction.WEST, Direction.SOUTH ) );
    }
}