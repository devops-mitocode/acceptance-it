package steps;

import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class StepsDefinitios {

	private static final Logger LOGGER = LoggerFactory.getLogger(StepsDefinitios.class);
	private final String ENDPOINT = "http://" + System.getenv().getOrDefault("CONTAINER_IP", "localhost")
			+ ":9966/petclinic/";

	@When("hago una peticion por metodo get a {string}")
	public void hago_una_peticion_por_metodo_get_a(String path) {
		LOGGER.info("ENDPOINT {}", ENDPOINT);
		SerenityRest.when().get(ENDPOINT.concat(path)).andReturn();
	}

	@Then("compruebo que el response header tiene la propiedad {string} con valor {string}")
	public void compruebo_que_el_response_header_tiene_la_propiedad_con_valor(String property, String value) {
		SerenityRest.lastResponse().then().assertThat().header(property, value);
	}

	@Then("compruebo que la respuesta http tiene el codigo de estado {int}")
	public void compruebo_que_la_respuesta_http_tiene_el_codigo_de_estado(Integer statusCode) {
		SerenityRest.lastResponse().then().assertThat().statusCode(statusCode);
	}

	@Then("compruebo que el response body no es vacio")
	public void compruebo_que_el_response_body_no_es_vacio() {
		// SerenityRest.lastResponse().then().assertThat().body("$", Matchers.empty());
		SerenityRest.lastResponse().then().assertThat().body("$", Matchers.not(Matchers.empty()));
	}

	@When("hago una peticion por metodo get a {string} con parametro vetId de valor {int}")
	public void hago_una_peticion_por_metodo_get_a_con_parametro_vet_id_de_valor(String path, Integer parameter) {
		SerenityRest.when().get(ENDPOINT.concat(path).concat(parameter.toString())).andReturn();
	}

	@Then("compruebo que la propiedad {string} tiene de valor {string}")
	public void compruebo_que_la_propiedad_tiene_de_valor(String property, String value) {
		SerenityRest.lastResponse().then().assertThat().body(property, Matchers.is(value));
	}

	@Then("compruebo que la propiedad {string} es mayor que {int}")
	public void compruebo_que_la_propiedad_es_mayor_que(String propiedad, Integer value) {
		SerenityRest.lastResponse().then().assertThat().body(propiedad, Matchers.hasSize(Matchers.greaterThan(value)));
	}

	@When("hago una peticion por metodo post a {string} con los datos")
	public void hago_una_peticion_por_metodo_post_a_con_los_datos(String path, String docString) {
		SerenityRest.given().header("Content-Type", "application/json").body(docString).when()
				.post(ENDPOINT.concat(path)).andReturn();
	}

	@When("hago una peticion por metodo get a URL")
	public void hago_una_peticion_por_metodo_get_a_url() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
