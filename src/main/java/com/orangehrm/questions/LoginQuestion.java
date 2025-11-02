package com.orangehrm.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrm.interfaces.Login.LoginUi.Lbl_Dashboard;
import static com.orangehrm.utilities.Constantes.Tiempo_De_Espera;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class LoginQuestion implements Question<Boolean> {

    public static LoginQuestion VerificarLogin()
    {return new LoginQuestion();}

    @Override
    public Boolean answeredBy (Actor actor){
        actor.attemptsTo(
                WaitUntil.the(Lbl_Dashboard,isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds()
        );
        return Lbl_Dashboard.isVisibleFor(actor);
    }
}
