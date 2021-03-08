package com.ncr.chess;

public enum PieceColor {

  BLACK("MOVE"), WHITE("WHITE");

  private String pieceColor;

  PieceColor(String movementTyp) {
    this.pieceColor = movementTyp;
  }

  public String getPieceColor() {
    return pieceColor;
  }
}
