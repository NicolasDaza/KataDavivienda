package com.orangehrm.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrm.interfaces.PIM.PIMUi.*;
import static com.orangehrm.utilities.Constantes.Tiempo_De_Espera;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CreacionTask implements Task {
    private String Nombre;
    private String Apellido;

    public CreacionTask(String Nombre, String Apellido) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public static CreacionTask Creacion(String Nombre, String Apellido) {
        return instrumented(CreacionTask.class, Nombre, Apellido);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(Btn_PIM, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_PIM),
                WaitUntil.the(Btn_Add, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_Add),
                WaitUntil.the(Lbl_Nombre, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Enter.theValue(Nombre).into(Lbl_Nombre),
                WaitUntil.the(Lbl_Apellido, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Enter.theValue(Apellido).into(Lbl_Apellido)
        );

        actor.attemptsTo(
                WaitUntil.the(Btn_Crear, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_Crear)
        );

    }
}
