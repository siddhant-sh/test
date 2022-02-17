import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnrolledlistService {


  url = "http://localhost:9090/student/"
  token = sessionStorage['token'];

  options = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  };
  constructor(private _http: HttpClient) { }



  public getPendingEnrolledList(): Observable<any> {

    return this._http.get<any>(this.url + "pendingEnrolledList", this.options);
  }


  public getRejectedEnrolledList(): Observable<any> {

    return this._http.get<any>(this.url + "rejectedEnrolledList", this.options);
  }


  public getSubscribedEnrolledList(): Observable<any> {

    return this._http.get<any>(this.url + 'subscribedEnrolledList', this.options);
  }

  viewAllTutorMaterial(technologyId: any) {
    return this._http.get<any>(this.url+'material/view/'+sessionStorage['id']+'/' + technologyId, this.options)
  }
  downloadMaterial(materialId: any): Observable<Blob> {
    return this._http.get(this.url+'material/download/' + materialId, { headers: { 'Authorization': `Bearer ${this.token}` }, responseType: "blob" });
  }

}
