package com.orangehrm.task;


import net.bytebuddy.asm.Advice;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.orangehrm.interfaces.Login.LoginUi.*;
import static com.orangehrm.utilities.Constantes.Tiempo_De_Espera;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;


public class LoginTask implements Task {
    private String Usuario;
    private String Password;
    public LoginTask(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public static LoginTask escribir(String Usuario, String Password) {
        return instrumented(LoginTask.class, Usuario,Password);
    }

    @Override
    public <T extends Actor> void performAs(T Actor) {
        Actor.attemptsTo(
                WaitUntil.the(Lbl_User,isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Enter.theValue(Usuario).into(Lbl_User),
                WaitUntil.the(Lbl_Password,isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Enter.theValue(Password).into(Lbl_Password),
                WaitUntil.the(Btn_Login,isPresent()).forNoMoreThan(Tiempo_De_Espera).seconds(),
                Click.on(Btn_Login)
        );

    }
}
