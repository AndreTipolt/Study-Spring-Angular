package tipolt.andre.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id) {

        super("Registro não encontrado " + id);
    }
}
