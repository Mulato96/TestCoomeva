import { ProductoDTO } from "./ProductoDTO";

export class DetalleVentaDTO {	
	public producto: ProductoDTO;	
	public cantidad: number;
	public valorUnidad: number;
	public valorTotalProd: number;
}
