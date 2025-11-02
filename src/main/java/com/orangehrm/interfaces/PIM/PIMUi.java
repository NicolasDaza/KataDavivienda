package com.orangehrm.interfaces.PIM;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PIMUi {
    public static final Target Btn_PIM = Target
            .the("Selecciona modulo PIM")
            .located(By.xpath("//*[text()='PIM']"));

    public static final Target Btn_Add = Target
            .the("Agregar Empleado")
            .located(By.xpath("(//button[@type='button'])[5]"));

    public static final Target Lbl_Nombre = Target
            .the("Nombre del empleado")
            .located(By.xpath("//input[@name='firstName']"));

    public static final Target Lbl_Apellido = Target
            .the("Apellido del empleado")
            .located(By.xpath("//input[@name='lastName']"));

    public static final Target Btn_Crear = Target
            .the("Boton Crear Empleado")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target Lbl_Creacion = Target
            .the("Información Personal")
            .located(By.xpath("//label[text()='Employee Full Name']"));

}
