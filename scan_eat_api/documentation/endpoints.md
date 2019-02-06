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
| barcode     | long           | 3029330003533 |

#### Returns
[Ingredient](Ingredient.md) or [ErrorMessage](ErrorMessage.md)

#### Error codes


## Recipe

### POST /recipes/all
Returns all recipes from the authenticated user

#### Returns
List of Recipes or [ErrorMessage](ErrorMessage.md)

```json
[
  ...
  {
    "id": 77,
    "title": "Pebernødder",
    "owner": "aaa",
    "ingredients": [
        {
            "quantity": 200,
            "idUnit": 1,
            "ingredientBarcode": 3029330003533,
            "ingredientName": "Pain de mie complet",
            "unitName": "g"
        }
    ]
  },
  {
    "id": 78,
    "title": "Rød grød med fløde",
    "owner": "aaa",
    "ingredients": [
       {
            "quantity": 200,
            "idUnit": 1,
            "ingredientBarcode": 3029330003533,
            "ingredientName": "Pain de mie complet",
            "unitName": "g"
       },
       {
            "quantity": 456,
            "idUnit": 1,
            "ingredientBarcode": 5010477301246,
            "ingredientName": "Muesli",
            "unitName": "g"
       }
    ],
  },
  ...
]
```
#### Error codes


### PUT /recipes/create
Creates the recipe delivered in the body of the put request

#### Example body
```json
{
    "title": "Rød grød med fløde",
    "ingredients": [
        {
            "ingredientBarcode": 3029330003533,
            "quantity": 200,
            "idUnit": 1
        },
        {
            "ingredientBarcode": 5010477301246,
            "quantity": 456,
            "idUnit": 1
        }
    ]
}
```

#### Returns
OK response header or [ErrorMessage](ErrorMessage.md)


#### Error codes