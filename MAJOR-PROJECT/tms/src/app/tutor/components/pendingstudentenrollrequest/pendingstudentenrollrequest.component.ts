import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-pendingstudentenrollrequest',
  templateUrl: './pendingstudentenrollrequest.component.html',
  styleUrls: ['./pendingstudentenrollrequest.component.scss']
})
export class PendingstudentenrollrequestComponent implements OnInit {

  studentEnrollPendingRequestList:any[]=[]
  constructor(
  private _tutorService:TutorService,
  private _router:Router,
  private _tostr:ToastrService) {}
  
  ngOnInit(): void {
    this.getStudentPendingRequest();
  }

  getStudentPendingRequest(){
    this._tutorService
    .getStudentPendingRequestList()
    .subscribe((data)=>{
      if(data!=null)
      {
        this.studentEnrollPendingRequestList=data
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }
  
  onAccept(enrollid){
    this._tutorService
    .acceptStudentEnrollRequest(enrollid)
    .subscribe((data)=>{
      if(data!=null)
      {
        this.getStudentPendingRequest()
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }

  onReject(enrollid){
    this._tutorService
    .rejectStudentEnrollRequest(enrollid)
    .subscribe((data)=>{
      if(data!=null)
      {
        this.getStudentPendingRequest()
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }
}
