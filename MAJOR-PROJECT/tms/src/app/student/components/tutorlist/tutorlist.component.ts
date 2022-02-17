import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { FeedbacktotutorService } from '../../utility/feedbacktotutor.service';
import { IEnrollTutor } from '../../utility/ienroll-tutor';
import { ITutor } from '../../utility/itutor';
import { StudentService } from '../../utility/student.service';

@Component({
  selector: 'app-tutorlist',
  templateUrl: './tutorlist.component.html',
  styleUrls: ['./tutorlist.component.scss']
})
export class TutorlistComponent implements OnInit {

  search=""
  tutorList:ITutor[]=[];
  feedbackList=[]
  enrollTutList:IEnrollTutor[]=[]

  constructor(private _router:Router,
  private _studentService:StudentService,
  private _tostr:ToastrService,
  private _modal:NgbModal,
  private _feedbackserv: FeedbacktotutorService
  ) {
    this.getTutorList()
  }

  ngOnInit(): void {
  }

  getTutorList(){
    this._studentService
    .getTutorList()
    .subscribe((data)=>{
      if(data!=null){
      this.tutorList=data
      
      this.getAllFeedback();
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }

  onEnroll(tutorId,technologyId){
    this._studentService
    .enrollRequestToTutor(tutorId,technologyId)
    .subscribe((data)=>{
      if(data!=null){
      this.getTutorList()
      }
      else
      this._tostr.error("Something went wrong, Please relogin")
    });
  }

  getAllFeedback(){
    this._feedbackserv.getAllFeedback().subscribe(data=>{
    this.feedbackList=data;
    this.getEnrollList();
    
    })
  }

  getEnrollList(){
    let i=0
    this.tutorList.forEach(tutor => {
      let count = 0;
      let total = 0;
      this.feedbackList.forEach(element => {
        if (tutor.belongsToTutor.id == element.receiverid) {
          count += 1;
          total += element.rating;
        }
      });
      let rating = total / count;
      this.enrollTutList[i++] = {
        "tutor": tutor,
        "feedback": rating
      }
    })  
  }
}
