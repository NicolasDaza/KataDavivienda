package com.orangehrm.interfaces.Login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUi {
    private LoginUi() {
    }

    public static final Target Lbl_User = Target
            .the("Campo Usuario")
            .located(By.name("username"));

    public static final Target Lbl_Password = Target
            .the("Campo Contraseña")
            .located(By.name("password"));

    public static final Target Btn_Login = Target
            .the("Boton de Login")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target Lbl_Dashboard = Target
            .the("Titulo del dashboard")
            .located(By.xpath("//span[text()='Dashboard']"));
}
