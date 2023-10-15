# API Simples de Produto e Categoria feita em Spring Boot
- JAVA RESTful API criada como projeto do bootcamp da DIO Santander

## Diagrama de classes

```mermaid
classDiagram
  class Product {
    - name: String
    - price: Number
    - quantity: Number
    - category: Category
  }
  
  class Category {
    - name: String
    - description: String
  }
  
  Product "1" *-- "1..*" Category
```
