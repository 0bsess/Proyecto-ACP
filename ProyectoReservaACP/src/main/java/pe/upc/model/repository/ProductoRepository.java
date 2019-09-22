package pe.upc.model.repository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pe.upc.model.entity.Producto;

@Named
public class ProductoRepository  implements Serializable {
private static final long serialVersionUID = 4L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public int insert(Producto producto) throws Exception {
		em.persist(producto);
		return producto.getIdProducto();
	}
	
	
	public int update(Producto producto) throws Exception {
		em.merge(producto);
		return producto.getIdProducto();
	}
	
	
	public void delete(Producto producto) throws Exception {
		em.remove(producto);
	}
	
	
	public List<Producto> findAll() throws Exception{
		List<Producto> productos=new ArrayList<>();
		
		TypedQuery<Producto> query=em.createQuery("FROM Producto p",Producto.class);
		productos=query.getResultList();
		
		return productos;
	}
	
}