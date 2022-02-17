import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { EnrolledlistService } from '../../utility/enrolledlist.service';
import { FeedbacktotutorComponent } from '../feedbacktotutor/feedbacktotutor.component';
import { FeedbacktotutorService } from '../../utility/feedbacktotutor.service';
import { StudentService } from '../../utility/student.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-subscribed-enrolled-list',
  templateUrl: './subscribed-enrolled-list.component.html',
  styleUrls: ['./subscribed-enrolled-list.component.scss']
})
export class SubscribedEnrolledListComponent implements OnInit {
  id: any = sessionStorage['id'];
  subscribedenrolledlist = []
  feedbackList = []
  tutorList = []
  rating: any

  constructor(private _router: Router,
    private _enrolledListservice: EnrolledlistService,
    private _modal: NgbModal,
    private _feedbackService: FeedbacktotutorService,
    private _studentService: StudentService,
    private toaster: ToastrService) { }

  ngOnInit(): void {
    this.getEnrolledTutorDetails();

  }

  getEnrolledTutorDetails() {
    this._enrolledListservice.getSubscribedEnrolledList().subscribe((data) => {
      this.subscribedenrolledlist = data.reduce((enrolledlist, subscribedtutorslist) => {
        if (subscribedtutorslist.belongsToStudents.id == this.id) {
          enrolledlist.push(subscribedtutorslist);
          return enrolledlist;
        } else return enrolledlist;
      }, []);
      this.getFeddback()
    })
  }

  viewMaterial(technologyid: number) {
    this._router.navigate(['/studenthome/student/viewmaterial/' + technologyid])
  }

  onFeedback(tutorUsername, tutorId) {
    const modelRef = this._modal.open(FeedbacktotutorComponent, { size: 'lg' })
    const component = modelRef.componentInstance as FeedbacktotutorComponent
    component.tutorId = tutorId
    component.tutorUsername = tutorUsername
    modelRef.result.finally(() => {
      this._router.navigate(['/studenthome/student/subscribedenrolledlist'])
    })
  }

  getFeddback() {
    this._feedbackService.getFeedback().subscribe(
      (data) => {
        this.feedbackList = data
        this.getData()
      }
    )
  }

  rateTechnology(i, j, rating) {
    this._studentService.giveRatingToTechnology(this.tutorList[i].enroll[j].id, rating).subscribe(
      (data) => {
        if (data != null) {
          this.toaster.success("Rating submitted successfully")
        }
        else {
          this.toaster.error("please try again")
        }
      }
    )
  }

  getData() {
    let i = 0;
    this.subscribedenrolledlist.forEach(tutor => {
      let rating = 0;
      let technologies = []
      let enrollid = []
      let tut
      this.feedbackList.forEach(feedback => {
        if (tutor.belongsToTutor.id == feedback.receiverid) {
          rating = feedback.rating

        }
      })
      this.subscribedenrolledlist.forEach(tech => {
        if (tutor.belongsToTutor.id == tech.belongsToTutor.id) {
          tut = tutor.belongsToTutor
          technologies.push(tech.belongsToTechnology);
          let enroll = { "id": tech.enrollid }
          enrollid.push(enroll)
        }

      })
      if (i > 0) {
        let status = 0;
        this.tutorList.forEach(tutorN => {
          if (tutorN.tutor.id == tut.id)
            status = 1;
        })
        if (status == 0) {
          if (tutor.belongsToTutor.id != this.tutorList[i - 1].tutor.id) {
            this.tutorList[i++] = {
              "tutor": tut,
              "technologies": technologies,
              "rating": rating,
              "enroll": enrollid
            }
          }
        }
      } else {
        this.tutorList[i++] = {
          "tutor": tut,
          "technologies": technologies,
          "rating": rating,
          "enroll": enrollid
        }
      }
    })
  }


}
