package com.newvoicemedia.interview.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName( "Game" )
public class GameTest
{

    private Game game;


    @BeforeEach
    void setUp()
    {
        game = new Game();
    }


    @Test
    @DisplayName( "should be available for player to play" )
    public void shouldCreateNewGame()
    {
        assertThat( game ).isNotNull();
    }


    @ParameterizedTest( name = "Case {index} - Commands: {0} Expected result: {1}" )
    @MethodSource( "getCommands" )
    @DisplayName( "should allow player to play with multiple commands" )
    void shouldPlay( String commands, String expectedResult )
    {
        assertThat( game.play( commands ) ).isEqualTo( expectedResult );
    }


    private static Stream<Arguments> getCommands()
    {
        return Stream.of( Arguments.of( "", "0 0 N" ), Arguments.of( "MRMLMRM", "2 2 E" ), Arguments.of( "RMMMLMM", "3 2 N" ),
            Arguments.of( "MMMMM", "0 4 N" ) );
    }
}