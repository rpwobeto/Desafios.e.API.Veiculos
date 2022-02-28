package e.com.api.veiculos.api.veiculos.exceptions;

public class DomainNotaFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DomainNotaFoundException(Object id) {
        super("O registro não foi encontrado: ID " + id);
    }
}
