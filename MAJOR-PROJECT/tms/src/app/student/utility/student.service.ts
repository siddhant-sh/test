import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  
  private url = "http://localhost:9090/student"
  token= sessionStorage['token']
  httpOption = {
    headers: new HttpHeaders({
      'Authorization': `Bearer ${this.token}`
    })
  }
  constructor(private _http:HttpClient) { }

  getStudentDetails():Observable<any> {
    return this._http.get<any>(this.url+"/"+ sessionStorage["id"],this.httpOption)
  }

  updateStudent(body:any):Observable<any> {
    return this._http.put<any>(this.url+"/"+sessionStorage["id"],body,this.httpOption)
  }

  changePassword(body: any):Observable<any> {
    return this._http.put<any>(this.url+"/changePassword/"+sessionStorage["id"],body,this.httpOption)
  }

  getTutorList():Observable<any> {
    return this._http.get<any>(this.url+"/tutorList/"+sessionStorage["id"],this.httpOption)
  }
  
  enrollRequestToTutor(tutorId: any, technologyId: any):Observable<any> {
    const body={
      tutorId:tutorId,
      technologyId:technologyId,
      studentId:sessionStorage["id"]
    }
    return this._http.post<any>(this.url+"/enrollRequestToTutor",body,this.httpOption)  
  }

  giveRatingToTechnology(enrollId,rating):Observable<any>{
    const body={
      enrollId:enrollId,
      rating:rating
    }
    return this._http.post<any>(this.url+"/technology/rating",body,this.httpOption) 
  }
}
 