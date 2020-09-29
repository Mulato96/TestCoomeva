import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ProductosService {
    public resourceUrl = environment.baseUrl;
    constructor(private http: HttpClient) { }
    

    getProductos():Observable<any>{
        return this.http.get<any>(`${this.resourceUrl}/getProductos`, { observe: 'response' });
    }

}
