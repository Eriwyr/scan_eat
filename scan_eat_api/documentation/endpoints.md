# Endpoints

## Ingredients

### POST /ingredients/find
Finds an ingredient by barcode. If the ingredient does not exist in the local database orr
the ingredient has not been refreshed for the last 2 hours, the API will update its local
database from https://fr.openfoodfacts.org
#### Example request
/ingredients/find?barcode=3029330003533
#### Parameters
| Name          | Type           | Example       |
| ------------- |:--------------:| -------------:|
| col 3 is      | long           | 3029330003533 |

#### Returns
[Ingredient](Ingredient.md) or [ErrorMessage](ErrorMessage.md)

#### Error codes