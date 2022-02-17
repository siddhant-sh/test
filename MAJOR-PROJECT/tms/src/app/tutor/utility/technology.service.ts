import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TechnologyService {

  private url = "http://localhost:9090/tutor"
  token = sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  constructor(
    private _http: HttpClient
  ) { }

  getTechnologyList(): Observable<any> {
    return this._http.get<any>('http://localhost:9090/user/technology/view/' + sessionStorage['id'], this.httpOption);
  }

  addTechnology(technologyname: string): Observable<any> {
    const body = {
      technologyname: technologyname,
      tutorId: sessionStorage['id']
    }
    return this._http.post<any>(this.url + '/technology/add', body, this.httpOption);
  }

  viewAllTutorMaterial(technologyId:any) {
    return this._http.get<any>(this.url+'/material/view/'+sessionStorage['id']+'/' + technologyId, this.httpOption)
  }

  addMaterial(technologyId: any, fileName: string, file: any):Observable<any> {
    const formData: FormData = new FormData();

    formData.append("technologyId",technologyId);
    formData.append("tutorId",sessionStorage['id'])
    formData.append("fileName",fileName);
    formData.append('file', file);
    
    return this._http.post<any>(this.url + '/material/add', formData, this.httpOption)
  }

  downloadMaterial(materialId:any):Observable<Blob> {
    return this._http.get('http://localhost:9090/user/material/download/' + materialId,{ headers: {'Authorization': `Bearer ${this.token}`}, responseType: "blob"});
  }

  deleteMaterial(materialId:any){
    return this._http.delete(this.url+'/material/delete/'+ materialId,this.httpOption);
  }
}
