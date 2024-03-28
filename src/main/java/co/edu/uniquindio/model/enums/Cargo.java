package co.edu.uniquindio.model.enums;

public enum Cargo {
    GERENTE("Gerente"),
    EMPLEADO("Empleado");

    private String cargo;

    Cargo(String cargo){
        this.cargo = cargo;
    }
}