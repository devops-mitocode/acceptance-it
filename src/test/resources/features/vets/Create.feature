@Crear
Feature: Crear veterinario

  @HappyPath
  Scenario: [POST][201] Crear veterinario exitoso
    When hago una peticion por metodo post a "api/vets" con los datos
      """
      {
         "firstName": "Dany",
         "lastName": "Cenas",
         "specialties": [
             {
                 "id": 1,
                 "name": "abc"
             }
         ]
      }
      """
    And compruebo que la respuesta http tiene el codigo de estado 201
