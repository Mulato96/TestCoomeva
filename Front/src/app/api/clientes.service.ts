import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ClientesService {
    public resourceUrl = environment.baseUrl;
    constructor(private http: HttpClient) { }
    

    getClientes():Observable<any>{
        return this.http.get<any>(`${this.resourceUrl}/getClientes`, { observe: 'response' });
    }

}
