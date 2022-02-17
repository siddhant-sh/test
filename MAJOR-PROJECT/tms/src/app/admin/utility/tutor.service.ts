import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TutorService {
  url = "http://localhost:9090/admin"
  token = sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  postId: any;
  errorMessage: any;
  constructor(private _http: HttpClient) { }

  getAllTutorForApproval(): Observable<any> {
    return this._http.get<any>(this.url + "/tutorsForApproval", this.httpOption)
  }

  approvedTutorById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/accepttutor/" + id, this.httpOption)
  }

  blockTutorById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/blocktutor/" + id, this.httpOption)
  }

  rejectTutorById(id: any): Observable<any> {
    return this._http.get<any>(this.url + "/rejecttutor/" + id, this.httpOption)
  }

  getAllApprovedTutor(): Observable<any> {
    return this._http.get<any>(this.url + "/approvedtutors", this.httpOption)
  }
  getAllRejectedTutor(): Observable<any> {
    return this._http.get<any>(this.url + "/rejectedtutors", this.httpOption)
  }
  getAllBlockededStudent(): Observable<any> {
    return this._http.get<any>(this.url + "/blockedtutors", this.httpOption)
  }
  getTechnologyList(tutorId): Observable<any> {
    return this._http.get<any>('http://localhost:9090/user/technology/view/' + tutorId, this.httpOption);
  }
  viewAllTutorMaterial(technologyId:any) {
    return this._http.get<any>('http://localhost:9090/user/material/view/' + technologyId, this.httpOption)
  }
  downloadMaterial(materialId:any):Observable<Blob> {
    return this._http.get('http://localhost:9090/user/material/download/' + materialId,{ headers: {'Authorization': `Bearer ${this.token}`}, responseType: "blob"});
  }
  getFeedback(): Observable<any>{
    return this._http.get<any>("http://localhost:9090/user/feedback/getAll", this.httpOption)    
  }

  getTechnologyCount(): Observable<any>{
    return this._http.get<any>(this.url + "/report/technology", this.httpOption)    
  }

  getMaterialCount(): Observable<any>{
    return this._http.get<any>(this.url + "/report/material", this.httpOption)    
  }
  getMaterialDownloadCount() :Observable<any>{
    return this._http.get<any>(this.url + "/report/material/download", this.httpOption)    
  }
}
