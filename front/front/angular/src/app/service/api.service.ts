import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { AgremiadoDTO } from '../clases/agremiado-dto';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  [x: string]: any;
  private headerCustom!: HttpHeaders;

  constructor(private httpClient: HttpClient) {
  }

  buscarAgremiado(data: string): Observable<any> {

    this.headerCustom = new HttpHeaders({
      Authorization: `Bearer ${""}`
    });

    return this.httpClient.get(`${environment.apiUrl+"/agremiado/listarAgremiados"}?data=${data}`,
      {headers: this.headerCustom});
  }

  ultimoCodigo():Observable<any>{
    return this.httpClient.get(`${environment.apiUrl+"/Agremiacion/ultimoCodigo"}`);
  }

  agremiar(agremiadoDTO:AgremiadoDTO,matricula:string): Observable<any>{
    const headers = { 'Content-Type': 'application/json' };
    return this.httpClient.post(`${environment.apiUrl+"/Agremiacion/agremiar"}?matricula=${matricula}`,agremiadoDTO, {headers});
  }
}
export class TrackModel {
  q!: string; 
}
