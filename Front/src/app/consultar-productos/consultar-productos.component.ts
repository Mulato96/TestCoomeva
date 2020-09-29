import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../api/productos.service';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-consultar-productos',
  templateUrl: './consultar-productos.component.html',
  styleUrls: ['./consultar-productos.component.css']
})
export class ConsultarProductosComponent implements OnInit {

  productos: any;  
  constructor(private productosService: ProductosService) { }

  ngOnInit() {
    this.productosService.getProductos().subscribe(
      (res: HttpResponse<any[]>) => {
        this.productos = res.body;
        this.productos = this.productos.data;
        console.log(this.productos);
      },
      (res: HttpErrorResponse) => this.handleError(res.message)
    );
  }



  async handleError(messageError: any) {
    alert(messageError);   
  } 

}
