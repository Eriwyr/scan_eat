package com.codev.scan_eat_api.exceptions;

import org.json.JSONException;

public class ExceptionGenerator {

    public static ScanEatException recipeNotFound(int recipeId) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(300, "Recipe with id '" + recipeId + "' does not exist"));
    }

    public static ScanEatException ingredientNotFound(long barcode) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(400, "Ingredient with barcode '" + barcode + "' does not exist"));
    }

    public static ScanEatException ingredientDetailsLacking(long barcode, JSONException e) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(400, "Can't use ingredient with barcode '" + barcode + "' as there's not enough information about it.\n " + e.getMessage()));
    }

    public static ScanEatException ingredientUnitMappingNotFound(long barcode, String quantityStr) throws ScanEatException {
        throw new ScanEatException(400, new ErrorMessage(400, "Can't use ingredient with barcode '" + barcode + "' as its measuring unit has no mapping and can therefore not be extracted from the following quantity string : '" + quantityStr + "'"));
    }

    public static ScanEatException unitNotFound(int unitId) throws ScanEatException {
        throw new ScanEatException(500, new ErrorMessage(500, "Unit with id '" + unitId + "' does not exist"));
    }
}
