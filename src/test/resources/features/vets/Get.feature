@Obtener
Feature: Obtener veterinario

  @HappyPath
  Scenario: [GET][200] Obtener veterinario exitoso
    When hago una peticion por metodo get a "api/vets/" con parametro vetId de valor 2
    Then compruebo que el response header tiene la propiedad "content-type" con valor "application/json"
    And compruebo que la respuesta http tiene el codigo de estado 200
    And compruebo que el response body no es vacio
    And compruebo que la propiedad "firstName" tiene de valor "Helen"
    And compruebo que la propiedad "lastName" tiene de valor "Leary"
    And compruebo que la propiedad "specialties" es mayor que 0
