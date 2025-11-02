package com.orangehrm.questions;

import com.orangehrm.interfaces.Directory.DirectoryUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class BuscarQuestion implements Question<Boolean> {

    private final String nombre;

    public BuscarQuestion(String nombre) {
        this.nombre = nombre;
    }

    public static Question<Boolean> Busqueda(String nombre) {
        return new BuscarQuestion(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return DirectoryUi.TarjetaEmpleado(nombre).isVisibleFor(actor);
    }
}
