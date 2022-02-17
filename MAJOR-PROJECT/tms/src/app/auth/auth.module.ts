import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthRoutingModule } from './auth-routing.module';
import { LoginComponent } from './components/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterTutorComponent } from './components/register-tutor/register-tutor.component';
import { RegisterStudentComponent } from './components/register-student/register-student.component';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterTutorComponent,
    RegisterStudentComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers:[]
})
export class AuthModule { }
