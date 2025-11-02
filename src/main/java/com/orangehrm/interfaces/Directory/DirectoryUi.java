package com.orangehrm.interfaces.Directory;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DirectoryUi {

    public static final Target Btn_Directory = Target
            .the("Modulo Directory")
            .located(By.xpath("//*[text()='Directory']"));

    public static final Target Lbl_Busqueda_Empleado = Target
            .the("Casilla para buscar empleado")
            .located(By.xpath("//div/div[2]/div/div/input"));

    public static final Target Btn_Buscar_Empleado = Target
            .the("Buscar empleado")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target TarjetaEmpleado(String nombre) { return Target
            .the("Tarjeta con el empleado buscado")
            .located(By.xpath("//p[text()='"+nombre+"']"));
    }
}


