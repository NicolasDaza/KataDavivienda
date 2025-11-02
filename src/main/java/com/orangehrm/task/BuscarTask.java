package com.orangehrm.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrm.interfaces.Directory.DirectoryUi.*;
import static com.orangehrm.utilities.Constantes.Tiempo_De_Espera;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class BuscarTask implements Task {
    private String Nombre;
    private String Apellido;

    public BuscarTask(String Nombre, String Apellido) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public static BuscarTask Busqueda(String Nombre, String Apellido) {
        return instrumented(BuscarTask.class, Nombre, Apellido);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Btn_Directory, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_Directory),
                WaitUntil.the(Lbl_Busqueda_Empleado, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Enter.theValue(Nombre + " " + Apellido).into(Lbl_Busqueda_Empleado),
                WaitUntil.the(Btn_Buscar_Empleado, isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_Buscar_Empleado)
        );
    }
}
