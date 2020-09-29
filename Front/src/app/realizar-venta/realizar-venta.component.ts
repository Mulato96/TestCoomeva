import { Component, OnInit } from '@angular/core';
import { VentaDTO } from 'app/shared/models/VentaDTO';
import { ClientesService } from 'app/api/clientes.service';
import { ProductosService } from 'app/api/productos.service';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { DetalleVentaDTO } from 'app/shared/models/DetalleVentaDTO';
import { Observable } from 'rxjs';
import { FacturaService } from 'app/api/facturas.service';
import { ClienteDTO } from 'app/shared/models/ClienteDTO';
import { ProductoDTO } from 'app/shared/models/ProductoDTO';

declare var $: any;
@Component({
  selector: 'app-realizar-venta',
  templateUrl: './realizar-venta.component.html',
  styleUrls: ['./realizar-venta.component.css']
})
export class RealizarVentaComponent implements OnInit {

  cliente: ClienteDTO = new ClienteDTO();
  identificacion: number;
  nombreCliente: string;
  noVenta: boolean = true;
  ventaDTO: VentaDTO = new VentaDTO();
  clientes: any;
  productos: any;
  totalPagar: number = 0;
  producto: ProductoDTO;
  precioUnidad: number;
  cantidad: number;
  linesVenta: DetalleVentaDTO = new DetalleVentaDTO();
  dataDetalle: Array<any> = [];
  constructor(private clientesService: ClientesService, private productosService: ProductosService, private facturaService: FacturaService) { }

  ngOnInit() {
    this.productosService.getProductos().subscribe(
      (res: HttpResponse<any[]>) => {
        this.productos = res.body;
        this.productos = this.productos.data;
        console.log(this.productos);
      },
      (res: HttpErrorResponse) => this.handleError(res.message)
    );

    this.clientesService.getClientes().subscribe(
      (res: HttpResponse<any[]>) => {
        this.clientes = res.body;
        this.clientes = this.clientes.data;
        console.log(this.clientes);
      },
      (res: HttpErrorResponse) => this.handleError(res.message)
    );
  }


  async handleError(messageError: any) {
    alert(messageError);
  }


  buscaCliente() {
    for (let i = 0; i < this.clientes.length; i++) {
      if (this.identificacion == this.clientes[i].identificacion) {
        this.nombreCliente = this.clientes[i].nombres;
        this.cliente = this.clientes[i];
        this.noVenta = false;
        break;
      } else {
        if (i = this.clientes.length - 1) {
          this.showNotification('top', 'left', "Cliente No Existe con esa identificacion");
          this.nombreCliente = "Cliente No Existe con esa identificacion";
        }

      }
    }

  }


  datosProducto() {    
    for (let i = 0; i < this.productos.length; i++) {
      if (this.producto.idProducto == this.productos[i].idProducto) {
        this.precioUnidad = this.productos[i].valorUnidad;
        break;
      }
    }
  }

  addProducto() {
    this.linesVenta = new DetalleVentaDTO();
    console.log("valor",this.producto);
    if (this.producto == undefined || this.cantidad == undefined) {
      this.showNotification('top', 'left', "Es necesario elegir un producto y la cantidad deseada");
      return;
    }
    this.linesVenta.producto = this.producto;
    this.linesVenta.cantidad = this.cantidad;
    this.linesVenta.valorUnidad = this.precioUnidad;
    this.linesVenta.valorTotalProd = this.cantidad * this.precioUnidad;
    this.dataDetalle.push(this.linesVenta);
    this.totalPagar = this.totalPagar + this.linesVenta.valorTotalProd;
  }


  eliminaRegistro(pos: number) {
    this.totalPagar = this.totalPagar - this.dataDetalle[pos].valorTotalProd;
    this.dataDetalle.splice(pos, 1);
  }

  showNotification(from, align, mensaje) {
    const type = ['warning'];

    const color = Math.floor((Math.random() * 4) + 1);

    $.notify({
      icon: "notifications",
      message: mensaje

    }, {
        type: type[color],
        timer: 4000,
        placement: {
          from: from,
          align: align
        },
        template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
          '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
          '<i class="material-icons" data-notify="icon">notifications</i> ' +
          '<span data-notify="title">{1}</span> ' +
          '<span data-notify="message">{2}</span>' +
          '<div class="progress" data-notify="progressbar">' +
          '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
          '</div>' +
          '<a href="{3}" target="{4}" data-notify="url"></a>' +
          '</div>'
      });
  }


  guardaVenta() {        
    if (this.dataDetalle.length <= 0) {
      this.showNotification('top', 'left', "No hay productos agregados para guardar venta");
      return;
    }
    this.ventaDTO.fechaVenta = new Date();
    this.ventaDTO.cliente = this.cliente;
    this.ventaDTO.linesVenta = this.dataDetalle;
    this.ventaDTO.valorTotalVenta = this.totalPagar;

    this.subscribeToSaveResponse(this.facturaService.saveVenta(this.ventaDTO));
  }

  private subscribeToSaveResponse(result: Observable<HttpResponse<any>>) {
    result.subscribe((res: HttpResponse<any>) => this.onSaveSuccess(res), (res: HttpErrorResponse) => this.onSaveError(res));
  }

  private onSaveSuccess(data: any) {
    //alerta de bien
    console.log("ddata", data);
  }

  private onSaveError(data: any) {
    //alerta de error
    console.log("ddata error", data);
  }

}
