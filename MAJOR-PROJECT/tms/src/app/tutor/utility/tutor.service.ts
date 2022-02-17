import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TutorService {
  
  private url = "http://localhost:9090/tutor"
  token= sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  constructor(private _http:HttpClient) { }

  getTutorDetails():Observable<any> {
    return this._http.get<any>(this.url+"/profile/"+ sessionStorage["id"],this.httpOption)
  }

  updateTutor(body:any):Observable<any> {
    return this._http.put<any>(this.url+"/updateprofile/"+sessionStorage["id"],body,this.httpOption)
  }

  getStudentPendingRequestList():Observable<any> {
    return this._http.get<any>(this.url+"/enrollrequest/"+ sessionStorage["id"],this.httpOption)
  }

  rejectStudentEnrollRequest(enrollid: any):Observable<any> {
    return this._http.get<any>(this.url+"/rejectenrollemt/"+ enrollid,this.httpOption)
  }

  acceptStudentEnrollRequest(enrollid: any):Observable<any> {
    return this._http.get<any>(this.url+"/acceptenrollment/"+ enrollid,this.httpOption)
  }
  
  getEnrolledStudentList():Observable<any> {
    return this._http.get<any>(this.url+"/enrolledstudents/"+ sessionStorage["id"],this.httpOption)
  }
  
  blockStudent(enrollid: any):Observable<any> {
    return this._http.get<any>(this.url+"/enrolledstudents/block/"+ enrollid,this.httpOption)
  }
  
  changePassword(body: any):Observable<any> {
    return this._http.put<any>(this.url+"/changePassword/"+sessionStorage["id"],body,this.httpOption)
  }

}
