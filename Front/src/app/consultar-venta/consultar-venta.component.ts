import { Component, OnInit } from '@angular/core';
import { FacturaService } from '../api/facturas.service';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-consultar-venta',
  templateUrl: './consultar-venta.component.html',
  styleUrls: ['./consultar-venta.component.css']
})
export class ConsultarVentaComponent implements OnInit {

  title = 'appBootstrap';

  closeResult: string;
  facturas: any;
  detalleFacturas: Array<any> = [];
  constructor(private facturaService: FacturaService, private modalService: NgbModal) { }

  ngOnInit() {
    this.facturaService.getFacturas().subscribe(
      (res: HttpResponse<any[]>) => {
        this.facturas = res.body;
        this.facturas = this.facturas.data;
      },
      (res: HttpErrorResponse) => this.handleError(res.message)
    );
  }


  modalVerDetalle(content,pos) {
    this.detalleFacturas = this.facturas[pos].items;
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }


  async handleError(messageError: any) {
    alert(messageError);
  }  

}
