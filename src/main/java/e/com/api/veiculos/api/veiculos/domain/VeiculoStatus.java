package e.com.api.veiculos.api.veiculos.domain;

public enum VeiculoStatus {
    SOLD(true), UNSOLD(false);

    private final boolean status;

    // Contrutor para tipos booleanos
    private VeiculoStatus(Boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public static VeiculoStatus valueOf(boolean status) {
        for (VeiculoStatus value : VeiculoStatus.values()) {
            if (value.getStatus() == status) {
                return value;
            }
        }

        // Para código inválido ou inexistente
        throw new IllegalArgumentException("Status do Veículo inválido");
    }
}
