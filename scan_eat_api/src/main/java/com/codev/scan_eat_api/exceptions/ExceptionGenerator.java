package com.codev.scan_eat_api.exceptions;

public class ExceptionGenerator {

    public static ScanEatException ingredientNotFound(long barcode) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(400, "Ingredient with barcode '" + barcode + "' does not exist"));
    }

    public static ScanEatException unitNotFound(int unitId) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(500, "Unit with id '" + unitId + "' does not exist"));
    }
}
