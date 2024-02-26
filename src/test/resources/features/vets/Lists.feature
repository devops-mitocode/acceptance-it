@Lista
Feature: Lista de veterinarios

  @HappyPath
  Scenario: [GET][200] Lista de veterinarios exitosa
    When hago una peticion por metodo get a "api/vets"
    Then compruebo que el response header tiene la propiedad "content-type" con valor "application/json"
    And compruebo que la respuesta http tiene el codigo de estado 201
    And compruebo que el response body no es vacio
