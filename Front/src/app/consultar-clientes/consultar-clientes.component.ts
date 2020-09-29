import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { ClientesService } from 'app/api/clientes.service';

@Component({
  selector: 'app-consultar-clientes',
  templateUrl: './consultar-clientes.component.html',
  styleUrls: ['./consultar-clientes.component.css']
})
export class ConsultarClientesComponent implements OnInit {
  clientes: any;
  constructor(private clientesService: ClientesService) { }

  ngOnInit() {
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

}
