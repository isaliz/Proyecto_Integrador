import java.util.List;

public interface IDao<T> {
    public List<T> buscarTodos();
    public T agregar(T t);
    public T  modificar(T t);
    public void eliminar(Long id);
}

