# Endpoints

## Ingredients

### GET /ingredients/find
Finds an ingredient by barcode. If the ingredient does not exist in the local database orr
the ingredient has not been refreshed for the last 2 hours, the API will update its local
database from https://fr.openfoodfacts.org
#### Example request
/ingredients/find?barcode=3029330003533
#### Parameters
| Name          | Type           | Example       |
| ------------- |:--------------:| -------------:|
| barcode     | long           | 3029330003533   |

#### Returns
[Ingredient](Ingredient.md) or [ErrorMessage](ErrorMessage.md)

#### Error codes


## Recipe

### POST /recipes/all
Returns all recipes from the authenticated user

#### Returns
List of [Recipes](Recipe.md) or [ErrorMessage](ErrorMessage.md)


#### Error codes


### PUT /recipes/find
Creates the recipe delivered in the body of the put request

#### Example request
/recipes/find?recipeId=84
#### Parameters
| Name          | Type           | Example       |
| ------------- |:--------------:| -------------:|
| recipeId      | int            | 84            |


#### Returns
[Recipe](Recipe.md) or [ErrorMessage](ErrorMessage.md)


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
            "idUnit": 1,
            "ingredientImgUrl": "https://scontent-cdt1-1.xx.fbcdn.net/v/t1.0-9/28504_114053001970492_2271173_n.jpg?_nc_cat=104&_nc_ht=scontent-cdt1-1.xx&oh=07830119ea6bff6606b627af73d82990&oe=5CB81BBA"
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

### GET /recipes/serving
Calculates the ingredient amount for a certain amount of people for a certain recipe

#### Example request
/recipes/serving?recipeId=84&people=4
#### Parameters
| Name          | Type           | Example       |
| ------------- |:--------------:| -------------:|
| recipeId      | integer        | 84            |
| people        | integer        | 4             |

#### Returns
[Serving](Serving.md) or [ErrorMessage](ErrorMessage.md)

#### Error codes



## Units

### GET /units/all
Returns all units

#### Returns
List of [Units](Unit.md)

#### Error codes


### GET /units/find

#### Example request
/ingredients/find?id=1
#### Parameters
| Name          | Type           | Example       |
| ------------- |:--------------:| -------------:|
| id            | integer        | 1             |

#### Returns
[Unit](Unit.md) or [ErrorMessage](ErrorMessage.md)

#### Error codes