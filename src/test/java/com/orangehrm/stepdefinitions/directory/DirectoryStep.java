package com.orangehrm.stepdefinitions.directory;

import com.orangehrm.exceptions.exceptions;
import com.orangehrm.questions.BuscarQuestion;
import com.orangehrm.task.BuscarTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class DirectoryStep {


    @Given("El administrador busca el empleado con nombre (.*) Y apellido (.*)$")
    public void BusquedaDeEmpleado(String Nombre, String Apellido) {
        theActorInTheSpotlight().attemptsTo(
                BuscarTask.Busqueda(Nombre,Apellido)
        );
    }
    @Then("El sistema muestra al empleado (.*)$")
    public void ResultadoBusqueda(String nombreEmpleado) {
        theActorInTheSpotlight().should(
                seeThat(
                        BuscarQuestion.Busqueda(nombreEmpleado),is(true)
                ).orComplainWith(exceptions.class,"No se lsito el empleado correctamente")
        );}
}
