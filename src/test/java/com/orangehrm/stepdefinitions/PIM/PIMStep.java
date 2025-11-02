package com.orangehrm.stepdefinitions.PIM;

import com.orangehrm.exceptions.exceptions;
import com.orangehrm.questions.CreacionQuestion;
import com.orangehrm.task.CreacionTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class PIMStep {

    @Given("El usuario ingresa el nombre (.*) y apellido (.*)$")
    public void CreacionDeEmpleado(String Nombre, String Apellido) {
        theActorInTheSpotlight().attemptsTo(
                CreacionTask.Creacion(Nombre,Apellido)
        );}

    @Then("El sistema muestra un mensaje de éxito confirmando la creación")
    public void ValidacionDeCreacion() {
        theActorInTheSpotlight().should(
                seeThat(
                        CreacionQuestion.CreacionExitosa(),is(true)
                ).orComplainWith(exceptions.class,"El empleado no fue creado")
        );
    }

}
