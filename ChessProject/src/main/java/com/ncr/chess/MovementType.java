package com.ncr.chess;

public enum MovementType {
  MOVE("MOVE"), CAPTURE("CAPTURE");
  private String movementType;

  MovementType(String movementTyp) {
    this.movementType = movementTyp;
  }
  public String getMovementType() {
    return movementType;
  }
}
