package com.newvoicemedia.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName( "Piece" )
public class PieceTest
{
    @Test
    @DisplayName( "" )
    void shouldTurnNorth()
    {
        Piece piece = new Piece();
        piece.turnNorth();

        assertThat( piece.direction() ).isEqualTo( Direction.NORTH );
    }


    @Test
    void shouldTurnSouth()
    {
        Piece piece = new Piece();
        piece.turnSouth();

        assertThat( piece.direction() ).isEqualTo( Direction.SOUTH );
    }


    @Test
    void shouldTurnWest()
    {
        Piece piece = new Piece();
        piece.turnWest();

        assertThat( piece.direction() ).isEqualTo( Direction.WEST );
    }


    @Test
    void shouldTurnEast()
    {
        Piece piece = new Piece();
        piece.turnEast();

        assertThat( piece.direction() ).isEqualTo( Direction.EAST );
    }
}