import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { StudentService } from '../../utility/student.service';
import { ChangepasswordComponent } from '../changepassword/changepassword.component';
import { UpdatestudentprofileComponent } from '../updatestudentprofile/updatestudentprofile.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  student:any;
  username="";
  email="";
  gender="";
  qualification=""

  constructor(
  private _router:Router,
  private _studentService:StudentService,
  private _tostr:ToastrService,
  private _modal:NgbModal) {
  }

  ngOnInit(): void {
    this.getStudentDetails();
  }

  getStudentDetails(){
    this._studentService
    .getStudentDetails()
    .subscribe((data)=>{
      if(data!=null)
      {
      this.username=data.username
      this.email=data.email
      this.gender=data.gender
      this.qualification=data.qualification
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }

  onUpdateProfile(username,email,qualification) {
    const modelRef=this._modal.open(UpdatestudentprofileComponent, {size: 'lg'})
    const component=modelRef.componentInstance as UpdatestudentprofileComponent
    component.username = username
    component.email = email                   
    component.qualification = qualification
    modelRef.result.finally(()=>{
      this.getStudentDetails()
    })
  }

  onChangePassword()
  {
    const modelRef=this._modal.open(ChangepasswordComponent, {size: 'lg'})
    modelRef.result.finally(()=>{
      this.getStudentDetails()
    })
  }

}
