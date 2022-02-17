import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MaterialAddComponent } from './components/material-add/material-add.component';
import { MaterialViewComponent } from './components/material-view/material-view.component';
import { TechnologyComponent } from './components/technology/technology.component';

import { EnrolledstudentlistComponent } from './components/enrolledstudentlist/enrolledstudentlist.component';
import { PendingstudentenrollrequestComponent } from './components/pendingstudentenrollrequest/pendingstudentenrollrequest.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  {path:"profile",component:ProfileComponent},
  {path:"pendingstudentenrollrequest",component:PendingstudentenrollrequestComponent},
  {path:"enrolledstudentlist",component:EnrolledstudentlistComponent},
  {path:"technology",component:TechnologyComponent},
  {path:"material-view/:id",component:MaterialViewComponent},
  {path:"material-add/:id",component:MaterialAddComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TutorRoutingModule { }
