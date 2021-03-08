package com.ncr.chess;

import com.ncr.chess.exception.ChessBoardUnSupportedOperationException;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
public class ChessBoard {
  private static final Logger logger = LogManager.getLogger(ChessBoard.class);
  public static int MAX_BOARD_WIDTH = 7;
  public static int MAX_BOARD_HEIGHT = 7;
  private static Pawn[][] pieces;

  public ChessBoard() {
    pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
  }

  public static void setPieces(int xCoordinate, int yCoordinate, Pawn pawn) {
    pieces[xCoordinate][yCoordinate] = pawn;
  }

  public static Pawn getPieces(int xCoordinate, int yCoordinate) {
    return pieces[xCoordinate][yCoordinate];
  }

  /**
   * This method adds piece on chess board if X and Y coordinates are valid
   * and no piece is available in that position
   *
   * @param pawn        input piece pawn object
   * @param xCoordinate input X coordinate
   * @param yCoordinate input Y coordinate
   * @param pieceColor  input piece colour
   * @throws ChessBoardUnSupportedOperationException Exception
   */
  public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) throws ChessBoardUnSupportedOperationException {
    logger.info("In Add Piece method");
    if (this.isLegalBoardPosition(xCoordinate, yCoordinate)) {
      logger.info("IS Legal board position");
      if (this.getPieces(xCoordinate, yCoordinate) instanceof Pawn) {

        pawn.setXCoordinate(-1);
        pawn.setYCoordinate(-1);
      } else {
        logger.info("Setting Pieces");
        this.setPieces(xCoordinate, yCoordinate, pawn);
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
      }
    } else {
      logger.info("IS Not a Legal board position");
      pawn.setXCoordinate(-1);
      pawn.setYCoordinate(-1);
    }
    pawn.setPieceColor(pieceColor);
  }

  /**
   * Utility Method to check if the given Coordinate Positions are valid or not.
   *
   * @param xCoordinate Input X Coordinate
   * @param yCoordinate Input Y Coordinate
   * @return True or False
   * @throws ChessBoardUnSupportedOperationException Exception
   */
  public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) throws ChessBoardUnSupportedOperationException {
    if (xCoordinate >= 0 && xCoordinate < MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < MAX_BOARD_HEIGHT) {
      return true;
    }
    return false;
  }
}
