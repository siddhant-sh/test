import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { TutorService } from '../../utility/tutor.service';
import { ChangepasswordComponent } from '../changepassword/changepassword.component';
import { UpdatetutorprofileComponent } from '../updatetutorprofile/updatetutorprofile.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  username="";
  email="";
  gender="";
  specialization="";
  experience=""

  constructor(
  private _tutorService:TutorService,
  private _router:Router,
  private _tostr:ToastrService,
  private _modal:NgbModal) {
  }

  ngOnInit(): void {
    this.getTutorDetails();
  }

  getTutorDetails(){
    this._tutorService
    .getTutorDetails()
    .subscribe((data)=>{
      if(data!=null)
      {
      this.username=data.name
      this.email=data.email
      this.gender=data.gender
      this.specialization=data.specialization
      this.experience=data.experience
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }

  onUpdateProfile(username,email,specialization,experience) {
    const modelRef=this._modal.open(UpdatetutorprofileComponent, {size: 'lg'})
    const component=modelRef.componentInstance as UpdatetutorprofileComponent
    component.username = username
    component.email = email                   
    component.specialization = specialization
    component.experience = experience
    modelRef.result.finally(()=>{
      this.getTutorDetails()
    })
  }

  onChangePassword()
  {
    const modelRef=this._modal.open(ChangepasswordComponent, {size: 'lg'})
    modelRef.result.finally(()=>{
      this.getTutorDetails()
    })
  }
}
