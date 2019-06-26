package chess.domain.piece;

import chess.domain.Coordinate;
import chess.domain.Position;
import chess.domain.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static chess.domain.utils.InputParser.position;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {

    Piece piece;
    Optional<Team> optionalTargetPieceTeam;
    Position base;

    @BeforeEach
    void setUp() {
        piece = new Queen(Team.BLACK);
        optionalTargetPieceTeam = Optional.of(Team.WHITE);
        base = position("d4");
    }

    @Test
    void 상하_이동_여부_테스트() {
        IntStream.rangeClosed(1, 8)
                .filter(i -> i != 4)
                .forEach(i -> assertTrue(piece.canMove(base, new Position(new Coordinate('d'), new Coordinate(i)), optionalTargetPieceTeam)));
    }

    @Test
    void 좌우_이동_여부_테스트() {
        IntStream.rangeClosed(1, 8)
                .filter(i -> i != 4)
                .forEach(i -> assertTrue(piece.canMove(base, new Position(new Coordinate(i), new Coordinate(4)), optionalTargetPieceTeam)));
    }

    @Test
    void 우상향_대각선_이동_여부_테스트() {
        IntStream.rangeClosed(1, 8)
                .filter(i -> i != 4)
                .forEach(i -> assertTrue(piece.canMove(base, new Position(new Coordinate(i), new Coordinate(i)), optionalTargetPieceTeam)));
    }

    @Test
    void 좌상향_대각선_이동_여부_테스트() {
        IntStream.range(1, 8)
                .filter(i -> i != 4)
                .forEach(i -> assertTrue(piece.canMove(base, new Position(new Coordinate(i), new Coordinate(8 - i)), optionalTargetPieceTeam)));
    }
}