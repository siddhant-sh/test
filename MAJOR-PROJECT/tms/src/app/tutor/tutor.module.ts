import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TutorRoutingModule } from './tutor-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { TechnologyComponent } from './components/technology/technology.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MaterialViewComponent } from './components/material-view/material-view.component';
import { MaterialAddComponent } from './components/material-add/material-add.component';
import { ProfileComponent } from './components/profile/profile.component';
import { UpdatetutorprofileComponent } from './components/updatetutorprofile/updatetutorprofile.component';
import { PendingstudentenrollrequestComponent } from './components/pendingstudentenrollrequest/pendingstudentenrollrequest.component';
import { EnrolledstudentlistComponent } from './components/enrolledstudentlist/enrolledstudentlist.component';
import { ChangepasswordComponent } from './components/changepassword/changepassword.component';
import { BarRatingModule } from 'ngx-bar-rating';



@NgModule({
  declarations: [
    TechnologyComponent,
    MaterialViewComponent,
    MaterialAddComponent,
    ProfileComponent,
    UpdatetutorprofileComponent,
    PendingstudentenrollrequestComponent,
    EnrolledstudentlistComponent,
    ChangepasswordComponent,

  ],
  imports: [
    CommonModule,
    TutorRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    BarRatingModule
  ]
})
export class TutorModule { }
