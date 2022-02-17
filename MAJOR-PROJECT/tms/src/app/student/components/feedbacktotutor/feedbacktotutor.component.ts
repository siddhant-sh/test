import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { FeedbacktotutorService } from '../../utility/feedbacktotutor.service';

@Component({
  selector: 'app-feedbacktotutor',
  templateUrl: './feedbacktotutor.component.html',
  styleUrls: ['./feedbacktotutor.component.scss']
})
export class FeedbacktotutorComponent implements OnInit {

  tutorUsername:string
  tutorId:number
  feedbackForm: FormGroup;
  submitted = false;
  average:number

  constructor(
    private fb: FormBuilder,
    private _toaster : ToastrService,
    private modal:NgbActiveModal,
    private _feedbackService:FeedbacktotutorService,
    private _router:Router
  ) {
    this.feedbackForm=this.fb.group({
      question_1:['',Validators.required],
      question_2:['',Validators.required],
      question_3:['',Validators.required],
      question_4:['',Validators.required],
      question_5:['',Validators.required],
      question_6:['',Validators.required],
      question_7:['',Validators.required],
      question_8:['',Validators.required],
      question_9:['',Validators.required],
      question_10:['',Validators.required]
    })
   }

  ngOnInit(): void {
  }

  get f() { return this.feedbackForm.controls; }

  onSend(feedback: FormGroup) {
    this.submitted = true;
    this.average=
    (parseInt(feedback.get("question_1").value)+
    parseInt(feedback.get("question_3").value)+
    parseInt(feedback.get("question_2").value)+
    parseInt(feedback.get("question_4").value)+
    parseInt(feedback.get("question_5").value)+
    parseInt(feedback.get("question_6").value)+
    parseInt(feedback.get("question_7").value)+
    parseInt(feedback.get("question_8").value)+
    parseInt(feedback.get("question_9").value)+
    parseInt(feedback.get("question_10").value))/10
    
    if (this.feedbackForm.invalid) {
      return;
    }
    this._feedbackService.feedbackToTutor(this.tutorId,this.tutorUsername,this.average)
    .subscribe(data => {
      this._toaster.success(" Feedback Sent Successful ")
      this.modal.dismiss('ok')
      window.location.reload();
    },
      HttpErrorResponse => {
        if (HttpErrorResponse.status == 401)
        this._toaster.error("Something went Wrong")
      }
      
    );
  }

  onCancel() {
    this.modal.dismiss('cancel')
  }
}
