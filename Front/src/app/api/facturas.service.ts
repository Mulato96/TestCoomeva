import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { VentaDTO } from 'app/shared/models/VentaDTO';

@Injectable({
    providedIn: 'root'
})
export class FacturaService {
    public resourceUrl = environment.baseUrl;
    constructor(private http: HttpClient) { }
    

    getFacturas():Observable<any>{
        return this.http.get<any>(`${this.resourceUrl}/getFacturas`, { observe: 'response' });
    }


    saveVenta(ventaDTO: VentaDTO): Observable<any> {
        return this.http.post<any>(`${this.resourceUrl}/saveVenta`, ventaDTO, { observe: 'response' });
    }

}
