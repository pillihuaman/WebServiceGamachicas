package domain.System.BusinessEntity.Base;

public class HomeViewModel {
	public int getIdimagen() {
		return idimagen;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public String getName() {
		return name;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public String getNombreProducto() {
		return NombreProducto;
	}
	public double getPreciomayor() {
		return preciomayor;
	}
	public double getPreciomenor() {
		return preciomenor;
	}
	public int getCountViews() {
		return countViews;
	}
	public void setIdimagen(int idimagen) {
		this.idimagen = idimagen;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public void setNombreProducto(String nombre) {
		NombreProducto = nombre;
	}
	public void setPreciomayor(double preciomayor) {
		this.preciomayor = preciomayor;
	}
	public void setPreciomenor(double preciomenor) {
		this.preciomenor = preciomenor;
	}
	public void setCountViews(int countViews) {
		this.countViews = countViews;
	}
	private int idimagen ;
    private String DESCRIPTION ;
    private String name;
    private int IdProducto;
    private String NombreProducto;
    private double preciomayor; 
    private double preciomenor;
    private int countViews;
    
}
