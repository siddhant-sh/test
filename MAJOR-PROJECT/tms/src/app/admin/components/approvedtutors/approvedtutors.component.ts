import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TutorService } from '../../utility/tutor.service';

@Component({
  selector: 'app-approvedtutors',
  templateUrl: './approvedtutors.component.html',
  styleUrls: ['./approvedtutors.component.scss']
})
export class ApprovedtutorsComponent implements OnInit {
  tutorList = []
  msg: any
  errorMessage: any;
  feedbackList = []
  tutList = []
  rating=3.2
  constructor(private _tutorser: TutorService, private _router: Router) { }
  ngOnInit(): void {
    this.getApprovedTutorlist();
    this.getFeedbackTutor();

  }

  getApprovedTutorlist() {
    this._tutorser.getAllApprovedTutor().subscribe(data => {
      this.tutorList = data;    
    })
  }
  block(id: any) {
    this._tutorser.blockTutorById(id).subscribe({
      next: data => {
        this.msg = data
        this.ngOnInit();
      },

      error: error => {
        this.errorMessage = error.message;
        console.error('There was an error!', error);
      }
    })
  }
  viewTechnologies(tutorId) {
    this._router.navigate(['/adminhome/admin/tutor-technology/' + tutorId]);
  }
  getFeedbackTutor() {
    this._tutorser.getFeedback().subscribe(data => {
      this.feedbackList = data;      
      this.calculateAvg();
    })
  }
  calculateAvg() {
    let i=0
    this.tutorList.forEach(tutor => {
      let count = 0;
      let total = 0;
      this.feedbackList.forEach(element => {
        if (tutor.id == element.receiverid) {
          count += 1;
          total += element.rating;
        }

      });
      let rating = total / count;
      this.tutList[i++] = {
        "tutor": tutor,
        "rating": rating
      }
    })   
  }
}
