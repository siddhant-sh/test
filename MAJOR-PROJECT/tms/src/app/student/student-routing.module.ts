import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnrolledListComponent } from './components/enrolled-list/enrolled-list.component';
import { SubscribedEnrolledListComponent } from './components/subscribed-enrolled-list/subscribed-enrolled-list.component';
import { ViewMaterialComponent } from './components/view-material/view-material.component';
import { ProfileComponent } from './components/profile/profile.component';
import { TutorlistComponent } from './components/tutorlist/tutorlist.component';
import { UpdatestudentprofileComponent } from './components/updatestudentprofile/updatestudentprofile.component';
import { FeedbacktotutorComponent } from './components/feedbacktotutor/feedbacktotutor.component';

const routes: Routes = [
  {path:"profile",component:ProfileComponent},
  {path:"update",component:UpdatestudentprofileComponent},
  {path:"tutorList",component:TutorlistComponent},
  {path:'enrolledlist',component:EnrolledListComponent},
  {path:'subscribedenrolledlist',component:SubscribedEnrolledListComponent},
  {path:'feedbacktotutor',component:FeedbacktotutorComponent},
  {path:'viewmaterial/:id',component:ViewMaterialComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
