import { DetalleVentaDTO } from "./DetalleVentaDTO";
import { ClienteDTO } from './ClienteDTO';

export class VentaDTO {
	public cliente: ClienteDTO;
	public fechaVenta: Date = new Date();
	public valorTotalVenta: number;
	public linesVenta: Array<DetalleVentaDTO>;

}
