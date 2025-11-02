package com.orangehrm.stepdefinitions.login;

import com.orangehrm.exceptions.exceptions;
import com.orangehrm.questions.LoginQuestion;
import com.orangehrm.task.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.github.bonigarcia.wdm.WebDriverManager;


import static com.orangehrm.utilities.Constantes.Url_Base;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class LoginStep {

    private static final String ACTOR_NAME = "Usuario";
    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR_NAME);
    }
    @Given("El usuario abre la página de OrangeHRM")
    public void el_usuario_abre_la_página_de_orange_hrm() {
        theActorInTheSpotlight().wasAbleTo(
                Open.url(Url_Base)
        );
    }
    @When("Ingresa usuario {string} y contraseña {string}")
    public void ingresa_usuario_y_contraseña(String Usuario, String Password) {
        theActorInTheSpotlight().attemptsTo(
                LoginTask.escribir(Usuario,Password)
        );
    }
    @Then("Accede al panel principal del sistema")
    public void accede_al_panel_principal_del_sistema() {
        theActorInTheSpotlight().should(
                seeThat(
                        LoginQuestion.VerificarLogin(),is(true)
                ).orComplainWith(exceptions.class,"Ingreso a sistema fallido")
        );
    }
}
