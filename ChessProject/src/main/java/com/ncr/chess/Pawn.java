package com.ncr.chess;

import static com.ncr.chess.ChessBoard.MAX_BOARD_HEIGHT;
import static com.ncr.chess.ChessBoard.MAX_BOARD_WIDTH;
import static com.ncr.chess.ChessBoard.getPieces;

import com.ncr.chess.exception.ChessBoardUnSupportedOperationException;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@AllArgsConstructor
public class Pawn {
  private static final Logger logger = LogManager.getLogger(Pawn.class);

  private int xCoordinate;
  private int yCoordinate;
  private PieceColor pieceColor;
  private ChessBoard chessBoard;

  public Pawn(PieceColor pieceColor) {
    this.pieceColor = pieceColor;
  }

  /**
   * Moves the Pawn to the next Step.
   *
   * @param movementType Movement Type Enum
   * @param newX         newXCoordinate
   * @param newY         newYCoordinate
   */
  public void move(MovementType movementType, int newX, int newY) throws ChessBoardUnSupportedOperationException {
    if (movementType.equals(MovementType.MOVE)) {
      if (newX >= 0 && newX < MAX_BOARD_WIDTH && newY >= 0 && newY < MAX_BOARD_HEIGHT && !(getPieces(newX, newY) instanceof Pawn)) {
        if (PieceColor.BLACK.equals(getPieceColor()) && newX == getXCoordinate() && newY == getYCoordinate() - 1) {
          setXCoordinate(newX);
          setYCoordinate(newY);
        } else if (PieceColor.WHITE.equals(getPieceColor()) && newX == getXCoordinate() && newY == getYCoordinate() + 1) {
          setXCoordinate(newX);
          setYCoordinate(newY);
        }
      }
    }
    throw new ChessBoardUnSupportedOperationException(movementType.getMovementType());
  }

  @Override
  public String toString() {
    return getCurrentPositionAsString();
  }

  protected String getCurrentPositionAsString() {
    String eol = System.lineSeparator();
    return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
  }
}
