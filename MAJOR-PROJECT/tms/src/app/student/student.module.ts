import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentRoutingModule } from './student-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EnrolledListComponent } from './components/enrolled-list/enrolled-list.component';
import { SubscribedEnrolledListComponent } from './components/subscribed-enrolled-list/subscribed-enrolled-list.component';
import { ViewMaterialComponent } from './components/view-material/view-material.component';
import { ProfileComponent } from './components/profile/profile.component';
import { UpdatestudentprofileComponent } from './components/updatestudentprofile/updatestudentprofile.component';
import { ChangepasswordComponent } from './components/changepassword/changepassword.component';
import { TutorlistComponent } from './components/tutorlist/tutorlist.component';
import { SearchByTutorNameAndTechnologyPipe } from './utility/search-by-tutor-name-and-technology.pipe';
import { FeedbacktotutorComponent } from './components/feedbacktotutor/feedbacktotutor.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BarRatingModule } from 'ngx-bar-rating';

@NgModule({
  declarations: [
    ProfileComponent,
    UpdatestudentprofileComponent,
    ChangepasswordComponent,
    TutorlistComponent,
    SearchByTutorNameAndTechnologyPipe,
    EnrolledListComponent,
    SubscribedEnrolledListComponent,
    ViewMaterialComponent,
    FeedbacktotutorComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    BarRatingModule
  ]
})
export class StudentModule { }
