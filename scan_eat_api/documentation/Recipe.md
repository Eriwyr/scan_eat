# Recipe


## Body
| Variable        | Type                       | Example                   |
| -------------   |:--------------------------:| -------------------------:|
| id              | int                        | 84                        |
| title           | string                     | 84                        |
| owner           | string                     | 84                        |
| imageUrl        | string                     | 84                        |
| nutritionalInfo | Map<String,String>         | {"kcal100g":134.45,...}   |
| serving         | [Serving](ErrorMessage.md) | See [Serving](Serving.md) |

## Json
```json
{
    "id": 84,
    "title": "Svensk pølseret",
    "owner": "aaa",
    "imageUrl": "https://www.dk-kogebogen.dk/billeder-opskrifter/vis_billede_stor_slider.php?id=3084&billede=4",
    "servingModifier": 1,
    "ingredients": [
        {
            "quantity": 450,
            "idUnit": 1,
            "ingredientBarcode": 20012878,
            "ingredientName": "Saucisses de francfort",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/20012878/front_fr.24.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 100,
            "idUnit": 1,
            "ingredientBarcode": 26062334,
            "ingredientName": "Oignons Jaunes (Cat.1, Cal. 50/70)",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/26062334/front_fr.6.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 0,
            "idUnit": 1,
            "ingredientBarcode": 3060731005900,
            "ingredientName": "Ciboulette ciselée",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/306/073/100/5900/front_fr.5.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 0,
            "idUnit": 1,
            "ingredientBarcode": 3252378001319,
            "ingredientName": "Sel fin iodé",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/325/237/800/1319/front_fr.79.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 1250,
            "idUnit": 1,
            "ingredientBarcode": 3450970049405,
            "ingredientName": "Filet de pomme de terre",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/345/097/004/9405/front_fr.7.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 1,
            "idUnit": 9,
            "ingredientBarcode": 5410188014211,
            "ingredientName": "Pure Premium Tomate",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/541/018/801/4211/front_fr.6.400.jpg",
            "unitName": "dl"
        },
        {
            "quantity": 22,
            "idUnit": 1,
            "ingredientBarcode": 7613031335107,
            "ingredientName": "Bouillon Kub ® Goût Boeuf dégraissé",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/761/303/133/5107/front_fr.15.400.jpg",
            "unitName": "g"
        },
        {
            "quantity": 75,
            "idUnit": 1,
            "ingredientBarcode": 8712100530463,
            "ingredientName": "Planta Fin Doux",
            "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/871/210/053/0463/front_fr.67.400.jpg",
            "unitName": "g"
        }
    ],
    "nutritionalInfo": {
        "fat100g": "172.63 g",
        "salt100g": "18.94 g",
        "proteins100g": "86.81 g",
        "fiber100g": "2.16 g",
        "kcal100g": "2783.24 kcal",
        "sugars100g": "10.59 g"
    },
    "serving": {
        "recipeId": 84,
        "peopleAmount": 4,
        "content": [
            {
                "quantity": 323.36414,
                "idUnit": 1,
                "ingredientBarcode": 20012878,
                "ingredientName": "Saucisses de francfort",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/20012878/front_fr.24.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 71.858696,
                "idUnit": 1,
                "ingredientBarcode": 26062334,
                "ingredientName": "Oignons Jaunes (Cat.1, Cal. 50/70)",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/26062334/front_fr.6.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 0,
                "idUnit": 1,
                "ingredientBarcode": 3060731005900,
                "ingredientName": "Ciboulette ciselée",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/306/073/100/5900/front_fr.5.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 0,
                "idUnit": 1,
                "ingredientBarcode": 3252378001319,
                "ingredientName": "Sel fin iodé",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/325/237/800/1319/front_fr.79.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 898.2337,
                "idUnit": 1,
                "ingredientBarcode": 3450970049405,
                "ingredientName": "Filet de pomme de terre",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/345/097/004/9405/front_fr.7.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 0.718587,
                "idUnit": 9,
                "ingredientBarcode": 5410188014211,
                "ingredientName": "Pure Premium Tomate",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/541/018/801/4211/front_fr.6.400.jpg",
                "unitName": "dl"
            },
            {
                "quantity": 15.808913,
                "idUnit": 1,
                "ingredientBarcode": 7613031335107,
                "ingredientName": "Bouillon Kub ® Goût Boeuf dégraissé",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/761/303/133/5107/front_fr.15.400.jpg",
                "unitName": "g"
            },
            {
                "quantity": 53.894024,
                "idUnit": 1,
                "ingredientBarcode": 8712100530463,
                "ingredientName": "Planta Fin Doux",
                "ingredientImgUrl": "https://static.openfoodfacts.org/images/products/871/210/053/0463/front_fr.67.400.jpg",
                "unitName": "g"
            }
        ]
    }
}
```
