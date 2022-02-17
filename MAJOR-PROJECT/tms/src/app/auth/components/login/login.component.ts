import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { AuthService } from '../../utility/auth.service';
import { ValidatorService } from '../../utility/validator.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  invalidLogin = false
  constructor(
    private fb: FormBuilder,
    private _router: Router,
    private _authserv: AuthService,
    private _toaster: ToastrService,
    private _validatserv : ValidatorService
  ) {
    this.loginForm = fb.group({
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
    })
  }

  ngOnInit(): void {
  }

  get f() { return this.loginForm.controls; }

  onLogin(login: FormGroup) {
    this.submitted = true;
    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }
    this._authserv.authenticate(login.value.email, login.value.password)
      .subscribe(data => {
        if (data.status === "APPROVED") {
          sessionStorage['username']= data.username,
          sessionStorage['token']= data.token,
          sessionStorage['id']=data.id
          if (data.role == "ADMIN")
            this._router.navigate(['/adminhome/admin/reports']);
          if (data.role == "TUTOR")
            this._router.navigate(['/tutorhome/tutor/profile']);
          if (data.role == "STUDENT")
            this._router.navigate(['/studenthome/student/profile']);
          this.invalidLogin = false
          this._toaster.success("Welcome "+data.username)
        }
        else if (data.status === "BLOCKED")
          this._toaster.error(data.username + " your Account has been BLOCKED")
        else
          this._toaster.error(data.username + " your Account approval is " + data.status)
      },
        HttpErrorResponse => {
          if (HttpErrorResponse.status == 401)
          this.loginForm.setValue({ email: '', password: '' })
        this._toaster.error("Wrong Credentials")
        }
      );

  }
}
