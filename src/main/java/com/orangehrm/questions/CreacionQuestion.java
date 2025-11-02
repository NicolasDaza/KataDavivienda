package com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrm.interfaces.PIM.PIMUi.Lbl_Creacion;
import static com.orangehrm.utilities.Constantes.Tiempo_De_Espera;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class CreacionQuestion implements Question<Boolean>  {
    public static CreacionQuestion CreacionExitosa() {

        return new CreacionQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(Lbl_Creacion,isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds()
        );
        return Lbl_Creacion.isVisibleFor(actor);
    }
}
